package com.icebear2n2.todayhouse.domain.dto.avatar;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import lombok.Getter;

@Getter
public class AvatarDto {
    private Long avatarId;
    private String nickname;
    private String gender;
    private String picture;
    private String about;

    public AvatarDto(Avatar avatar) {
        this.avatarId = avatar.getAvatarId();
        this.nickname = avatar.getNickname();
        this.gender = avatar.getGender();
        this.picture = avatar.getPicture();
        this.about = avatar.getAbout();
    }
}
