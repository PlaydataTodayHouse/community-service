package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostDto;
import com.icebear2n2.todayhouse.domain.entity.TipPostLike;
import lombok.Getter;

@Getter
public class TipPostLikeResponse {
    private AvatarDto avatar;
    private TipPostDto tipPost;

    public TipPostLikeResponse(TipPostLike tipPostLike) {
        this.avatar = new AvatarDto(tipPostLike.getAvatar());
        this.tipPost = new TipPostDto(tipPostLike.getTipPost());
    }
}
