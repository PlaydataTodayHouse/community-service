package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.*;

public record TipPostScrapRequest(Long avatarId, Long tipPostId) {
    public TipPostScrap toEntity(Avatar avatar, TipPost tipPost) {
        return TipPostScrap.builder().avatar(avatar).tipPost(tipPost).build();
    }
}
