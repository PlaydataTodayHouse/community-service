package com.icebear2n2.todayhouse.scraps.repository;

import com.icebear2n2.todayhouse.domain.entity.MediaPostScrap;
import com.icebear2n2.todayhouse.domain.entity.TipPostScrap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipPostScrapRepository extends JpaRepository<TipPostScrap, Long> {
    Page<TipPostScrap> findAll(Pageable request);

    Boolean existsByAvatar_AvatarIdAndTipPost_TipPostId(Long avatarId, Long tipPostId);
}
