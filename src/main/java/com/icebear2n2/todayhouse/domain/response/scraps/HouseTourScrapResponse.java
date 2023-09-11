package com.icebear2n2.todayhouse.domain.response.scraps;

import com.icebear2n2.todayhouse.domain.dto.scraps.HouseTourScrapDto;
import com.icebear2n2.todayhouse.domain.entity.scraps.HouseTourScrap;
import lombok.Getter;

@Getter
public class HouseTourScrapResponse extends HouseTourScrapDto {

    public HouseTourScrapResponse(HouseTourScrap houseTourScrap) {
        super(houseTourScrap);
    }
}
