package com.icebear2n2.todayhouse.scraps.repository;

import com.icebear2n2.todayhouse.domain.entity.HouseTourLike;
import com.icebear2n2.todayhouse.domain.entity.HouseTourScrap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseTourScrapRepository extends JpaRepository<HouseTourScrap, Long> {
    Page<HouseTourScrap> findAll(Pageable request);

    Boolean existsByAvatar_AvatarIdAndHouseTour_HouseTourId(Long avatarId, Long houseTourId);
}
