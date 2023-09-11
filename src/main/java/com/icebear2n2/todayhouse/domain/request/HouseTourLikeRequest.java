package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.HouseTour;
import com.icebear2n2.todayhouse.domain.entity.HouseTourLike;

public record HouseTourLikeRequest(Long avatarId, Long houseTourId) {
    public HouseTourLike toEntity(Avatar avatar, HouseTour houseTour) {
        return HouseTourLike.builder().avatar(avatar).houseTour(houseTour).build();
    }
}
