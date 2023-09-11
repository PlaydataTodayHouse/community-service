package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourScrapDto;
import com.icebear2n2.todayhouse.domain.entity.HouseTourLike;
import com.icebear2n2.todayhouse.domain.entity.HouseTourScrap;
import lombok.Getter;

@Getter
public class HouseTourScrapResponse extends HouseTourScrapDto {

    public HouseTourScrapResponse(HouseTourScrap houseTourScrap) {
        super(houseTourScrap);
    }
}
