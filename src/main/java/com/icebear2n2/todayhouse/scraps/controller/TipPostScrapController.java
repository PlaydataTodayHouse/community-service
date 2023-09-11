package com.icebear2n2.todayhouse.scraps.controller;

import com.icebear2n2.todayhouse.domain.request.TipPostScrapRequest;
import com.icebear2n2.todayhouse.domain.response.TipPostScrapResponse;
import com.icebear2n2.todayhouse.scraps.service.TipPostScrapService;
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
@RequestMapping("/api/v1/scrap/tip-post")
@Tag(name = "Tip Post Scrap REST API", description = "노하우 게시물에 대한 스크랩 REST API")
public class TipPostScrapController {
    private final TipPostScrapService tipPostScrapService;

    @PostMapping
    @Operation(summary = "노하우 게시물 좋아요 추가", description = "노하우 게시물에 대해 스크랩을 추가할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added Scrap to the tip post"),
            @ApiResponse(responseCode = "400", description = "Bad Request or Scrap already exists", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Avatar or tip post Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void insert(@RequestBody TipPostScrapRequest request) {
        tipPostScrapService.insert(request);
    }

    @GetMapping
    @Operation(summary = "노하우 게시물 스크랩 관계 전체 조회", description = "스크랩을 받은 게시물에 대해 스크랩을 누른 유저 정보와 해당 게시물 정보를 볼 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved scraps for the tip posts"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public Page<TipPostScrapResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return tipPostScrapService.getAll(pageRequest);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "노하우 게시물 스크랩 제거", description = "노하우 게시물에 대해 스크랩을 제거할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully removed scrap from the tip post"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Scrap Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void delete(@PathVariable("id") Long tipPostScrapId) {
        tipPostScrapService.delete(tipPostScrapId);
    }
}
