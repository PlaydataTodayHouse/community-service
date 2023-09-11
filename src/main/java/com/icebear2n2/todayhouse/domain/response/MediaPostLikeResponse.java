package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.MediaPostDto;
import com.icebear2n2.todayhouse.domain.dto.MediaPostLikeDto;
import com.icebear2n2.todayhouse.domain.entity.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.MediaPostLike;
import lombok.Getter;

@Getter
public class MediaPostLikeResponse extends MediaPostLikeDto {

    public MediaPostLikeResponse(MediaPostLike mediaPostLike) {
        super(mediaPostLike);
    }
}
