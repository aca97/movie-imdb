package com.aca.movieimdb.service.impl;

import com.aca.movieimdb.entity.Comment;
import com.aca.movieimdb.entity.Movie;
import com.aca.movieimdb.repository.CommentRepository;
import com.aca.movieimdb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getComments(Movie movie) {
        return commentRepository.findByMovie(movie);
    }

    @Override
    public Comment createReply(Comment reply, Comment parentComment) {
        reply.setParentComment(parentComment);
        parentComment.getReplies().add(reply);
        return commentRepository.save(reply);
    }
}
