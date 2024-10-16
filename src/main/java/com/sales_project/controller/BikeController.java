package com.sales_project.controller;

import com.sales_project.dto.BikeSalesdto;
import com.sales_project.model.BikeSales;
import com.sales_project.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bike-sales")
public class BikeController {

    private final SalesService bikeSalesService;

    @Autowired
    public BikeController(SalesService bikeSalesService) {
        this.bikeSalesService = bikeSalesService;
    }

    @PostMapping
    public ResponseEntity<BikeSales> addSales(@RequestBody BikeSalesdto bikeSalesdto) {
        BikeSales bikeSales = bikeSalesService.addSales(bikeSalesdto);
        return new ResponseEntity<>(bikeSales, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BikeSales>> getAllSales() {
        List<BikeSales> salesList = bikeSalesService.getAllSales();
        return new ResponseEntity<>(salesList, HttpStatus.OK);
    }

    @GetMapping("/{salesId}")
    public ResponseEntity<BikeSales> getSalesById(@PathVariable long salesId) {
        BikeSales bikeSales = bikeSalesService.getSalesById(salesId);
        return new ResponseEntity<>(bikeSales, HttpStatus.OK);
    }

    @PutMapping("/{salesId}")
    public ResponseEntity<BikeSales> updateSales(
            @PathVariable long salesId,
            @RequestBody BikeSalesdto bikeSalesdto) {
        BikeSales updatedBikeSales = bikeSalesService.updateSales(salesId, bikeSalesdto);
        return new ResponseEntity<>(updatedBikeSales, HttpStatus.OK);
    }

    @DeleteMapping("/{salesId}")
    public ResponseEntity<Void> deleteSales(@PathVariable long salesId) {
        bikeSalesService.deleteSales(salesId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/type/{bikeType}")
    public ResponseEntity<List<BikeSalesdto>> findByType(@PathVariable String bikeType) {
        List<BikeSalesdto> salesList = bikeSalesService.findByType(bikeType);
        return new ResponseEntity<>(salesList, HttpStatus.OK);
    }

    @GetMapping("/status/{saleStatus}")
    public ResponseEntity<List<BikeSalesdto>> findSalesByStatus(@PathVariable String saleStatus) {
        List<BikeSalesdto> salesList = bikeSalesService.findSalesByStatus(saleStatus);
        return new ResponseEntity<>(salesList, HttpStatus.OK);
    }

    @GetMapping("/sales-person/{salesPersonName}/count")
    public ResponseEntity<Long> countSalesBySalesPerson(@PathVariable String salesPersonName) {
        Long count = bikeSalesService.countSalesBySalesPerson(salesPersonName);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<BikeSalesdto>> findSalesInDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        List<BikeSalesdto> salesList = bikeSalesService.findSalesInDateRange(startDate, endDate);
        return new ResponseEntity<>(salesList, HttpStatus.OK);
    }
}
