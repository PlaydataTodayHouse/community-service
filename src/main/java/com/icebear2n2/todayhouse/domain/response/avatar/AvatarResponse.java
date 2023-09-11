package com.icebear2n2.todayhouse.domain.response.avatar;

import com.icebear2n2.todayhouse.domain.dto.avatar.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.user.UserDto;
import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.follow.Follow;
import lombok.Getter;

import java.util.List;

@Getter
public class AvatarResponse extends AvatarDto {
    private UserDto user;

    private List<AvatarDto> followers;
    private List<AvatarDto> followings;

    public AvatarResponse(Avatar avatar) {
        super(avatar);
        user = new UserDto(avatar.getUser());
        followers = avatar.getFollowingList().stream().map(Follow::getFollower).map(AvatarDto::new).toList();
        followings = avatar.getFollowerList().stream().map(Follow::getFollowing).map(AvatarDto::new).toList();

    }
}
