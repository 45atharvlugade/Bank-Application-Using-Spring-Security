package com.al.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.al.entity.Audit;

public interface AuditRepository extends JpaRepository<Audit, Long> {

}
