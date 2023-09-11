package com.icebear2n2.todayhouse.scraps.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.config.exception.*;
import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.HouseTour;
import com.icebear2n2.todayhouse.domain.entity.scraps.HouseTourScrap;
import com.icebear2n2.todayhouse.domain.request.scraps.HouseTourScrapRequest;
import com.icebear2n2.todayhouse.domain.response.scraps.HouseTourScrapResponse;
import com.icebear2n2.todayhouse.posts.repository.HouseTourRepository;
import com.icebear2n2.todayhouse.scraps.repository.HouseTourScrapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HouseTourScrapService {
    private final HouseTourScrapRepository houseTourScrapRepository;
    private final AvatarRepository avatarRepository;
    private final HouseTourRepository houseTourRepository;

//    TODO: Scrap CRD

    //    TODO: Scrap CREATE
    public void insert(HouseTourScrapRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(AvatarNotFoundException::new);
        HouseTour houseTour = houseTourRepository.findById(request.houseTourId()).orElseThrow(HouseTourNotFoundException::new);
        Boolean existsByAvatarAvatarIdAndHouseTourHouseTourId = houseTourScrapRepository.existsByAvatar_AvatarIdAndHouseTour_HouseTourId(avatar.getAvatarId(), houseTour.getHouseTourId());
        if (!existsByAvatarAvatarIdAndHouseTourHouseTourId) {
            HouseTourScrap houseTourScrap = request.toEntity(avatar, houseTour);
            houseTourScrapRepository.save(houseTourScrap);
        } else {
            throw new ExistScrapException();
        }

    }

    //    TODO: Scrap READ
    public Page<HouseTourScrapResponse> getAll(PageRequest request) {
        Page<HouseTourScrap> all = houseTourScrapRepository.findAll(request);
        return all.map(HouseTourScrapResponse::new);
    }

    //    TODO: Scrap DELETE
    public void delete(Long houseTourScrapId) {
        HouseTourScrap houseTourScrap = houseTourScrapRepository.findById(houseTourScrapId).orElseThrow(ScrapNotFoundException::new);
        houseTourScrapRepository.deleteById(houseTourScrap.getScrapId());
    }
}
