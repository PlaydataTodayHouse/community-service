package com.icebear2n2.todayhouse.domain.request.follow;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.follow.Follow;

public record FollowRequest(Long followerId, Long followingId) {
    public Follow toEntity(Avatar follower, Avatar following) {
        return Follow.builder().follower(follower).following(following).build();
    }
}
