package com.twitterclone.sweater.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.twitterclone.sweater.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);

	User findByActivationCode(String code);
}
