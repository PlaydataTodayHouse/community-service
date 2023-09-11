package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.*;
import com.icebear2n2.todayhouse.domain.entity.*;
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
