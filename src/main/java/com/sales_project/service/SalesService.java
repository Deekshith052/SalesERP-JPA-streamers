package com.sales_project.service;

import com.sales_project.dto.BikeSalesdto;
import com.sales_project.model.BikeSales;
import com.sales_project.repo.SalesRepository;
import com.speedment.jpastreamer.application.JPAStreamer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private SalesRepository repo;


    private JPAStreamer JpaStreamer;

    @Autowired
    public SalesService(JPAStreamer jpaStreamer) {
        this.JpaStreamer = jpaStreamer;
    }

    public BikeSales addSales(BikeSalesdto bikeSalesdto) {
        BikeSales b= BikeSales.builder()
                .bikeModel(bikeSalesdto.getBikeModel())
                .bikeType(bikeSalesdto.getBikeType())
                .custName(bikeSalesdto.getCustName())
                .custPhone(bikeSalesdto.getCustPhone())
                .salesDate(bikeSalesdto.getSalesDate())
                .price(bikeSalesdto.getPrice())
                .deliveryLocation(bikeSalesdto.getDeliveryLocation())
                .paymentMode(bikeSalesdto.getPaymentMode())
                .salesPersonName(bikeSalesdto.getSalesPersonName())
                .numberOfService(bikeSalesdto.getNumberOfService())
                .saleStatus(bikeSalesdto.getSaleStatus())
                .build();
        return repo.save(b);
    }

    public List<BikeSales> getAllSales() {
        return repo.findAll();
    }

    public BikeSales getSalesById(long salesId) {
        Optional<BikeSales> optionalBikeSales = repo.findById(salesId);
        if(optionalBikeSales.isPresent()){
            return optionalBikeSales.get();
        }
        throw new RuntimeException("Sales record not found with id: " + salesId);
    }

    public BikeSales updateSales(long salesId, BikeSalesdto bikeSalesdto) {
        Optional<BikeSales> optionalBikeSales = repo.findById(salesId);
        if(optionalBikeSales.isPresent()){
            BikeSales existingBikeSales = optionalBikeSales.get();
            existingBikeSales.setBikeModel(bikeSalesdto.getBikeModel());
            existingBikeSales.setBikeType(bikeSalesdto.getBikeType());
            existingBikeSales.setCustName(bikeSalesdto.getCustName());
            existingBikeSales.setCustPhone(bikeSalesdto.getCustPhone());
            existingBikeSales.setSalesDate(bikeSalesdto.getSalesDate());
            existingBikeSales.setPrice(bikeSalesdto.getPrice());
            existingBikeSales.setDeliveryLocation(bikeSalesdto.getDeliveryLocation());
            existingBikeSales.setPaymentMode(bikeSalesdto.getPaymentMode());
            existingBikeSales.setSalesPersonName(bikeSalesdto.getSalesPersonName());
            existingBikeSales.setNumberOfService(bikeSalesdto.getNumberOfService());
            existingBikeSales.setSaleStatus(bikeSalesdto.getSaleStatus());
            return repo.save(existingBikeSales);
        }
        throw new RuntimeException("Sales record not found with id: " + salesId);
    }

    public void deleteSales(long salesId) {
        Optional<BikeSales> optionalBikeSales = repo.findById(salesId);
        if(optionalBikeSales.isPresent()){
            repo.deleteById(salesId);
        }
        throw new RuntimeException("Sales record not found with id: " + salesId);
    }

    public List<BikeSalesdto> findByType(String bikeType) {
        return JpaStreamer.stream(BikeSalesdto.class)
                .filter(bike -> bike.getBikeType().equalsIgnoreCase(bikeType))
                .toList();
    }


    public List<BikeSalesdto> findSalesByStatus(String saleStatus) {
        return JpaStreamer.stream(BikeSalesdto.class)
                .filter(bike -> bike.getSaleStatus().equalsIgnoreCase(saleStatus))
                .toList();
    }

    public Long countSalesBySalesPerson(String salesPersonName) {
        return JpaStreamer.stream(BikeSalesdto.class)
                .filter(bike -> bike.getSalesPersonName().equalsIgnoreCase(salesPersonName))
                .count();
    }

    public List<BikeSalesdto> findSalesInDateRange(String startDate, String endDate) {
        return JpaStreamer.stream(BikeSalesdto.class)
                .filter(bike -> bike.getSalesDate().compareTo(startDate) >= 0 && bike.getSalesDate().compareTo(endDate) <= 0)
                .toList();
    }

}