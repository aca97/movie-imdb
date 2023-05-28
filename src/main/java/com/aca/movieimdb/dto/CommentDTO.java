package com.aca.movieimdb.dto;

import com.aca.movieimdb.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long id;
    private String content;
    private UserDTO user;
    private List<CommentDTO> replies;
}