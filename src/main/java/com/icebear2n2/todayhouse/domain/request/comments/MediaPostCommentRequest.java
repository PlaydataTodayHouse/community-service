package com.icebear2n2.todayhouse.domain.request.comments;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.comments.MediaPostComment;
import com.icebear2n2.todayhouse.domain.entity.posts.MediaPost;

public record MediaPostCommentRequest(Long avatarId, Long mediaPostId, String content) {
    public MediaPostComment toEntity(Avatar avatar, MediaPost mediaPost) {
        return MediaPostComment.builder().avatar(avatar).mediaPost(mediaPost).content(content).build();

    }
}
