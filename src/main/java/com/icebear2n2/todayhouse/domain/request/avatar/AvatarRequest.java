package com.icebear2n2.todayhouse.domain.request.avatar;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;

public record AvatarRequest(String userId, String nickname, String gender, String picture, String about) {
    public Avatar toEntity() {
        return Avatar.builder()
                .userId(userId)
                .nickname(nickname)
                .gender(gender)
                .picture(picture)
                .about(about)
                .build();
    }
}