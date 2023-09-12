package com.icebear2n2.todayhouse.domain.dto.user;

import com.icebear2n2.todayhouse.domain.entity.user.User;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UserDto {
    private UUID id;
    private String name;
    private String number;
    private String address;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.number = user.getNumber();
        this.address = user.getAddress();
    }
}
