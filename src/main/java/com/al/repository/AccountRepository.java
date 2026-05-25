package com.al.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.al.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	
}
