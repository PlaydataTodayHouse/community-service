package com.icebear2n2.todayhouse.domain.response.scraps;

import com.icebear2n2.todayhouse.domain.dto.scraps.MediaPostScrapDto;
import com.icebear2n2.todayhouse.domain.entity.scraps.MediaPostScrap;
import lombok.Getter;

@Getter
public class MediaPostScrapResponse extends MediaPostScrapDto {

    public MediaPostScrapResponse(MediaPostScrap mediaPostScrap) {
        super(mediaPostScrap);
    }
}
