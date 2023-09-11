package com.icebear2n2.todayhouse.likes.repository;

import com.icebear2n2.todayhouse.domain.entity.Avatar;
import com.icebear2n2.todayhouse.domain.entity.MediaPost;
import com.icebear2n2.todayhouse.domain.entity.MediaPostLike;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaPostLikeRepository extends JpaRepository<MediaPostLike, Long> {
    Page<MediaPostLike> findAll(Pageable request);

    Boolean existsByAvatar_AvatarIdAndMediaPost_MediaPostId(Long avatarId, Long mediaPostId);
}
