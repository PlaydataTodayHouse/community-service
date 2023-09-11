package com.icebear2n2.todayhouse.domain.response.comments;

import com.icebear2n2.todayhouse.domain.dto.avatar.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.comments.MediaPostCommentDto;
import com.icebear2n2.todayhouse.domain.dto.posts.MediaPostDto;
import com.icebear2n2.todayhouse.domain.entity.comments.MediaPostComment;
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
