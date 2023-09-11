package com.icebear2n2.todayhouse.posts.controller;

import com.icebear2n2.todayhouse.domain.request.HouseTourRequest;
import com.icebear2n2.todayhouse.domain.response.HouseTourResponse;
import com.icebear2n2.todayhouse.posts.service.HouseTourService;
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
@RequestMapping("/api/v1/posts/house-tour")
@Tag(name = "House Tour REST API", description = "집들이 게시물 REST API")
public class HouseTourController {

    private final HouseTourService houseTourService;

    @PostMapping
    @Operation(summary = "집들이 게시물 작성", description = "집들이 게시물에 대한 정보를 작성할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added house tour post"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "Avatar Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void insert(@RequestBody HouseTourRequest request) {
        houseTourService.insert(request);
    }

    @GetMapping
    @Operation(summary = "집들이 게시물 전체 조회", description = "집들이 게시물에 대한 전체 정보를 조회할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully get house tour posts"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public Page<HouseTourResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page
    ) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return houseTourService.getAll(pageRequest);
    }

    @PutMapping("{id}")
    @Operation(summary = "집들이 게시물 수정", description = "집들이 게시물에 대한 정보를 수정할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated house tour post"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "House Tour Post Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public HouseTourResponse update(@PathVariable("id") Long houseTourId, @RequestBody HouseTourRequest request) {
        return houseTourService.update(houseTourId, request);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "집들이 게시물 삭제", description = "집들이 게시물에 대한 정보를 삭제할 수 있는 메서드 입니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully removed house tour post"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "404", description = "House Tour Post Not Found", content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(hidden = true)))
    })
    public void delete(@PathVariable("id") Long houseTourId) {
        houseTourService.delete(houseTourId);
    }
}
