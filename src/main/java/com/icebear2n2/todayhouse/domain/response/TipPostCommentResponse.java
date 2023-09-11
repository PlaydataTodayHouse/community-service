package com.icebear2n2.todayhouse.domain.response;

import com.icebear2n2.todayhouse.domain.dto.*;
import com.icebear2n2.todayhouse.domain.entity.MediaPostComment;
import com.icebear2n2.todayhouse.domain.entity.TipPostComment;
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
