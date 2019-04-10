package com.virtusa.money.manager.user.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.money.manager.user.service.domain.RegisterUser;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {

	public Optional<RegisterUser> findByEmailId(String emailId);
}
