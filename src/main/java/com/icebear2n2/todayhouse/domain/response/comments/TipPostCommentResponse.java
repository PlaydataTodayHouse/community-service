package com.icebear2n2.todayhouse.domain.response.comments;

import com.icebear2n2.todayhouse.domain.dto.avatar.AvatarDto;
import com.icebear2n2.todayhouse.domain.dto.comments.TipPostCommentDto;
import com.icebear2n2.todayhouse.domain.dto.posts.TipPostDto;
import com.icebear2n2.todayhouse.domain.entity.comments.TipPostComment;
import lombok.Getter;

@Getter
public class TipPostCommentResponse extends TipPostCommentDto {

    private AvatarDto avatar;
    private TipPostDto tipPost;

    public TipPostCommentResponse(TipPostComment tipPostComment) {
        super(tipPostComment);
        avatar = new AvatarDto(tipPostComment.getAvatar());
        tipPost = new TipPostDto(tipPostComment.getTipPost());
    }
}
