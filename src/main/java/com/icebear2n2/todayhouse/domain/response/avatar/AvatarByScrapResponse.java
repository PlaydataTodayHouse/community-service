package com.icebear2n2.todayhouse.domain.response.avatar;

import com.icebear2n2.todayhouse.domain.dto.avatar.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.posts.HouseTourDto;
import com.icebear2n2.todayhouse.domain.dto.posts.MediaPostDto;
import com.icebear2n2.todayhouse.domain.dto.posts.TipPostDto;
import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.scraps.HouseTourScrap;
import com.icebear2n2.todayhouse.domain.entity.scraps.MediaPostScrap;
import com.icebear2n2.todayhouse.domain.entity.scraps.TipPostScrap;
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
