package com.icebear2n2.todayhouse.domain.dto.scraps;

import com.icebear2n2.todayhouse.domain.entity.scraps.TipPostScrap;
import lombok.Getter;

@Getter
public class TipPostScrapDto {
    private Long tipPostScrapId;
    private Long avatarId;
    private Long tipPostId;

    public TipPostScrapDto(TipPostScrap tipPostScrap) {
        this.tipPostScrapId = tipPostScrap.getScrapId();
        this.avatarId = tipPostScrap.getAvatar().getAvatarId();
        this.tipPostId = tipPostScrap.getTipPost().getTipPostId();
    }
}
