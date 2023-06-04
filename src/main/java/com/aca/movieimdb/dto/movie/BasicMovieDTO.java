package com.aca.movieimdb.dto.movie;

import com.aca.movieimdb.dto.comment.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicMovieDTO {
    private Long id;
    private String title;
    private String poster;
}