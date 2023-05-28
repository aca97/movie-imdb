package com.aca.movieimdb.service.impl;

import com.aca.movieimdb.dto.CommentDTO;
import com.aca.movieimdb.dto.MovieDto;
import com.aca.movieimdb.dto.UserDTO;
import com.aca.movieimdb.entity.Comment;
import com.aca.movieimdb.entity.Movie;
import com.aca.movieimdb.entity.User;
import com.aca.movieimdb.repository.MovieRepository;
import com.aca.movieimdb.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    @Override
    public List<MovieDto> getMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    private MovieDto mapToDTO(Movie movie) {
        List<CommentDTO> commentDTOs = mapCommentsToDTOs(movie.getComments());
        return new MovieDto(
                movie.getId(),
                movie.getImdbId(),
                movie.getTitle(),
                movie.getReleaseDate(),
                movie.getTrailerLink(),
                movie.getPoster(),
                movie.getBackdrops(),
                movie.getGenres(),
                commentDTOs
        );
    }

    private List<CommentDTO> mapCommentsToDTOs(List<Comment> comments) {
        return comments.stream()
                .map(this::mapCommentToDTO)
                .collect(Collectors.toList());
    }

    private CommentDTO mapCommentToDTO(Comment comment) {
        List<CommentDTO> replyDTOs = mapCommentsToDTOs(comment.getReplies());
        return new CommentDTO(
                comment.getId(),
                comment.getContent(),
                mapUserToDTO(comment.getUser()),
                replyDTOs
        );
    }
    private UserDTO mapUserToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );
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
