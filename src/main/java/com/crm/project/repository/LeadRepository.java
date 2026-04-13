package com.crm.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crm.project.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {
}
