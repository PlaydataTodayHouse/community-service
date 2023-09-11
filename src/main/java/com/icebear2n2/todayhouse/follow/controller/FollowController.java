package com.icebear2n2.todayhouse.follow.controller;

import com.icebear2n2.todayhouse.domain.request.FollowRequest;
import com.icebear2n2.todayhouse.domain.response.FollowResponse;
import com.icebear2n2.todayhouse.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/follow")
@Tag(name = "Follow REST API", description = "팔로우 REST API")
public class FollowController {

    private final FollowService followService;

    @PostMapping("add")
    @Operation(summary = "팔로우 추가", description = "팔로우를 추가할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added follow"),
            @ApiResponse(responseCode = "400", description = "Bad Request or Follow already exists or Self-follow not allowed", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "User Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void addFollow(@RequestBody FollowRequest request) {
        followService.addFollow(request);
    }

    @DeleteMapping("delete")
    @Operation(summary = "팔로우 제거", description = "팔로우를 제거할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully removed follow"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Follow or User Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void removeFollow(@RequestBody FollowRequest request) {
        followService.removeFollow(request);
    }

    @GetMapping
    @Operation(summary = "팔로우 관계 전체 조회", description = "팔로우에 대한 관계를 조회할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved follows"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public Page<FollowResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return followService.getAll(pageRequest);
    }
}