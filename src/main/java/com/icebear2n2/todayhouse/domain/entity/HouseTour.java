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
@Table(name = "house_tour")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class HouseTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_tour_id")
    private Long houseTourId;
    @ManyToOne
    @JoinColumn(name = "avatar_id", referencedColumnName = "avatar_id")
    private Avatar avatar;
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
    private String copyrightNotice;
    private String title;
    private String content;
    @OneToMany(mappedBy = "houseTour")
    private List<HouseTourComment> comments;

    @OneToMany(mappedBy = "houseTour")
    private List<HouseTourLike> likes;

    @OneToMany(mappedBy = "houseTour")
    private List<HouseTourScrap> scraps;

    @CreationTimestamp
    private Timestamp createdAt;

    public void UpdateHouseTour(String housingType, Integer roomCount, String direction, String location, String familyType, Boolean petPresence, Integer familyCount, String workField, String worker, String duration, Integer budget, String copyrightNotice, String title, String content) {

        if (housingType != null) {
            this.housingType = housingType;
        }

        if (roomCount != null) {
            this.roomCount = roomCount;

        }
        if (direction != null) {
            this.direction = direction;

        }
        if (location != null) {
            this.location = location;

        }

        if (familyType != null) {
            this.familyType = familyType;

        }
        if (petPresence != null) {
            this.petPresence = petPresence;

        }
        if (familyCount != null) {
            this.familyCount = familyCount;

        }
        if (workField != null) {
            this.workField = workField;

        }
        if (worker != null) {
            this.worker = worker;

        }
        if (duration != null) {
            this.duration = duration;

        }
        if (budget != null) {
            this.budget = budget;

        }
        if (copyrightNotice != null) {
            this.copyrightNotice = copyrightNotice;

        }
        if (title != null) {
            this.title = title;

        }
        if (content != null) {
            this.content = content;

        }
    }
}


