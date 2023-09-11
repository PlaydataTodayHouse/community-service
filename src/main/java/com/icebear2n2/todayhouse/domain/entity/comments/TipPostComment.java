package com.icebear2n2.todayhouse.domain.entity.comments;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.TipPost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Table(name = "tip_post_comment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TipPostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipPostCommentId;

    @ManyToOne
    private Avatar avatar;

    @ManyToOne
    private TipPost tipPost;

    private String content;
    @CreationTimestamp
    private Timestamp createdAt;

    public void updateTipPostComment(String content) {
        if (content != null) {
            this.content = content;
        }
    }
}
