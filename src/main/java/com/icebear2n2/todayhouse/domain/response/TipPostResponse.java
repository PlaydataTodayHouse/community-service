package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostCommentDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostDto;
import com.icebear2n2.todayhouse.domain.dto.TipPostLikeDto;
import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.TipPost;
import com.icebear2n2.todayhouse.domain.entity.TipPostLike;
import com.icebear2n2.todayhouse.domain.entity.TipPostScrap;
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
