package com.icebear2n2.todayhouse.posts.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.config.exception.AvatarNotFoundException;
import com.icebear2n2.todayhouse.config.exception.MediaPostNotFoundException;
import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.MediaPost;
import com.icebear2n2.todayhouse.domain.request.posts.MediaPostRequest;
import com.icebear2n2.todayhouse.domain.response.posts.MediaPostResponse;
import com.icebear2n2.todayhouse.posts.repository.MediaPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MediaPostService {
    private final MediaPostRepository mediaPostRepository;
    private final AvatarRepository avatarRepository;

    //    TODO: MediaPOST CREATE
    public void insert(MediaPostRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(AvatarNotFoundException::new);
        mediaPostRepository.save(request.toEntity(avatar));
    }

    //    TODO: MediaPOST READ
    public Page<MediaPostResponse> getAll(PageRequest request) {
        Page<MediaPost> all = mediaPostRepository.findAll(request);
        return all.map(MediaPostResponse::new);
    }

    //    TODO: MediaPOST UPDATE
    public MediaPostResponse update(Long mediaPostId, MediaPostRequest request) {
        MediaPost mediaPost = mediaPostRepository.findById(mediaPostId).orElseThrow(MediaPostNotFoundException::new);
        mediaPost.UpdateMediaPost(request.spaceInfo());
        mediaPostRepository.save(mediaPost);
        return new MediaPostResponse(mediaPost);
    }


    //    TODO: MediaPOST DELETE

    public void delete(Long mediaPostId) {
        MediaPost mediaPost = mediaPostRepository.findById(mediaPostId).orElseThrow(MediaPostNotFoundException::new);
        mediaPostRepository.deleteById(mediaPost.getMediaPostId());
    }
}
