package com.icebear2n2.todayhouse.domain.request;

import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.TipPost;

public record TipPostRequest(Long avatarId, String link, String linkInfo, String title, String content) {
    public TipPost toEntity(Avatar avatar) {
        return TipPost.builder().link(link).linkInfo(linkInfo).title(title).content(content).avatar(avatar).build();
    }
}
