package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "house_tour")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder

public class HouseTour {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String housingType;
    private Integer roomCount;
    private String direction;
    private String location;
    private String familyType;
    private Boolean petPresence;
    private Integer familyCount;
    private String workField;
    private String worker;
    private String duration;
    private Integer budget;
    private String link;
    private String copyrightNotice;
    private String title;
    private String content;
    private Timestamp createdAt;

    @OneToMany(mappedBy = "houseTour")
    private List<Like> likes;
    @OneToMany(mappedBy = "houseTour")
    private List<Scrap> scraps;

}
