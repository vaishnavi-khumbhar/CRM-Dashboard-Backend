package com.crm.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crm.project.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}