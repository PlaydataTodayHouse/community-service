package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.HouseTour;
import com.icebear2n2.todayhouse.domain.entity.HouseTourScrap;

public record HouseTourScrapRequest(Long avatarId, Long houseTourId) {
    public HouseTourScrap toEntity(Avatar avatar, HouseTour houseTour) {
        return HouseTourScrap.builder().avatar(avatar).houseTour(houseTour).build();
    }
}
