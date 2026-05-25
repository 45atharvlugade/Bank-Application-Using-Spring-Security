package com.al.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.al.dto.LoginUserWithEmail;
import com.al.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);
	
	public User findByEmailAndPassword(String email,String password);
	
}
