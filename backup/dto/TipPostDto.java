package com.icebear2n2.todayhouse.domain.dto;

import com.icebear2n2.todayhouse.domain.entity.TipPost;
import lombok.Getter;

@Getter
public class TipPostDto {
    private Long postId;
    private String link;
    private String title;
    private String content;

    public TipPostDto(TipPost tipPost) {
        this.postId = tipPost.getPostId();
        this.link = tipPost.getLink();
        this.title = tipPost.getTitle();
        this.content = tipPost.getContent();
    }
}
