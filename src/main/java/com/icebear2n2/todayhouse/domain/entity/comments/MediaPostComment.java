package com.icebear2n2.todayhouse.domain.entity.comments;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.MediaPost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "media_post_comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MediaPostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaPostCommentId;

    @ManyToOne
    private Avatar avatar;

    @ManyToOne
    private MediaPost mediaPost;

    private String content;
    @CreationTimestamp
    private Timestamp createdAt;

    public void updateMediaPostComment(String content) {
        if (content != null) {
            this.content = content;
        }
    }
}
