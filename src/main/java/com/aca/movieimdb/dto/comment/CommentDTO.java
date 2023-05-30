package com.aca.movieimdb.dto.comment;

import com.aca.movieimdb.dto.user.UserDTO;
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
    private Long level;

    private List<CommentDTO> replies;
}