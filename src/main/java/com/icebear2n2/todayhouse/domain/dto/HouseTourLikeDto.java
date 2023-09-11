package com.icebear2n2.todayhouse.domain.dto;

import com.icebear2n2.todayhouse.domain.entity.HouseTourLike;
import lombok.Getter;

@Getter
public class HouseTourLikeDto {
    private Long houseTourLikeId;
    private Long avatarId;
    private Long houseTourId;

    public HouseTourLikeDto(HouseTourLike houseTourLike) {
        this.houseTourLikeId = houseTourLike.getLikeId();
        this.avatarId = houseTourLike.getAvatar().getAvatarId();
        this.houseTourId = houseTourLike.getHouseTour().getHouseTourId();
    }
}
