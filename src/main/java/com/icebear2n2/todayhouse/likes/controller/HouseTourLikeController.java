package com.icebear2n2.todayhouse.likes.controller;

import com.icebear2n2.todayhouse.domain.request.HouseTourLikeRequest;
import com.icebear2n2.todayhouse.domain.response.HouseTourLikeResponse;
import com.icebear2n2.todayhouse.likes.service.HouseTourLikeService;
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
@RequestMapping("/api/v1/like/house-tour")
@Tag(name = "House Tour Like REST API", description = "집들이 게시물에 대한 좋아요 REST API")
public class HouseTourLikeController {
    private final HouseTourLikeService houseTourLikeService;

    @PostMapping
    @Operation(summary = "집들이 게시물 좋아요 추가", description = "집들이 게시물에 대해 좋아요를 추가할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added like to the house tour post"),
            @ApiResponse(responseCode = "400", description = "Bad Request or Like already exists", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Avatar or House Tour Post Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void insert(@RequestBody HouseTourLikeRequest request) {
        houseTourLikeService.insert(request);
    }

    @GetMapping
    @Operation(summary = "집들이 게시물 좋아요 관계 전체 조회", description = "좋아요를 받은 게시물에 대해 좋아요를 누른 유저 정보와 해당 게시물 정보를 볼 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved likes for the house tour posts"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public Page<HouseTourLikeResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return houseTourLikeService.getAll(pageRequest);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "집들이 게시물 좋아요 제거", description = "집들이 게시물에 대해 좋아요를 제거할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully removed like from the house tour post"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Like Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void delete(@PathVariable("id") Long houseTourLikeId) {
        houseTourLikeService.delete(houseTourLikeId);
    }
}
