package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tip_post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TipPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String link;
    private String title;
    private String content;

    @OneToMany(mappedBy = "tipPost")
    private List<Like> likes;
    @OneToMany(mappedBy = "tipPost")
    private List<Scrap> scraps;


}
