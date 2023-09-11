package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "house_tour_like")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class HouseTourLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_tour_like_id")
    private Long likeId;

    @ManyToOne
    @JoinColumn(name = "avatar_id", referencedColumnName = "avatar_id")
    private Avatar avatar;

    @ManyToOne
    @JoinColumn(name = "house_tour_id", referencedColumnName = "house_tour_id")
    private HouseTour houseTour;
}
