package com.crm.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.crm.project.entity.Lead;
import com.crm.project.repository.LeadRepository;

@Service
public class LeadService {

    @Autowired
    private LeadRepository repo;

    // GET ALL
    public List<Lead> getAllLeads() {
        return repo.findAll();
    }

    // CREATE
    public Lead addLead(Lead lead) {
        return repo.save(lead);
    }

    // UPDATE
    public Lead updateLead(Long id, Lead lead) {
        Lead existing = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Lead not found"));

        existing.setName(lead.getName());
        existing.setEmail(lead.getEmail());
        existing.setPhone(lead.getPhone());
        existing.setStatus(lead.getStatus());

        return repo.save(existing);
    }

    // DELETE
    public void deleteLead(Long id) {
        repo.deleteById(id);
    }
}
