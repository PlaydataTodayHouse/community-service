package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.MediaPost;

public record MediaPostRequest(Long avatarId, String spaceInfo) {
    public MediaPost toEntity(Avatar avatar) {
        return MediaPost.builder().spaceInfo(spaceInfo).avatar(avatar).build();
    }
}
