package com.icebear2n2.todayhouse.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String password;
    private String userName;
    private LocalDate birth;

    @OneToMany(mappedBy = "user")
    private List<Like> likes;

    @OneToMany(mappedBy = "user")
    private List<Scrap> scraps;

    @OneToMany(mappedBy = "user")
    private List<HouseTour> houseTours;
    @OneToMany(mappedBy = "user")
    private List<MediaPost> mediaPosts;
    @OneToMany(mappedBy = "user")
    private List<TipPost> tipPosts;
}
