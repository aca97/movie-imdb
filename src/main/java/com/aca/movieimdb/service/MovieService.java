package com.aca.movieimdb.service;

import com.aca.movieimdb.dto.movie.MovieDTO;
import com.aca.movieimdb.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    Optional<Movie> findById(Long movieId);

    Movie save(Movie movie);
    List<MovieDTO> getMovies();
}
