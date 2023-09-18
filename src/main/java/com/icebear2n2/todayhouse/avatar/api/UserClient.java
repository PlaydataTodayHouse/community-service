package com.icebear2n2.todayhouse.avatar.api;

import com.icebear2n2.todayhouse.domain.response.user.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient("AUTH-SERVICE")
public interface UserClient {
    @GetMapping("/api/v1/auth/findUser/{userId}")
    UserResponse findByUserId(@PathVariable String userId);
}
