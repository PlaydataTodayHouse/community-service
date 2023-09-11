package com.icebear2n2.todayhouse.domain.request.comments;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.comments.TipPostComment;
import com.icebear2n2.todayhouse.domain.entity.posts.TipPost;

public record TipPostCommentRequest(Long avatarId, Long tipPostId, String content) {
    public TipPostComment toEntity(Avatar avatar, TipPost tipPost) {
        return TipPostComment.builder().avatar(avatar).tipPost(tipPost).content(content).build();

    }
}
