package com.al.entity;

import java.time.LocalDate;

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

@Entity
@Table(name="jpa_transactions")
public class Transaction {

	@Id
	@SequenceGenerator(name = "transactionSeq",sequenceName = "transaction_sequence",initialValue = 1000000000,allocationSize =3)
	@GeneratedValue(generator = "transactionSeq",strategy = GenerationType.SEQUENCE)
	private Long transactionId;
	
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	
	@CreationTimestamp
	private LocalDate createdAt;
	
	@Column(nullable = false)
	private Double amount;
	
	// Entity Relations
	
	@ManyToOne()
	@JoinColumn(referencedColumnName = "id",name="account_id")
	private Account account;
	
}
