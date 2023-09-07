package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.MediaPostDto;
import com.icebear2n2.todayhouse.domain.entity.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.MediaPostLike;
import lombok.Getter;

@Getter
public class MediaPostLikeResponse {
    private AvatarDto avatar;
    private MediaPostDto mediaPost;

    public MediaPostLikeResponse(MediaPostLike mediaPostLike) {
        this.avatar = new AvatarDto(mediaPostLike.getAvatar());
        this.mediaPost = new MediaPostDto(mediaPostLike.getMediaPost());
    }
}
