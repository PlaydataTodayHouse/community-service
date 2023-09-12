package com.icebear2n2.todayhouse.user.controller;

import com.icebear2n2.todayhouse.domain.entity.user.User;
import com.icebear2n2.todayhouse.domain.request.user.SignupRequest;
import com.icebear2n2.todayhouse.domain.request.user.UserRequest;
import com.icebear2n2.todayhouse.domain.response.user.SignupResponse;
import com.icebear2n2.todayhouse.user.config.JwtService;
import com.icebear2n2.todayhouse.user.config.TokenInfo;
import com.icebear2n2.todayhouse.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService service;
    private final JwtService jwtService;
    @PostMapping("check")
    public SignupResponse check(
            @RequestHeader("Authorization") String token
    ){
        TokenInfo tokenInfo = jwtService.parseToken(
                token.replace("Bearer ", ""));
        return service.checkSignup(tokenInfo);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody UserRequest request){
        service.save(request);
    }
    @GetMapping("me")
    public User getMe(@RequestHeader("Authorization") String token){
        TokenInfo tokenInfo = jwtService.parseToken(
                token.replace("Bearer ", ""));
        return service.getMe(tokenInfo);
    }
    @PostMapping("signup")
    public SignupResponse signup(
            @RequestBody SignupRequest request,
            @RequestHeader("Authorization") String token){
        TokenInfo tokenInfo = jwtService.parseToken(
                token.replace("Bearer ", ""));
        return service.signup(request, tokenInfo);
    }

    @GetMapping("{id}")
    public User getById(@PathVariable String id){
        return service.getById(UUID.fromString(id));
    }


}
