package com.icebear2n2.todayhouse.comments.repository;

import com.icebear2n2.todayhouse.domain.entity.MediaPostComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaPostCommentRepository extends JpaRepository<MediaPostComment, Long> {
    Page<MediaPostComment> findAll(Pageable request);
}
