package com.icebear2n2.todayhouse.domain.request.likes;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.likes.MediaPostLike;

public record MediaPostLikeRequest(Long avatarId, Long mediaPostId) {
    public MediaPostLike toEntity(Avatar avatar, MediaPost mediaPost) {
        return MediaPostLike.builder().avatar(avatar).mediaPost(mediaPost).build();
    }
}
