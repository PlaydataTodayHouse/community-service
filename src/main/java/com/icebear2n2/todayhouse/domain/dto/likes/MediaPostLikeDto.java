package com.icebear2n2.todayhouse.domain.dto.likes;

import com.icebear2n2.todayhouse.domain.entity.likes.MediaPostLike;
import lombok.Getter;

@Getter
public class MediaPostLikeDto {
    private Long mediaPostLikeId;
    private Long avatarId;
    private Long mediaPostId;

    public MediaPostLikeDto(MediaPostLike mediaPostLike) {
        this.mediaPostLikeId = mediaPostLike.getLikeId();
        this.avatarId = mediaPostLike.getAvatar().getAvatarId();
        this.mediaPostId = mediaPostLike.getMediaPost().getMediaPostId();
    }
}
