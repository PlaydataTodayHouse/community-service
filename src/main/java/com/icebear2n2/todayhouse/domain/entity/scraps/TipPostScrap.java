package com.icebear2n2.todayhouse.domain.entity.scraps;


import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import com.icebear2n2.todayhouse.domain.entity.posts.TipPost;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tip_post_scrap")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TipPostScrap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tip_post_scrap_id")
    private Long scrapId;

    @ManyToOne
    @JoinColumn(name = "avatar_id", referencedColumnName = "avatar_id")
    private Avatar avatar;

    @ManyToOne
    @JoinColumn(name = "tip_post_id", referencedColumnName = "tip_post_id")
    private TipPost tipPost;
}
