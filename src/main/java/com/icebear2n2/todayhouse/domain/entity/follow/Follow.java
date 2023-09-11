package com.icebear2n2.todayhouse.domain.entity.follow;

import com.icebear2n2.todayhouse.domain.entity.avatar.Avatar;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "follow")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long followerId;

    @ManyToOne
    @JoinColumn(name = "follower_id", referencedColumnName = "avatar_id")
    private Avatar follower;

    @ManyToOne
    @JoinColumn(name = "following_id", referencedColumnName = "avatar_id")
    private Avatar following;

}
