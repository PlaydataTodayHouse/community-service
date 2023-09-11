package com.icebear2n2.todayhouse.domain.response.follow;

import com.icebear2n2.todayhouse.domain.dto.avatar.AvatarDto;
import com.icebear2n2.todayhouse.domain.entity.follow.Follow;
import lombok.Getter;

@Getter
public class FollowResponse {
    private AvatarDto follower;
    private AvatarDto following;

    public FollowResponse(Follow follow) {
        this.follower = new AvatarDto(follow.getFollower());
        this.following = new AvatarDto(follow.getFollowing());
    }
}
