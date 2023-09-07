package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
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
    @Column(name = "tip_post_id")
    private Long tipPostId;
    @ManyToOne
    @JoinColumn(name = "avatar_id", referencedColumnName = "avatar_id")
    private Avatar avatar;
    private String link;
    private String linkInfo;
    private String title;
    private String content;
    @OneToMany(mappedBy = "tipPost")
    private List<TipPostComment> comments;

    @OneToMany(mappedBy = "tipPost")
    private List<TipPostLike> likes;

    @CreationTimestamp
    private Timestamp createdAt;

    public void UpdateTipPost(String link, String linkInfo, String title, String content) {
        if (link != null) {
            this.link = link;
        }
        if (linkInfo != null) {
            this.linkInfo = linkInfo;
        }
        if (title != null) {
            this.title = title;
        }
        if (content != null) {
            this.content = content;
        }

    }
}
