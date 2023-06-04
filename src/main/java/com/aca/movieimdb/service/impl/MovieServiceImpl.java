package com.aca.movieimdb.service.impl;

import com.aca.movieimdb.dto.movie.BasicMovieDTO;
import com.aca.movieimdb.dto.movie.MovieDTO;
import com.aca.movieimdb.entity.Movie;
import com.aca.movieimdb.mapper.Mapper;
import com.aca.movieimdb.repository.MovieRepository;
import com.aca.movieimdb.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final Mapper mapper;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository, Mapper mapper) {
        this.movieRepository = movieRepository;
        this.mapper = mapper;
    }

    @Override
    public List<MovieDTO> getMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(mapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BasicMovieDTO> getCarouselMovies() {
        List<Movie> movies = movieRepository.findAll();
        return  movies.stream()
                .map(mapper::mapBasicMovieDTOs)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Movie> findById(Long movieId) {
        return movieRepository.findById(movieId);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
}
