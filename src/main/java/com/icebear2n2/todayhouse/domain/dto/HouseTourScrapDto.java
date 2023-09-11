package com.icebear2n2.todayhouse.domain.dto;

import com.icebear2n2.todayhouse.domain.entity.HouseTourLike;
import com.icebear2n2.todayhouse.domain.entity.HouseTourScrap;
import lombok.Getter;

@Getter
public class HouseTourScrapDto {
    private Long houseTourScrapId;
    private Long avatarId;
    private Long houseTourId;

    public HouseTourScrapDto(HouseTourScrap houseTourScrap) {
        this.houseTourScrapId = houseTourScrap.getScrapId();
        this.avatarId = houseTourScrap.getAvatar().getAvatarId();
        this.houseTourId = houseTourScrap.getHouseTour().getHouseTourId();
    }
}
