package com.al.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.al.advice.UserAdvice;

import com.al.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserAdvice advice;

	
	
}
