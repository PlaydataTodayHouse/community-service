package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.Follow;
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
