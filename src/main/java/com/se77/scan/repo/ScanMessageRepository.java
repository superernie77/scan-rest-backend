package com.se77.scan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.se77.scan.domain.ScanMessage;

public interface ScanMessageRepository extends JpaRepository<ScanMessage, Long> {

}
