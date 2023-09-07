package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.HouseTourDto;
import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.MediaPostDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostDto;
import com.icebear2n2.todayhouse.domain.entity.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.Scrap;
import lombok.Getter;

@Getter
public class ScrapResponse {
    private AvatarDto avatar;
    private HouseTourDto houseTour;
    private MediaPostDto mediaPost;
    private TipPostDto tipPost;


    public ScrapResponse(Scrap scrap) {
        this.avatar = new AvatarDto(scrap.getAvatar());
        this.houseTour = new HouseTourDto(scrap.getHouseTour());
        this.mediaPost = new MediaPostDto(scrap.getMediaPost());
        this.tipPost = new TipPostDto(scrap.getTipPost());
    }
}
