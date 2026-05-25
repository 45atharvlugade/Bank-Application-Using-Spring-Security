package com.al.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="jpa_log")
@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class Log {

	@Id
	@SequenceGenerator(name = "logSeq",sequenceName = "log_sequence",initialValue = 1000000,allocationSize =1)
	@GeneratedValue(generator = "logSeq",strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NonNull
	private LocalDateTime createdAt;
	
	@NonNull
	private String message;
	@NonNull
	@ManyToOne()
	@JoinColumn(name="user_id",referencedColumnName = "userId")
	private User user;
	
	@Enumerated(EnumType.STRING)
	private LogAction action;
	
	
}
