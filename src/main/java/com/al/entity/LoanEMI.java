package com.al.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Column	Meaning
emi_id	Primary key
loan_id	FK → Loan table
emi_amount	Amount to pay
due_date	When EMI is due
paid_date	When user paid
status	PAID / PENDING / LATE
penalty	late fee (optional)
created_at	record creation time
 */



@Entity
@Table(name="jpa_loan_emi")
public class LoanEMI {

	@Id
	@SequenceGenerator(name = "loanEmiSeq",sequenceName = "loan_emi_sequence",initialValue = 1000000000,allocationSize =3)
	@GeneratedValue(generator = "loanEmiSeq",strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private Double emiAmount;
	
	
	private LocalDate dueDate;
	
	private LocalDate paidDate;
	
	private LoanEMIstatus status;
	
	private Double penalty;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "loanid",name="loan_id")
	private Loan loan;
}
