package com.aca.movieimdb.controller;

import com.aca.movieimdb.entity.Comment;
import com.aca.movieimdb.entity.Movie;
import com.aca.movieimdb.entity.User;
import com.aca.movieimdb.repository.MovieRepository;
import com.aca.movieimdb.repository.UserRepository;
import com.aca.movieimdb.service.CommentService;
import com.aca.movieimdb.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final MovieService movieService;
    private final UserRepository userRepository;

    @PostMapping("/movies/{movieId}/comments")
    public String addComment(@PathVariable Long movieId, @RequestBody String content) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail);
        Optional<Movie> optionalMovie = movieService.findById(movieId);
        Movie movie = optionalMovie.get();
        Comment comment = new Comment(content, user, movie, null, new ArrayList<>());
        Comment savedComment = commentService.createComment(comment);
        movie.getComments().add(savedComment);
        movieService.save(movie);
        return "Bravo brother";
    }
}
