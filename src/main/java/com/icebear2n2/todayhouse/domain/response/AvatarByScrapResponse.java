package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourDto;
import com.icebear2n2.todayhouse.domain.dto.MediaPostDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostDto;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.HouseTourScrap;
import com.icebear2n2.todayhouse.domain.entity.MediaPostScrap;
import com.icebear2n2.todayhouse.domain.entity.TipPostScrap;
import lombok.Getter;

import java.util.List;

@Getter
public class AvatarByScrapResponse extends AvatarDto {

    private List<HouseTourDto> houseTourScraps;
    private List<MediaPostDto> mediaPostScraps;
    private List<TipPostDto> tipPostScraps;

    public AvatarByScrapResponse(Avatar avatar) {
        super(avatar);
        houseTourScraps = avatar.getHouseTourScraps().stream().map(HouseTourScrap::getHouseTour).map(HouseTourDto::new).toList();
        mediaPostScraps = avatar.getMediaPostScraps().stream().map(MediaPostScrap::getMediaPost).map(MediaPostDto::new).toList();
        tipPostScraps = avatar.getTipPostScraps().stream().map(TipPostScrap::getTipPost).map(TipPostDto::new).toList();
    }
}
