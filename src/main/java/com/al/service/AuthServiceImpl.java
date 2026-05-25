package com.al.service;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.al.dto.LoginUserWithEmail;
import com.al.dto.RegisterAccount;
import com.al.dto.RegisterUser;
import com.al.entity.Account;
import com.al.entity.AccountStatus;
import com.al.entity.Log;
import com.al.entity.LogAction;
import com.al.entity.User;
import com.al.repository.AccountRepository;
import com.al.repository.AuditRepository;
import com.al.repository.LogRepository;
import com.al.repository.UserRepository;

@Service
public class AuthServiceImpl implements IAuthService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private AuditRepository auditRepo;
	
	@Autowired
	private LogRepository logRepo;
	
	@Override
	public String registerUser(RegisterUser user,RegisterAccount account) {
	    User user1 = new User();
	    BeanUtils.copyProperties(user, user1);
	    user1.setPassword(encoder.encode(user.getPassword()));
	    
	    Account acc = new Account();
	    BeanUtils.copyProperties(account, acc);
	    acc.setStatus(AccountStatus.INACTIVE);
	    
	    System.out.println(user1.getLastName()+ " Auth service Impl");
	    user1.setAccount(acc);
	    acc.setUser(user1);
	    
	    
	    
	    userRepo.save(user1);
	   Log log= new Log();
	   log.setUser(user1);
	   log.setAction(LogAction.USER_REGISTERED);
	   log.setCreatedAt(LocalDateTime.now());
	   
	    
		return "Registered Succefully";
	}

	@Override
	public User loginUser(LoginUserWithEmail user) {
		
	User tempUser=userRepo.findByEmail(user.getEmail());
	
	if(tempUser==null) {
		throw new IllegalArgumentException("User Not Found");
	}
	
	if(!encoder.matches(user.getPassword(), tempUser.getPassword())) {
		throw new IllegalArgumentException("Invalid Password");
	}
	return tempUser;
	}
	
	

	
}
