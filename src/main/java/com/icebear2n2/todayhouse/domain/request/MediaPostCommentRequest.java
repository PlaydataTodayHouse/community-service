package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.*;

public record MediaPostCommentRequest(Long avatarId, Long mediaPostId, String content) {
    public MediaPostComment toEntity(Avatar avatar, MediaPost mediaPost) {
        return MediaPostComment.builder().avatar(avatar).mediaPost(mediaPost).content(content).build();

    }
}
