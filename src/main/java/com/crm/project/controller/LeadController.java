package com.crm.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.crm.project.entity.Lead;
import com.crm.project.service.LeadService;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = "*")
public class LeadController {

    @Autowired
    private LeadService service;

    // GET ALL
    @GetMapping
    public List<Lead> getAllLeads() {
        return service.getAllLeads();
    }

    // CREATE
    @PostMapping
    public Lead addLead(@RequestBody Lead lead) {
        return service.addLead(lead);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Lead updateLead(@PathVariable Long id, @RequestBody Lead lead) {
        return service.updateLead(id, lead);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteLead(@PathVariable Long id) {
        service.deleteLead(id);
        return "Lead deleted successfully";
    }
}
