package com.icebear2n2.todayhouse.posts.repository;

import com.icebear2n2.todayhouse.domain.entity.posts.HouseTour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseTourRepository extends JpaRepository<HouseTour, Long> {
    Page<HouseTour> findAll(Pageable request);
}
