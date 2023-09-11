package com.icebear2n2.todayhouse.scraps.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.config.exception.*;
import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.scraps.MediaPostScrap;
import com.icebear2n2.todayhouse.domain.request.scraps.MediaPostScrapRequest;
import com.icebear2n2.todayhouse.domain.response.scraps.MediaPostScrapResponse;
import com.icebear2n2.todayhouse.posts.repository.MediaPostRepository;
import com.icebear2n2.todayhouse.scraps.repository.MediaPostScrapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MediaPostScrapService {
    private final MediaPostScrapRepository mediaPostScrapRepository;
    private final AvatarRepository avatarRepository;
    private final MediaPostRepository mediaPostRepository;

//    TODO: Scrap CRD

    //    TODO: Scrap CREATE
    public void insert(MediaPostScrapRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(AvatarNotFoundException::new);
        MediaPost mediaPost = mediaPostRepository.findById(request.mediaPostId()).orElseThrow(MediaPostNotFoundException::new);
        Boolean existsByAvatarAvatarIdAndMediaPostMediaPostId = mediaPostScrapRepository.existsByAvatar_AvatarIdAndMediaPost_MediaPostId(avatar.getAvatarId(), mediaPost.getMediaPostId());
        if (!existsByAvatarAvatarIdAndMediaPostMediaPostId) {
            MediaPostScrap mediaPostScrap = request.toEntity(avatar, mediaPost);
            mediaPostScrapRepository.save(mediaPostScrap);
        } else {
            throw new ExistScrapException();
        }

    }

    //    TODO: Scrap READ
    public Page<MediaPostScrapResponse> getAll(PageRequest request) {
        Page<MediaPostScrap> all = mediaPostScrapRepository.findAll(request);
        return all.map(MediaPostScrapResponse::new);
    }

    //    TODO: Scrap DELETE
    public void delete(Long mediaPostScrapId) {
        MediaPostScrap mediaPostScrap = mediaPostScrapRepository.findById(mediaPostScrapId).orElseThrow(ScrapNotFoundException::new);
        mediaPostScrapRepository.deleteById(mediaPostScrap.getScrapId());
    }
}
