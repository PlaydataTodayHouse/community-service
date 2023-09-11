package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourDto;
import com.icebear2n2.todayhouse.domain.dto.MediaPostDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostDto;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import lombok.Getter;

import java.util.List;

@Getter
public class AvatarByPostResponse extends AvatarDto {
    private List<HouseTourDto> houseTours;
    private List<MediaPostDto> mediaPosts;
    private List<TipPostDto> tipPosts;

    public AvatarByPostResponse(Avatar avatar) {
        super(avatar);
        houseTours = avatar.getHouseTours().stream().map(HouseTourDto::new).toList();
        mediaPosts = avatar.getMediaPosts().stream().map(MediaPostDto::new).toList();
        tipPosts = avatar.getTipPosts().stream().map(TipPostDto::new).toList();
    }
}
