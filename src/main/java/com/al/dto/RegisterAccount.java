package com.al.dto;

import com.al.entity.AccountStatus;
import com.al.entity.AccountType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterAccount {

	private AccountType type;
	
	private Double balance=00.00;
	
	
}
