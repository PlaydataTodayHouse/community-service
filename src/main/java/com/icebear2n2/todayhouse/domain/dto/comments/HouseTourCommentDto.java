package com.icebear2n2.todayhouse.domain.dto.comments;

import com.icebear2n2.todayhouse.domain.entity.comments.HouseTourComment;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class HouseTourCommentDto {
    private Long houseTourCommentId;
    private String content;
    private Timestamp createdAt;

    public HouseTourCommentDto(HouseTourComment houseTourComment) {
        this.houseTourCommentId = houseTourComment.getHouseTourCommentId();
        this.content = houseTourComment.getContent();
        this.createdAt = houseTourComment.getCreatedAt();
    }
}
