package com.icebear2n2.todayhouse.domain.request.likes;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.HouseTour;
import com.icebear2n2.todayhouse.domain.entity.likes.HouseTourLike;

public record HouseTourLikeRequest(Long avatarId, Long houseTourId) {
    public HouseTourLike toEntity(Avatar avatar, HouseTour houseTour) {
        return HouseTourLike.builder().avatar(avatar).houseTour(houseTour).build();
    }
}
