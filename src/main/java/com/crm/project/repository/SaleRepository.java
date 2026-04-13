package com.crm.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crm.project.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
