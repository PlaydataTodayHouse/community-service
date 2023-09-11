package com.icebear2n2.todayhouse.posts.service;

import com.icebear2n2.todayhouse.avatar.repository.AvatarRepository;
import com.icebear2n2.todayhouse.config.exception.AvatarNotFoundException;
import com.icebear2n2.todayhouse.config.exception.HouseTourNotFoundException;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.HouseTour;
import com.icebear2n2.todayhouse.domain.request.HouseTourRequest;
import com.icebear2n2.todayhouse.domain.response.HouseTourResponse;
import com.icebear2n2.todayhouse.posts.repository.HouseTourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HouseTourService {

    private final HouseTourRepository houseTourRepository;
    private final AvatarRepository avatarRepository;

    //    TODO: HouseTour CRUD

    //    TODO: HouseTour CREATE
    public void insert(HouseTourRequest request) {
        Avatar avatar = avatarRepository.findById(request.avatarId()).orElseThrow(AvatarNotFoundException::new);
        houseTourRepository.save(request.toEntity(avatar));
    }

//    TODO: HouseTour READ

    public Page<HouseTourResponse> getAll(PageRequest request) {
        Page<HouseTour> all = houseTourRepository.findAll(request);
        return all.map(HouseTourResponse::new);
    }

    //    TODO: HouseTour UPDATE
    public HouseTourResponse update(Long houseTourId, HouseTourRequest request) {
        HouseTour houseTour = houseTourRepository.findById(houseTourId).orElseThrow(HouseTourNotFoundException::new);
        houseTour.UpdateHouseTour(
                request.housingType(), request.roomCount(), request.direction(), request.location(),
                request.familyType(), request.petPresence(), request.familyCount(), request.workField(),
                request.worker(), request.duration(), request.budget(), request.copyrightNotice(),
                request.title(), request.content()
        );
        houseTourRepository.save(houseTour);

        return new HouseTourResponse(houseTour);
    }

    //    TODO: HouseTour DELETE
    public void delete(Long houseTourId) {
        HouseTour houseTour = houseTourRepository.findById(houseTourId).orElseThrow(HouseTourNotFoundException::new);
        houseTourRepository.deleteById(houseTour.getHouseTourId());
    }
}
