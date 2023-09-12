package com.icebear2n2.todayhouse.domain.request.user;

import com.icebear2n2.todayhouse.domain.entity.user.User;

import java.util.UUID;

public record UserRequest(UUID id, String name, String number) {

    public User toEntity() {
        return User.builder().id(id).name(name).number(number).build();
    }
}
