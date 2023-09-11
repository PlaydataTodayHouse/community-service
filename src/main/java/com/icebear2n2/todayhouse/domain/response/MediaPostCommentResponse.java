package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.*;
import com.icebear2n2.todayhouse.domain.entity.HouseTourComment;
import com.icebear2n2.todayhouse.domain.entity.MediaPostComment;
import lombok.Getter;

@Getter
public class MediaPostCommentResponse extends MediaPostCommentDto {

    private AvatarDto avatar;
    private MediaPostDto mediaPost;

    public MediaPostCommentResponse(MediaPostComment mediaPostComment) {
        super(mediaPostComment);
        avatar = new AvatarDto(mediaPostComment.getAvatar());
        mediaPost = new MediaPostDto(mediaPostComment.getMediaPost());
    }
}
