package com.aca.movieimdb.repository;

import com.aca.movieimdb.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
