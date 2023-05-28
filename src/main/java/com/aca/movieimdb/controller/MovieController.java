package com.aca.movieimdb.controller;

import com.aca.movieimdb.dto.MovieDto;
import com.aca.movieimdb.entity.Movie;
import com.aca.movieimdb.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public List<MovieDto> getMovies() {
        return movieService.getMovies();
    }

}
