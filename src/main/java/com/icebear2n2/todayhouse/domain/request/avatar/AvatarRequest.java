package com.icebear2n2.todayhouse.domain.request.avatar;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.user.User;

import java.util.UUID;

public record AvatarRequest(UUID userId, String nickname, String gender, String picture, String about) {
    public Avatar toEntity(User user) {
        return Avatar.builder().user(user).nickname(nickname).gender(gender).picture(picture).about(about).build();
    }
}
