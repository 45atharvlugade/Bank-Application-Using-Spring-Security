package com.al.entity;

import java.time.LocalDateTime;

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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * 3. Audit / Activity Log table (HIGHLY recommended)
audit_logs

Tracks every action:

user_id
action (LOGIN, TRANSFER, UPDATE)
timestamp
ip_address (optional)

✔ Used in:

security tracking
debugging
compliance
 */

@Table(name="jpa_audit")
@Entity
@Getter
@Setter
public class Audit {
	
	@Id
	@SequenceGenerator(name = "auditSeq",sequenceName = "audit_sequence",initialValue = 1000000000,allocationSize =3)
	@GeneratedValue(generator = "auditSeq",strategy = GenerationType.SEQUENCE)
	private Long id;

	@Enumerated(EnumType.STRING)
	private AuditAction action;
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(nullable = false)
	private String ipAddress;
	
	@ManyToOne()
	@JoinColumn(referencedColumnName = "userId",name="user_id")
	private User user;
}
