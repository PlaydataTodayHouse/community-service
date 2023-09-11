package com.icebear2n2.todayhouse.scraps.controller;

import com.icebear2n2.todayhouse.domain.request.scraps.MediaPostScrapRequest;
import com.icebear2n2.todayhouse.domain.response.scraps.MediaPostScrapResponse;
import com.icebear2n2.todayhouse.scraps.service.MediaPostScrapService;
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
@RequestMapping("/api/v1/scrap/media-post")
@Tag(name = "Media Post Scrap REST API", description = "사진/동영상 게시물에 대한 스크랩 REST API")
public class MediaPostScrapController {
    private final MediaPostScrapService mediaPostScrapService;

    @PostMapping
    @Operation(summary = "사진/동영상 게시물 좋아요 추가", description = "사진/동영상 게시물에 대해 스크랩을 추가할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added Scrap to the media post"),
            @ApiResponse(responseCode = "400", description = "Bad Request or Scrap already exists", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Avatar or media post Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void insert(@RequestBody MediaPostScrapRequest request) {
        mediaPostScrapService.insert(request);
    }

    @GetMapping
    @Operation(summary = "사진/동영상 게시물 스크랩 관계 전체 조회", description = "스크랩을 받은 게시물에 대해 스크랩을 누른 유저 정보와 해당 게시물 정보를 볼 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved scraps for the media posts"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public Page<MediaPostScrapResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return mediaPostScrapService.getAll(pageRequest);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "사진/동영상 게시물 스크랩 제거", description = "사진/동영상 게시물에 대해 스크랩을 제거할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully removed scrap from the media post"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Scrap Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void delete(@PathVariable("id") Long mediaPostScrapId) {
        mediaPostScrapService.delete(mediaPostScrapId);
    }
}
