package com.icebear2n2.todayhouse.domain.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class User {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String phoneNumber;
    private String address;
    private String email;
    private LocalDate birth;
}
