package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostLikeDto;
import com.icebear2n2.todayhouse.domain.entity.TipPostLike;
import lombok.Getter;

@Getter
public class TipPostLikeResponse extends TipPostLikeDto {

    public TipPostLikeResponse(TipPostLike tipPostLike) {
        super(tipPostLike);
    }
}
