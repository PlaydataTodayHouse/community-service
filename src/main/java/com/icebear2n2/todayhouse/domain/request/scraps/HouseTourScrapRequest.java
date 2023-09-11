package com.icebear2n2.todayhouse.domain.request.scraps;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.HouseTour;
import com.icebear2n2.todayhouse.domain.entity.scraps.HouseTourScrap;

public record HouseTourScrapRequest(Long avatarId, Long houseTourId) {
    public HouseTourScrap toEntity(Avatar avatar, HouseTour houseTour) {
        return HouseTourScrap.builder().avatar(avatar).houseTour(houseTour).build();
    }
}
