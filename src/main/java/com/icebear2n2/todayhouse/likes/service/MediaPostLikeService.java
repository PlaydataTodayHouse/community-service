package com.icebear2n2.todayhouse.likes.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.exception.AvatarNotFoundException;
import com.icebear2n2.todayhouse.exception.ExistLikeException;
import com.icebear2n2.todayhouse.exception.LikeNotFoundException;
import com.icebear2n2.todayhouse.exception.MediaPostNotFoundException;
import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.likes.MediaPostLike;
import com.icebear2n2.todayhouse.domain.request.likes.MediaPostLikeRequest;
import com.icebear2n2.todayhouse.domain.response.likes.MediaPostLikeResponse;
import com.icebear2n2.todayhouse.posts.repository.MediaPostRepository;
import com.icebear2n2.todayhouse.likes.repository.MediaPostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MediaPostLikeService {
    private final MediaPostLikeRepository mediaPostLikeRepository;
    private final MediaPostRepository mediaPostRepository;
    private final AvatarRepository avatarRepository;

    public void insert(MediaPostLikeRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(AvatarNotFoundException::new);
        MediaPost mediaPost = mediaPostRepository.findById(request.mediaPostId()).orElseThrow(MediaPostNotFoundException::new);

        Boolean existsByAvatarAvatarIdAndMediaPostMediaPostId = mediaPostLikeRepository.existsByAvatar_AvatarIdAndMediaPost_MediaPostId(avatar.getAvatarId(), mediaPost.getMediaPostId());
        if (!existsByAvatarAvatarIdAndMediaPostMediaPostId) {
            MediaPostLike mediaPostLike = request.toEntity(avatar, mediaPost);
            mediaPostLikeRepository.save(mediaPostLike);
        } else {
            throw new ExistLikeException();
        }
    }

    public Page<MediaPostLikeResponse> getAll(PageRequest request) {
        Page<MediaPostLike> all = mediaPostLikeRepository.findAll(request);
        return all.map(MediaPostLikeResponse::new);
    }

    public void delete(Long mediaPostLikeId) {
        MediaPostLike mediaPostLike = mediaPostLikeRepository.findById(mediaPostLikeId).orElseThrow(LikeNotFoundException::new);
        mediaPostLikeRepository.deleteById(mediaPostLike.getLikeId());
    }
}
