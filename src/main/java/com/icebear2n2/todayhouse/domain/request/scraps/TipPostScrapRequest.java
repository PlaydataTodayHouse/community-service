package com.icebear2n2.todayhouse.domain.request.scraps;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.TipPost;
import com.icebear2n2.todayhouse.domain.entity.scraps.TipPostScrap;

public record TipPostScrapRequest(Long avatarId, Long tipPostId) {
    public TipPostScrap toEntity(Avatar avatar, TipPost tipPost) {
        return TipPostScrap.builder().avatar(avatar).tipPost(tipPost).build();
    }
}
