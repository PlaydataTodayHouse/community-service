package com.icebear2n2.todayhouse.scraps.repository;

import com.icebear2n2.todayhouse.domain.entity.scraps.MediaPostScrap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaPostScrapRepository extends JpaRepository<MediaPostScrap, Long> {
    Page<MediaPostScrap> findAll(Pageable request);

    Boolean existsByAvatar_AvatarIdAndMediaPost_MediaPostId(Long avatarId, Long mediaPostId);
}
