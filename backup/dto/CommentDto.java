package com.icebear2n2.todayhouse.domain.dto;

import com.icebear2n2.todayhouse.domain.entity.Comment;
import lombok.Getter;

@Getter
public class CommentDto {
    private Long commentId;
    private String content;

    public CommentDto(Comment comment) {
        this.commentId = comment.getCommentId();
        this.content = comment.getContent();
    }
}
