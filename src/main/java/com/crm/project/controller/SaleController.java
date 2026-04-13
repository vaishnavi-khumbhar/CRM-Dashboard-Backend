package com.crm.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.crm.project.entity.Sale;
import com.crm.project.service.SaleService;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin(origins = "*")
public class SaleController {

    @Autowired
    private SaleService service;

    // GET ALL
    @GetMapping
    public List<Sale> getAllSales() {
        return service.getAllSales();
    }

    // CREATE
    @PostMapping
    public Sale addSale(@RequestBody Sale sale) {
        return service.addSale(sale);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Sale updateSale(@PathVariable Long id, @RequestBody Sale sale) {
        return service.updateSale(id, sale);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteSale(@PathVariable Long id) {
        service.deleteSale(id);
        return "Sale deleted successfully";
    }
}
