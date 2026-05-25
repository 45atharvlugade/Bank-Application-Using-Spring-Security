package com.al.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * This is mandatory if you support loans:

loan
loan_id (PK)
user_id (FK)
account_id (FK – optional but common)
principal_amount
interest_rate
tenure_months
remaining_amount
status (ACTIVE, CLOSED, DEFAULTED)
created_at
 */


@Entity
@Table
public class Loan {

	@Id
	@SequenceGenerator(name = "loanSeq",sequenceName = "loan_sequence",initialValue = 1000000000,allocationSize =3)
	@GeneratedValue(generator = "loanSeq",strategy = GenerationType.SEQUENCE)
	private Long loanId;
	
	@Column(nullable = false)
	private Double principleAmount;
	
	@Column(nullable = false)
	private Double inersetRate;
	
	@Column(nullable = false)
	private Double tenureMonths;
	
	@Column(nullable = false)
	private Double remainingAmount;
	
	@Enumerated(EnumType.STRING)
	private LoanStatus status;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "userId",name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id",name="account_id")
	private Account account;
	
	@OneToMany(mappedBy = "loan")
	private List<LoanEMI> emis;
}
