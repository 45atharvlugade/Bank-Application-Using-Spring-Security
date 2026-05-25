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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users_jpa")
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter

public class User {

	

	@Id
	@SequenceGenerator(name = "userSeq",sequenceName = "user_sequence",initialValue = 1000000000,allocationSize =3)
	@GeneratedValue(generator = "userSeq",strategy = GenerationType.SEQUENCE)
	private Long userId;
	
	@NonNull
	@Column(nullable = false)
	private String firstName;
	
	@NonNull
	private String middleName;
	
	@NonNull
	@Column(nullable = false)
	private String lastName;
	
	@NonNull
	@Column(nullable = false)
	private String password;
	
	@NonNull
	@Column(nullable = false)
	private Role role;
	
	@Column(nullable = false,unique = true)
	private String email;
	
	@Column(nullable = false,unique = true)
	private Long mobile;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
	private Account account;
	
	@OneToMany(mappedBy = "user")
	private List<Audit> audits;
	
	@OneToMany(mappedBy="user")
	private List<Loan> loans;
	
	@OneToMany(mappedBy="user")
	private List<Log> logs;
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", password=" + password + ", role=" + role + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}
}
