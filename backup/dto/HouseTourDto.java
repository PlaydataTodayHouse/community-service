package com.icebear2n2.todayhouse.domain.dto;

import com.icebear2n2.todayhouse.domain.entity.HouseTour;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class HouseTourDto {
    private Long postId;
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

    public HouseTourDto(HouseTour houseTour) {
        this.postId = houseTour.getPostId();
        this.housingType = houseTour.getHousingType();
        this.roomCount = houseTour.getRoomCount();
        this.direction = houseTour.getDirection();
        this.location = houseTour.getLocation();
        this.familyType = houseTour.getFamilyType();
        this.petPresence = houseTour.getPetPresence();
        this.familyCount = houseTour.getFamilyCount();
        this.workField = houseTour.getWorkField();
        this.worker = houseTour.getWorker();
        this.duration = houseTour.getDuration();
        this.budget = houseTour.getBudget();
        this.link = houseTour.getLink();
        this.copyrightNotice = houseTour.getCopyrightNotice();
        this.title = houseTour.getTitle();
        this.content = houseTour.getContent();
        this.createdAt = houseTour.getCreatedAt();
    }
}
