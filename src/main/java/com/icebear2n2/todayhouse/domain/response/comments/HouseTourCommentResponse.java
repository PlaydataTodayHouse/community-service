package com.icebear2n2.todayhouse.domain.response.comments;

import com.icebear2n2.todayhouse.domain.dto.avatar.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.comments.HouseTourCommentDto;
import com.icebear2n2.todayhouse.domain.dto.posts.HouseTourDto;
import com.icebear2n2.todayhouse.domain.entity.comments.HouseTourComment;
import lombok.Getter;

@Getter
public class HouseTourCommentResponse extends HouseTourCommentDto {

    private AvatarDto avatar;
    private HouseTourDto houseTour;

    public HouseTourCommentResponse(HouseTourComment houseTourComment) {
        super(houseTourComment);
        avatar = new AvatarDto(houseTourComment.getAvatar());
        houseTour = new HouseTourDto(houseTourComment.getHouseTour());
    }
}
