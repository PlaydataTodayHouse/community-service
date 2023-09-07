package com.icebear2n2.todayhouse.comments.repository;


import com.icebear2n2.todayhouse.domain.entity.TipPostComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipPostCommentRepository extends JpaRepository<TipPostComment, Long> {
    Page<TipPostComment> findAll(Pageable request);
}
