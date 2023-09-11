package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.MediaPostLike;

public record MediaPostLikeRequest(Long avatarId, Long mediaPostId) {
    public MediaPostLike toEntity(Avatar avatar, MediaPost mediaPost) {
        return MediaPostLike.builder().avatar(avatar).mediaPost(mediaPost).build();
    }
}
