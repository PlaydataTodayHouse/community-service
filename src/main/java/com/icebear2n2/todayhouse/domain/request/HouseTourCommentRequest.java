package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.HouseTour;
import com.icebear2n2.todayhouse.domain.entity.HouseTourComment;

public record HouseTourCommentRequest(Long avatarId, Long houseTourId, String content) {
    public HouseTourComment toEntity(Avatar avatar, HouseTour houseTour) {
        return HouseTourComment.builder().avatar(avatar).houseTour(houseTour).content(content).build();

    }
}
