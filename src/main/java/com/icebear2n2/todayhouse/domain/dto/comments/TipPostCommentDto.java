package com.icebear2n2.todayhouse.domain.dto.comments;

import com.icebear2n2.todayhouse.domain.entity.comments.TipPostComment;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class TipPostCommentDto {
    private Long tipPostCommentId;
    private String content;
    private Timestamp createdAt;

    public TipPostCommentDto(TipPostComment tipPostCommentId) {
        this.tipPostCommentId = tipPostCommentId.getTipPostCommentId();
        this.content = tipPostCommentId.getContent();
        this.createdAt = tipPostCommentId.getCreatedAt();
    }
}
