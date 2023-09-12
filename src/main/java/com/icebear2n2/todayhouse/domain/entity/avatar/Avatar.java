package com.icebear2n2.todayhouse.domain.entity.avatar;

import com.icebear2n2.todayhouse.domain.entity.comments.HouseTourComment;
import com.icebear2n2.todayhouse.domain.entity.follow.Follow;
import com.icebear2n2.todayhouse.domain.entity.likes.HouseTourLike;
import com.icebear2n2.todayhouse.domain.entity.likes.MediaPostLike;
import com.icebear2n2.todayhouse.domain.entity.likes.TipPostLike;
import com.icebear2n2.todayhouse.domain.entity.posts.HouseTour;
import com.icebear2n2.todayhouse.domain.entity.posts.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.posts.TipPost;
import com.icebear2n2.todayhouse.domain.entity.scraps.HouseTourScrap;
import com.icebear2n2.todayhouse.domain.entity.scraps.MediaPostScrap;
import com.icebear2n2.todayhouse.domain.entity.scraps.TipPostScrap;
import com.icebear2n2.todayhouse.domain.entity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "avatar")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "avatar_id")
    private Long avatarId;
    private String nickname;
    private String gender;
    private String picture;
    private String about;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "avatar")
    private List<HouseTour> houseTours;
    @OneToMany(mappedBy = "avatar")
    private List<MediaPost> mediaPosts;
    @OneToMany(mappedBy = "avatar")
    private List<TipPost> tipPosts;

    @OneToMany(mappedBy = "avatar")
    private List<HouseTourComment> houseTourComments;

    @OneToMany(mappedBy = "follower")
    private List<Follow> followerList;

    @OneToMany(mappedBy = "following")
    private List<Follow> followingList;

    @OneToMany(mappedBy = "avatar")
    private List<HouseTourScrap> houseTourScraps;
    @OneToMany(mappedBy = "avatar")
    private List<MediaPostScrap> mediaPostScraps;
    @OneToMany(mappedBy = "avatar")
    private List<TipPostScrap> tipPostScraps;
    @OneToMany(mappedBy = "avatar")
    private List<HouseTourLike> houseTourLikes;
    @OneToMany(mappedBy = "avatar")
    private List<MediaPostLike> mediaPostLikes;
    @OneToMany(mappedBy = "avatar")
    private List<TipPostLike> tipPostLikes;

    public void UpdateAvatar(String nickname, String gender, String picture, String about) {
        if (nickname != null) {
            this.nickname = nickname;
        }
        if (gender != null) {
            this.gender = gender;
        }
        if (picture != null) {
            this.picture = picture;
        }
        if (about != null) {
            this.about = about;
        }
    }
}

