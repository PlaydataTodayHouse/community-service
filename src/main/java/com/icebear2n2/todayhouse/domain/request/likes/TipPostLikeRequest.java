package com.icebear2n2.todayhouse.domain.request.likes;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.TipPost;
import com.icebear2n2.todayhouse.domain.entity.likes.TipPostLike;

public record TipPostLikeRequest(Long avatarId, Long tipPostId) {
    public TipPostLike toEntity(Avatar avatar, TipPost tipPost) {
        return TipPostLike.builder().avatar(avatar).tipPost(tipPost).build();
    }
}
