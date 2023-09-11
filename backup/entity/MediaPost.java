package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "media_post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MediaPost {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String spaceInfo;
    private String content;

    @OneToMany(mappedBy = "mediaPost")
    private List<Like> likes;
    @OneToMany(mappedBy = "mediaPost")
    private List<Scrap> scraps;

}
