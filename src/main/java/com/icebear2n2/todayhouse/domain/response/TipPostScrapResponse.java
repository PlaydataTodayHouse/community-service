package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.MediaPostDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostScrapDto;
import com.icebear2n2.todayhouse.domain.entity.MediaPostScrap;
import com.icebear2n2.todayhouse.domain.entity.TipPostScrap;
import lombok.Getter;

@Getter
public class TipPostScrapResponse extends TipPostScrapDto {

    public TipPostScrapResponse(TipPostScrap tipPostScrap) {
        super(tipPostScrap);
    }
}
