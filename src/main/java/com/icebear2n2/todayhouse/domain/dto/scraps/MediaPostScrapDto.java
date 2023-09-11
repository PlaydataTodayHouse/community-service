package com.icebear2n2.todayhouse.domain.dto.scraps;

import com.icebear2n2.todayhouse.domain.entity.scraps.MediaPostScrap;
import lombok.Getter;

@Getter
public class MediaPostScrapDto {
    private Long mediaPostScrapId;
    private Long avatarId;
    private Long mediaPostId;

    public MediaPostScrapDto(MediaPostScrap mediaPostScrap) {
        this.mediaPostScrapId = mediaPostScrap.getScrapId();
        this.avatarId = mediaPostScrap.getAvatar().getAvatarId();
        this.mediaPostId = mediaPostScrap.getMediaPost().getMediaPostId();
    }
}
