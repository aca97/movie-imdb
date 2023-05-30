package com.aca.movieimdb.mapper;

import com.aca.movieimdb.dto.comment.CommentDTO;
import com.aca.movieimdb.dto.movie.MovieDTO;
import com.aca.movieimdb.dto.user.UserDTO;
import com.aca.movieimdb.entity.Comment;
import com.aca.movieimdb.entity.Movie;
import com.aca.movieimdb.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {
    public UserDTO mapUserToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail()
        );
    }
    public CommentDTO mapCommentToDTO(Comment comment) {
        List<CommentDTO> replyDTOs = mapCommentsToDTOs(comment.getReplies());
        return new CommentDTO(
                comment.getId(),
                comment.getContent(),
                mapUserToDTO(comment.getUser()),
                comment.getLevel(),
                replyDTOs
        );
    }
    List<CommentDTO> mapCommentsToDTOs(List<Comment> comments) {
        return comments.stream()
                .map(this::mapCommentToDTO)
                .collect(Collectors.toList());
    }
    public MovieDTO mapToDTO(Movie movie) {
        List<CommentDTO> commentDTOs = mapCommentsToDTOs(movie.getComments());
        return new MovieDTO(
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
}
