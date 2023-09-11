package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourCommentDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourDto;
import com.icebear2n2.todayhouse.domain.dto.HouseTourLikeDto;
import com.icebear2n2.todayhouse.domain.entity.HouseTour;
import com.icebear2n2.todayhouse.domain.entity.HouseTourLike;
import com.icebear2n2.todayhouse.domain.entity.HouseTourScrap;
import lombok.Getter;

import java.util.List;

@Getter
public class HouseTourResponse extends HouseTourDto {

    private AvatarDto avatar;
    private List<HouseTourCommentDto> comments;
    private List<AvatarDto> likes;
    private List<AvatarDto> scraps;

    public HouseTourResponse(HouseTour houseTour) {
        super(houseTour);
        avatar = new AvatarDto(houseTour.getAvatar());
        comments = houseTour.getComments().stream().map(HouseTourCommentDto::new).toList();
        likes = houseTour.getLikes().stream().map(HouseTourLike::getAvatar).map(AvatarDto::new).toList();
        scraps = houseTour.getScraps().stream().map(HouseTourScrap::getAvatar).map(AvatarDto::new).toList();
    }
}
