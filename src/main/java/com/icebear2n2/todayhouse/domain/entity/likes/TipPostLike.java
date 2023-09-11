package com.icebear2n2.todayhouse.domain.entity.likes;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.TipPost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tip_post_like")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TipPostLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tip_post_like_id")
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "avatar_id", referencedColumnName = "avatar_id")
    private Avatar avatar;

    @ManyToOne
    @JoinColumn(name = "tip_post_id", referencedColumnName = "tip_post_id")
    private TipPost tipPost;
}
