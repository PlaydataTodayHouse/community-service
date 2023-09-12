package com.icebear2n2.todayhouse.user.repository;

import com.icebear2n2.todayhouse.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
