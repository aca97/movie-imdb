package com.aca.movieimdb.service.impl;

import com.aca.movieimdb.entity.Comment;
import com.aca.movieimdb.entity.Movie;
import com.aca.movieimdb.entity.User;
import com.aca.movieimdb.repository.CommentRepository;
import com.aca.movieimdb.repository.UserRepository;
import com.aca.movieimdb.service.CommentService;
import com.aca.movieimdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final UserRepository userRepository;
    private final MovieService movieService;
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(UserRepository userRepository, MovieService movieService, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.movieService = movieService;
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment createComment(Comment comment, Long movieId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail);
        Optional<Movie> optionalMovie = movieService.findById(movieId);
        Movie movie = optionalMovie.orElseThrow(() -> new RuntimeException("Movie not found"));
        comment.setUser(user);
        comment.setMovie(movie);
        comment.setLevel(0L);
        comment.setParentComment(null);
        comment.setReplies(new ArrayList<>());
        Comment savedComment = commentRepository.save(comment);
        movie.getComments().add(savedComment);
        movieService.save(movie);
        return savedComment;
    }

    @Override
    public List<Comment> getComments(Movie movie) {
        return commentRepository.findByMovie(movie);
    }

    @Override
    public Comment createReply(Comment reply, Long parentCommentId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail);
        Comment parentComment = findCommentById(parentCommentId);
        reply.setUser(user);
        reply.setMovie(parentComment.getMovie());
        reply.setLevel(parentComment.getLevel() + 1);
        reply.setParentComment(parentComment);
        parentComment.getReplies().add(reply);
        return commentRepository.save(reply);
    }


    @Override
    public Comment findCommentById(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }
}
