package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.TipPost;
import com.icebear2n2.todayhouse.domain.entity.TipPostLike;

public record TipPostLikeRequest(Long avatarId, Long tipPostId) {
    public TipPostLike toEntity(Avatar avatar, TipPost tipPost) {
        return TipPostLike.builder().avatar(avatar).tipPost(tipPost).build();
    }
}
