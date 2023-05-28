package com.aca.movieimdb.repository;

import com.aca.movieimdb.entity.Comment;
import com.aca.movieimdb.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByMovie(Movie movie);
}
