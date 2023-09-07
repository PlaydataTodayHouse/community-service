package com.icebear2n2.todayhouse.avatar.controller;

import com.icebear2n2.todayhouse.avatar.service.AvatarService;
import com.icebear2n2.todayhouse.domain.request.AvatarRequest;
import com.icebear2n2.todayhouse.domain.response.AvatarResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/avatars")
public class AvatarController {

    private final AvatarService avatarService;

    @PostMapping
    public void insert(@RequestBody AvatarRequest request) {
        avatarService.insert(request);
    }

    @GetMapping
    public Page<AvatarResponse> getAll(
            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return avatarService.getAll(pageRequest);
    }

    @PutMapping("{id}")
    public AvatarResponse update(@PathVariable("id") Long avatarId, @RequestBody(required = false) AvatarRequest request) {
        return avatarService.update(avatarId, request);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long avatarId) {
        avatarService.delete(avatarId);
    }
}
