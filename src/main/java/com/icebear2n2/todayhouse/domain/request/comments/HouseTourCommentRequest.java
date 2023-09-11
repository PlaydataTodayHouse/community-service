package com.icebear2n2.todayhouse.domain.request.comments;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.HouseTour;
import com.icebear2n2.todayhouse.domain.entity.comments.HouseTourComment;

public record HouseTourCommentRequest(Long avatarId, Long houseTourId, String content) {
    public HouseTourComment toEntity(Avatar avatar, HouseTour houseTour) {
        return HouseTourComment.builder().avatar(avatar).houseTour(houseTour).content(content).build();

    }
}
