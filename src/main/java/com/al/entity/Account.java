package com.al.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name="account_jpa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	@Id
	@SequenceGenerator(name = "accountSeq",sequenceName = "account_sequence",initialValue = 1000000000,allocationSize =3)
	@GeneratedValue(generator = "accountSeq",strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NonNull
	@Enumerated(EnumType.STRING)
	private AccountType type;
	
	@NonNull
	private Double balance;
	
	@NonNull
	@Column(nullable = false)
	private AccountStatus status;
	
	// MetaData Columns
	
	@CreationTimestamp
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDateTime updateAt;
	
	@Version
	private int updateCount;
	
	
	// Entity Relations
	
	@OneToOne(orphanRemoval = true,cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "userId",name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "account")
	private List<Transaction> transactions;
	
	@OneToMany(mappedBy = "account")
	private List<AccountLedger> accountLedgers;
	
	@OneToMany()
	private List<Loan> loans;
}
