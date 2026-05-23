package com.al.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="users_jpa")
public class User {

	@Id
	@SequenceGenerator(name = "userSeq",sequenceName = "user_sequence",initialValue = 1000000000,allocationSize =7)
	@GeneratedValue(generator = "userSeq",strategy = GenerationType.SEQUENCE)
	private Long userId;
	
	
	@Column(nullable = false)
	private String FirstName;
	
	private String middleName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private Role role;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
	private Account account;
	
	@OneToMany(mappedBy = "audit")
	private List<Audit> audits;
}
