package com.sales_project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Document(collection = "bike_sales")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bike_sales")
@Builder
public class BikeSales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salesId;
    private int bikeModel;
    private String bikeType;
    private String custName;
    private String custPhone;
    private String salesDate;
    private Double price;
    private String deliveryLocation;
    private String paymentMode;
    private String salesPersonName;
    private int numberOfService;
    private String saleStatus;
}
