package com.icebear2n2.todayhouse.domain.response.posts;

import com.icebear2n2.todayhouse.domain.dto.avatar.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.comments.TipPostCommentDto;
import com.icebear2n2.todayhouse.domain.dto.posts.TipPostDto;
import com.icebear2n2.todayhouse.domain.entity.posts.TipPost;
import com.icebear2n2.todayhouse.domain.entity.likes.TipPostLike;
import com.icebear2n2.todayhouse.domain.entity.scraps.TipPostScrap;
import lombok.Getter;

import java.util.List;

@Getter
public class TipPostResponse extends TipPostDto {

    private AvatarDto avatar;
    private List<TipPostCommentDto> comments;
    private List<AvatarDto> likes;
    private List<AvatarDto> scraps;

    public TipPostResponse(TipPost tipPost) {
        super(tipPost);
        avatar = new AvatarDto(tipPost.getAvatar());
        comments = tipPost.getComments().stream().map(TipPostCommentDto::new).toList();
        likes = tipPost.getLikes().stream().map(TipPostLike::getAvatar).map(AvatarDto::new).toList();
        scraps = tipPost.getScraps().stream().map(TipPostScrap::getAvatar).map(AvatarDto::new).toList();
    }
}
