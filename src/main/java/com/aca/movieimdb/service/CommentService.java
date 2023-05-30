package com.aca.movieimdb.service;

import com.aca.movieimdb.entity.Comment;
import com.aca.movieimdb.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    Comment createComment(Comment comment, Long movieId);
    List<Comment> getComments(Movie movie);
    Comment createReply(Comment reply, Long parentCommentId);
    Comment findCommentById(Long id);
}
