package com.icebear2n2.todayhouse.domain.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String phoneNumber;
    private String address;
    private String email;
    private LocalDate birth;

    public UserDto(String userId) {
        this.userId = userId;
    }

}
