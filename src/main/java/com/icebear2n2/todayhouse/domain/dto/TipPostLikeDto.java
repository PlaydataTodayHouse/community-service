package com.icebear2n2.todayhouse.domain.dto;

import com.icebear2n2.todayhouse.domain.entity.MediaPostLike;
import com.icebear2n2.todayhouse.domain.entity.TipPostLike;
import lombok.Getter;

@Getter
public class TipPostLikeDto {
    private Long tipPostLikeId;
    private Long avatarId;
    private Long tipPostId;

    public TipPostLikeDto(TipPostLike tipPostLike) {
        this.tipPostLikeId = tipPostLike.getLikeId();
        this.avatarId = tipPostLike.getAvatar().getAvatarId();
        this.tipPostId = tipPostLike.getTipPost().getTipPostId();
    }
}
