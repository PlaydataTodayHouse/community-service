package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.MediaPostScrap;

public record MediaPostScrapRequest(Long avatarId, Long mediaPostId) {
    public MediaPostScrap toEntity(Avatar avatar, MediaPost mediaPost) {
        return MediaPostScrap.builder().avatar(avatar).mediaPost(mediaPost).build();
    }
}
