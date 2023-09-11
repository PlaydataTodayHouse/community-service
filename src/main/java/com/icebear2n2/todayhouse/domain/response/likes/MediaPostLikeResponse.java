package com.icebear2n2.todayhouse.domain.response.likes;

import com.icebear2n2.todayhouse.domain.dto.likes.MediaPostLikeDto;
import com.icebear2n2.todayhouse.domain.entity.likes.MediaPostLike;
import lombok.Getter;

@Getter
public class MediaPostLikeResponse extends MediaPostLikeDto {

    public MediaPostLikeResponse(MediaPostLike mediaPostLike) {
        super(mediaPostLike);
    }
}
