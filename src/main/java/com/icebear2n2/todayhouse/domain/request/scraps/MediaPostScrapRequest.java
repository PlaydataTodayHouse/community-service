package com.icebear2n2.todayhouse.domain.request.scraps;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.scraps.MediaPostScrap;

public record MediaPostScrapRequest(Long avatarId, Long mediaPostId) {
    public MediaPostScrap toEntity(Avatar avatar, MediaPost mediaPost) {
        return MediaPostScrap.builder().avatar(avatar).mediaPost(mediaPost).build();
    }
}
