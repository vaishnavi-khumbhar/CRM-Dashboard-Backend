package com.crm.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.crm.project.entity.Customer;
import com.crm.project.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    // ✅ GET ALL
    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    // ✅ CREATE
    public Customer addCustomer(Customer customer) {
        return repo.save(customer);
    }

    // ✅ GET BY ID
    public Customer getCustomerById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    // ✅ UPDATE
    public Customer updateCustomer(Long id, Customer customer) {
        Customer existing = getCustomerById(id);

        existing.setName(customer.getName());
        existing.setEmail(customer.getEmail());
        existing.setPhone(customer.getPhone());
        existing.setStatus(customer.getStatus());

        return repo.save(existing);
    }

    // ✅ DELETE
    public void deleteCustomer(Long id) {
        repo.deleteById(id);
    }
}