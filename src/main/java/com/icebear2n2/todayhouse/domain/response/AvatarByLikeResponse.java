package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourDto;
import com.icebear2n2.todayhouse.domain.dto.MediaPostDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostDto;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.HouseTourLike;
import com.icebear2n2.todayhouse.domain.entity.MediaPostLike;
import com.icebear2n2.todayhouse.domain.entity.TipPostLike;
import lombok.Getter;

import java.util.List;

@Getter
public class AvatarByLikeResponse extends AvatarDto {
    private List<HouseTourDto> houseTourLikes;
    private List<MediaPostDto> mediaPostLikes;
    private List<TipPostDto> tipPostLikes;

    public AvatarByLikeResponse(Avatar avatar) {
        super(avatar);
        houseTourLikes = avatar.getHouseTourLikes().stream().map(HouseTourLike::getHouseTour).map(HouseTourDto::new).toList();
        mediaPostLikes = avatar.getMediaPostLikes().stream().map(MediaPostLike::getMediaPost).map(MediaPostDto::new).toList();
        tipPostLikes = avatar.getTipPostLikes().stream().map(TipPostLike::getTipPost).map(TipPostDto::new).toList();
    }
}
