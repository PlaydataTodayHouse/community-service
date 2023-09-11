package com.icebear2n2.todayhouse.likes.repository;

import com.icebear2n2.todayhouse.domain.entity.likes.TipPostLike;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipPostLikeRepository extends JpaRepository<TipPostLike, Long> {
    Page<TipPostLike> findAll(Pageable request);

    Boolean existsByAvatar_AvatarIdAndTipPost_TipPostId(Long avatarId, Long tipPostId);
}
