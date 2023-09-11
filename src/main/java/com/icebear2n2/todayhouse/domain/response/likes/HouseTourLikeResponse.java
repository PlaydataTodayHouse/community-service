package com.icebear2n2.todayhouse.domain.response.likes;

import com.icebear2n2.todayhouse.domain.dto.likes.HouseTourLikeDto;
import com.icebear2n2.todayhouse.domain.entity.likes.HouseTourLike;
import lombok.Getter;

@Getter
public class HouseTourLikeResponse extends HouseTourLikeDto {

    public HouseTourLikeResponse(HouseTourLike houseTourLike) {
        super(houseTourLike);
    }
}
