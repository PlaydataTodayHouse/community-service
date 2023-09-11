package com.icebear2n2.todayhouse.comments.repository;

import com.icebear2n2.todayhouse.domain.entity.comments.HouseTourComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseTourCommentRepository extends JpaRepository<HouseTourComment, Long> {
    Page<HouseTourComment> findAll(Pageable request);
}
