package com.placement.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.portal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
