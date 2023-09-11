package com.icebear2n2.todayhouse.posts.repository;

import com.icebear2n2.todayhouse.domain.entity.posts.TipPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipPostRepository extends JpaRepository<TipPost, Long> {
    Page<TipPost> findAll(Pageable request);
}
