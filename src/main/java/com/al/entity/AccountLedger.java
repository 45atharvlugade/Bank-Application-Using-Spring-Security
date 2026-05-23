package com.al.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 Stores balance history:

account_id
transaction_id
balance_before
balance_after
timestamp
 * 
 */
@Getter
@Setter
@Table(name="jpa_account_ledger")
@Entity
public class AccountLedger {


	@Id
	@SequenceGenerator(name = "accountLedgerSeq",sequenceName = "account_ledger_sequence",initialValue = 1000000000,allocationSize =3)
	@GeneratedValue(generator = "accountLedgerSeq",strategy = GenerationType.SEQUENCE)
	private Long id;
    
	private Double balanceBefore;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id",name = "account_id")
	private Account account;
	
}
