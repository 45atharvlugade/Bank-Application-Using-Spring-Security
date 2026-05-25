package com.al.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.al.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long> {

}
