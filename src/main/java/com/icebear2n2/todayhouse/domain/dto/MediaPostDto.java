package com.icebear2n2.todayhouse.domain.dto;

import com.icebear2n2.todayhouse.domain.entity.MediaPost;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class MediaPostDto {
    private Long mediaPostId;
    private String spaceInfo;
    private Timestamp createdAt;

    public MediaPostDto(MediaPost mediaPost) {
        this.mediaPostId = mediaPost.getMediaPostId();
        this.spaceInfo = mediaPost.getSpaceInfo();
        this.createdAt = mediaPost.getCreatedAt();
    }
}
