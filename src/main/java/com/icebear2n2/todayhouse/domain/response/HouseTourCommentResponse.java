package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourCommentDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourDto;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.HouseTourComment;
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
