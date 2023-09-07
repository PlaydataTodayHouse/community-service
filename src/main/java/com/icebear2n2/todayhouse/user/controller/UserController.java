package com.icebear2n2.todayhouse.user.controller;

import com.icebear2n2.todayhouse.domain.entity.User;
import com.icebear2n2.todayhouse.domain.request.SignupRequest;
import com.icebear2n2.todayhouse.domain.request.UserRequest;
import com.icebear2n2.todayhouse.domain.response.SignupResponse;
import com.icebear2n2.todayhouse.user.config.JwtService;
import com.icebear2n2.todayhouse.user.config.TokenInfo;
import com.icebear2n2.todayhouse.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Tag(name = "User REST API", description = "유저 REST API")
public class UserController {

    private final UserService service;
    private final JwtService jwtService;
    @PostMapping("check")
    @Operation(summary = "유저 정보 확인", description = "해당 유저의 회원가입 여부를 체크하는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully create user"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public SignupResponse check(
            @RequestHeader("Authorization") String token
    ){
        TokenInfo tokenInfo = jwtService.parseToken(
                token.replace("Bearer ", ""));
        return service.checkSignup(tokenInfo);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "유저 회원가입", description = "[auth-service] Signup 메서드 요청을 통한 유저 정보 저장 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully create user"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void save(@RequestBody UserRequest request){
        service.save(request);
    }
    @GetMapping("me")
    @Operation(summary = "유저 정보 확인", description = "해당 유저의 정보를 조회하는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get user information."),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public User getMe(@RequestHeader("Authorization") String token){
        TokenInfo tokenInfo = jwtService.parseToken(
                token.replace("Bearer ", ""));
        return service.getMe(tokenInfo);
    }
    @PostMapping("signup")
    @Operation(summary = "유저 회원가입", description = "[auth-service] Signup 메서드 요청을 통한 유저 정보 저장 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully create user"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public SignupResponse signup(
            @RequestBody SignupRequest request,
            @RequestHeader("Authorization") String token){
        TokenInfo tokenInfo = jwtService.parseToken(
                token.replace("Bearer ", ""));
        return service.signup(request, tokenInfo);
    }

    @GetMapping("{id}")
    @Operation(summary = "유저 아이디를 통한 유저 정보 확인", description = "해당 유저 아이디를 통해 유저 정보를 조회하는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get user information."),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public User getById(@PathVariable String id){
        return service.getById(UUID.fromString(id));
    }


}
