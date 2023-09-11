package com.icebear2n2.todayhouse.domain.response.likes;

import com.icebear2n2.todayhouse.domain.dto.likes.TipPostLikeDto;
import com.icebear2n2.todayhouse.domain.entity.likes.TipPostLike;
import lombok.Getter;

@Getter
public class TipPostLikeResponse extends TipPostLikeDto {

    public TipPostLikeResponse(TipPostLike tipPostLike) {
        super(tipPostLike);
    }
}
