package com.icebear2n2.todayhouse.follow.repository;

import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.Follow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Page<Follow> findAll(Pageable request);

    Follow findByFollowerAndFollowing(Avatar follower, Avatar following);

    Boolean existsByFollowerAndFollowing(Avatar follower, Avatar following);
}
