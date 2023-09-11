package com.icebear2n2.todayhouse.domain.request.posts;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.MediaPost;

public record MediaPostRequest(Long avatarId, String spaceInfo) {
    public MediaPost toEntity(Avatar avatar) {
        return MediaPost.builder().spaceInfo(spaceInfo).avatar(avatar).build();
    }
}
