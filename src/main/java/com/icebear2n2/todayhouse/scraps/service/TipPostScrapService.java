package com.icebear2n2.todayhouse.scraps.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.config.exception.AvatarNotFoundException;
import com.icebear2n2.todayhouse.config.exception.ExistScrapException;
import com.icebear2n2.todayhouse.config.exception.TipPostNotFoundException;
import com.icebear2n2.todayhouse.config.exception.ScrapNotFoundException;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.TipPost;
import com.icebear2n2.todayhouse.domain.entity.TipPostScrap;
import com.icebear2n2.todayhouse.domain.request.TipPostScrapRequest;
import com.icebear2n2.todayhouse.domain.response.TipPostScrapResponse;
import com.icebear2n2.todayhouse.posts.repository.TipPostRepository;
import com.icebear2n2.todayhouse.scraps.repository.TipPostScrapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TipPostScrapService {
    private final TipPostScrapRepository tipPostScrapRepository;
    private final AvatarRepository avatarRepository;
    private final TipPostRepository tipPostRepository;

//    TODO: Scrap CRD

    //    TODO: Scrap CREATE
    public void insert(TipPostScrapRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(AvatarNotFoundException::new);
        TipPost tipPost = tipPostRepository.findById(request.tipPostId()).orElseThrow(TipPostNotFoundException::new);
        Boolean existsByAvatarAvatarIdAndTipPostTipPostId = tipPostScrapRepository.existsByAvatar_AvatarIdAndTipPost_TipPostId(avatar.getAvatarId(), tipPost.getTipPostId());
        if (!existsByAvatarAvatarIdAndTipPostTipPostId) {
            TipPostScrap tipPostScrap = request.toEntity(avatar, tipPost);
            tipPostScrapRepository.save(tipPostScrap);
        } else {
            throw new ExistScrapException();
        }

    }

    //    TODO: Scrap READ
    public Page<TipPostScrapResponse> getAll(PageRequest request) {
        Page<TipPostScrap> all = tipPostScrapRepository.findAll(request);
        return all.map(TipPostScrapResponse::new);
    }

    //    TODO: Scrap DELETE
    public void delete(Long tipPostScrapId) {
        TipPostScrap tipPostScrap = tipPostScrapRepository.findById(tipPostScrapId).orElseThrow(ScrapNotFoundException::new);
        tipPostScrapRepository.deleteById(tipPostScrap.getScrapId());
    }
}
