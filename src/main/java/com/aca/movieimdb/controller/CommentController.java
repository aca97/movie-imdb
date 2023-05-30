package com.aca.movieimdb.controller;

import com.aca.movieimdb.dto.comment.CommentDTO;
import com.aca.movieimdb.entity.Comment;
import com.aca.movieimdb.mapper.Mapper;
import com.aca.movieimdb.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
@ResponseBody
public class CommentController {
    private final CommentService commentService;
    private final Mapper mapper;

    @PostMapping("/movies/{movieId}/comments")
    public CommentDTO addComment(@PathVariable Long movieId, @RequestBody String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        Comment savedComment = commentService.createComment(comment, movieId);
        return mapper.mapCommentToDTO(savedComment);
    }

    @PostMapping("/comments/{parentCommentId}/replies")
    public ResponseEntity<CommentDTO> addReplyToComment(
            @PathVariable Long parentCommentId,
            @RequestBody CommentDTO replyDTO
    ) {
        Comment reply = new Comment();
        reply.setContent(replyDTO.getContent());

        Comment savedReply = commentService.createReply(reply, parentCommentId);

        CommentDTO savedReplyDTO = mapper.mapCommentToDTO(savedReply);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedReplyDTO);
    }
}
