package com.icebear2n2.todayhouse.domain.response.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
public class UserResponse {
    private UUID id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private LocalDate birth;
    private String profileImage;
    private String role;
}
