package com.crm.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.crm.project.entity.Customer;
import com.crm.project.service.CustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService service;

    // ✅ GET ALL
    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    // ✅ CREATE
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.addCustomer(customer);
    }

    // ✅ UPDATE
    @PutMapping("/customers/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        System.out.println("PUT API HIT");
        return service.updateCustomer(id, customer);
    }

    // ✅ DELETE (FIXED)
    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id); // 🔥 important
        return "Customer deleted successfully";
    }
}