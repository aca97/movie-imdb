package com.aca.movieimdb.service;

import com.aca.movieimdb.entity.Comment;
import com.aca.movieimdb.entity.Movie;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);
    List<Comment> getComments(Movie movie);
    Comment createReply(Comment reply, Comment parentComment);

}
