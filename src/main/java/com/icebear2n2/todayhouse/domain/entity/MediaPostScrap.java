package com.icebear2n2.todayhouse.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "media_post_scrap")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MediaPostScrap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_post_scrap_id")
    private Long scrapId;

    @ManyToOne
    @JoinColumn(name = "avatar_id", referencedColumnName = "avatar_id")
    private Avatar avatar;

    @ManyToOne
    @JoinColumn(name = "media_post_id", referencedColumnName = "media_post_id")
    private MediaPost mediaPost;
}
