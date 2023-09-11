package com.icebear2n2.todayhouse.domain.response.avatar;

import com.icebear2n2.todayhouse.domain.dto.avatar.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.posts.HouseTourDto;
import com.icebear2n2.todayhouse.domain.dto.posts.MediaPostDto;
import com.icebear2n2.todayhouse.domain.dto.posts.TipPostDto;
import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.likes.HouseTourLike;
import com.icebear2n2.todayhouse.domain.entity.likes.MediaPostLike;
import com.icebear2n2.todayhouse.domain.entity.likes.TipPostLike;
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
