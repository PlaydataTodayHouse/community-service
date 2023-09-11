package com.icebear2n2.todayhouse.domain.response.scraps;

import com.icebear2n2.todayhouse.domain.dto.scraps.TipPostScrapDto;
import com.icebear2n2.todayhouse.domain.entity.scraps.TipPostScrap;
import lombok.Getter;

@Getter
public class TipPostScrapResponse extends TipPostScrapDto {

    public TipPostScrapResponse(TipPostScrap tipPostScrap) {
        super(tipPostScrap);
    }
}
