package com.icebear2n2.todayhouse.avatar.controller;

import com.icebear2n2.todayhouse.avatar.service.AvatarService;
import com.icebear2n2.todayhouse.domain.request.AvatarRequest;
import com.icebear2n2.todayhouse.domain.response.AvatarResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/avatars")
@Tag(name = "Avatar REST API", description = "아바타 REST API")
public class AvatarController {

    private final AvatarService avatarService;

    @PostMapping
    @Operation(summary = "아바타 생성", description = "유저 아이디를 통해 해당 유저의 아바타 정보를 작성할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created Avatar"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "User Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void insert(@RequestBody AvatarRequest request) {
        avatarService.insert(request);
    }

    @GetMapping
    @Operation(summary = "아바타 전체 조회", description = "아바타에 대한 전체 정보를 조회할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get avatars"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public Page<AvatarResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return avatarService.getAll(pageRequest);
    }

    @PutMapping("{id}")
    @Operation(summary = "아바타 정보 수정", description = "아바타에 대한 정보를 수정할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully avatar"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Avatar Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public AvatarResponse update(@PathVariable("id") Long avatarId, @RequestBody(required = false) AvatarRequest request) {
        return avatarService.update(avatarId, request);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "아바타 삭제", description = "해당 아이디를 가진 아바타에 대한 정보를 삭제할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully removed avatar"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Avatar Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void delete(@PathVariable("id") Long avatarId) {
        avatarService.delete(avatarId);
    }
}
