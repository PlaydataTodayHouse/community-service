package com.icebear2n2.todayhouse.domain.request.posts;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.TipPost;

public record TipPostRequest(Long avatarId, String link, String linkInfo, String title, String content) {
    public TipPost toEntity(Avatar avatar) {
        return TipPost.builder().link(link).linkInfo(linkInfo).title(title).content(content).avatar(avatar).build();
    }
}
