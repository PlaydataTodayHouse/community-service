package com.icebear2n2.todayhouse.domain.dto;

import com.icebear2n2.todayhouse.domain.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserDto {
    private Long userId;
    private String email;
    private String password;
    private String userName;
    private LocalDateTime birth;

    public UserDto(User user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.userName = user.getUserName();
        this.birth = user.getBirth();
    }
}
