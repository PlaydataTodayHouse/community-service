package com.icebear2n2.todayhouse.domain.dto;

import com.icebear2n2.todayhouse.domain.entity.MediaPost;
import lombok.Getter;

@Getter
public class MediaPostDto {
    private Long postId;
    private String spaceInfo;
    private String content;

    public MediaPostDto(MediaPost mediaPost) {
        this.postId = mediaPost.getPostId();
        this.spaceInfo = mediaPost.getSpaceInfo();
        this.content = mediaPost.getContent();
    }
}
