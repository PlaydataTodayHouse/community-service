package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourDto;
import com.icebear2n2.todayhouse.domain.entity.HouseTourLike;
import lombok.Getter;

@Getter
public class HouseTourLikeResponse {
    private AvatarDto avatar;
    private HouseTourDto houseTour;

    public HouseTourLikeResponse(HouseTourLike houseTourLike) {
        this.avatar = new AvatarDto(houseTourLike.getAvatar());
        this.houseTour = new HouseTourDto(houseTourLike.getHouseTour());
    }
}
