package com.icebear2n2.todayhouse.domain.response.posts;

import com.icebear2n2.todayhouse.domain.dto.avatar.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.comments.MediaPostCommentDto;
import com.icebear2n2.todayhouse.domain.dto.posts.MediaPostDto;
import com.icebear2n2.todayhouse.domain.entity.posts.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.likes.MediaPostLike;
import com.icebear2n2.todayhouse.domain.entity.scraps.MediaPostScrap;
import lombok.Getter;

import java.util.List;

@Getter
public class MediaPostResponse extends MediaPostDto {

    private AvatarDto avatar;
    private List<MediaPostCommentDto> comments;
    private List<AvatarDto> likes;
    private List<AvatarDto> scraps;

    public MediaPostResponse(MediaPost mediaPost) {

        super(mediaPost);
        avatar = new AvatarDto(mediaPost.getAvatar());
        comments = mediaPost.getComments().stream().map(MediaPostCommentDto::new).toList();
        likes = mediaPost.getLikes().stream().map(MediaPostLike::getAvatar).map(AvatarDto::new).toList();
        scraps = mediaPost.getScraps().stream().map(MediaPostScrap::getAvatar).map(AvatarDto::new).toList();
    }
}
