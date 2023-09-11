package com.icebear2n2.todayhouse.domain.dto;

import com.icebear2n2.todayhouse.domain.entity.HouseTourComment;
import com.icebear2n2.todayhouse.domain.entity.MediaPostComment;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class MediaPostCommentDto {
    private Long mediaPostCommentId;
    private String content;
    private Timestamp createdAt;

    public MediaPostCommentDto(MediaPostComment mediaPostComment) {
        this.mediaPostCommentId = mediaPostComment.getMediaPostCommentId();
        this.content = mediaPostComment.getContent();
        this.createdAt = mediaPostComment.getCreatedAt();
    }
}
