package com.icebear2n2.todayhouse.domain.dto;

import com.icebear2n2.todayhouse.domain.entity.TipPost;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class TipPostDto {
    private Long tipPostId;
    private String link;
    private String linkInfo;
    private String title;
    private String content;
    private Timestamp createdAt;

    public TipPostDto(TipPost tipPost) {
        this.tipPostId = tipPost.getTipPostId();
        this.link = tipPost.getLink();
        this.linkInfo = tipPost.getLinkInfo();
        this.title = tipPost.getTitle();
        this.content = tipPost.getContent();
        this.createdAt = tipPost.getCreatedAt();
    }
}
