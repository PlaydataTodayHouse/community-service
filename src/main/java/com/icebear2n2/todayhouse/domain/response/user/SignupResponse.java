package com.icebear2n2.todayhouse.domain.response.user;

import com.icebear2n2.todayhouse.domain.dto.user.UserDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignupResponse{

    private UserDto user;
    private String redirect;
}
