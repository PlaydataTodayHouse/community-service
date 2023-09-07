package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.*;

public record TipPostCommentRequest(Long avatarId, Long tipPostId, String content) {
    public TipPostComment toEntity(Avatar avatar, TipPost tipPost) {
        return TipPostComment.builder().avatar(avatar).tipPost(tipPost).content(content).build();

    }
}
