package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourLikeDto;
import com.icebear2n2.todayhouse.domain.entity.HouseTourLike;
import lombok.Getter;

@Getter
public class HouseTourLikeResponse extends HouseTourLikeDto {

    public HouseTourLikeResponse(HouseTourLike houseTourLike) {
        super(houseTourLike);
    }
}
