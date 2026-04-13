package com.crm.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.crm.project.entity.Sale;
import com.crm.project.repository.SaleRepository;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repo;

    // GET ALL
    public List<Sale> getAllSales() {
        return repo.findAll();
    }

    // CREATE
    public Sale addSale(Sale sale) {
        return repo.save(sale);
    }

    // UPDATE
    public Sale updateSale(Long id, Sale sale) {
        Sale existing = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Sale not found"));

        existing.setProduct(sale.getProduct());
        existing.setAmount(sale.getAmount());
        existing.setDate(sale.getDate());
        existing.setCustomerId(sale.getCustomerId());

        return repo.save(existing);
    }

    // DELETE
    public void deleteSale(Long id) {
        repo.deleteById(id);
    }
}
