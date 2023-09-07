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
@Table(name = "media_post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MediaPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_post_id")
    private Long mediaPostId;
    @ManyToOne
    @JoinColumn(name = "avatar_id", referencedColumnName = "avatar_id")
    private Avatar avatar;
    private String spaceInfo;
    @OneToMany(mappedBy = "mediaPost")
    private List<MediaPostComment> comments;

    @OneToMany(mappedBy = "mediaPost")
    private List<MediaPostLike> likes;


    @CreationTimestamp
    private Timestamp createdAt;

    public void UpdateMediaPost(String spaceInfo) {
        if (spaceInfo != null) {
            this.spaceInfo = spaceInfo;
        }
    }
}
