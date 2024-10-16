package com.sales_project.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BikeSalesdto {

    @NotBlank(message = "Bike model cannot be blank")
    @Min(value = 2000,message = "Model should be greater than 2000")
    private int bikeModel;

    @NotBlank(message = "Bike type cannot be blank")
    @Pattern(regexp = "^(SCOOTER|BIKE)$", message = "Bike type should be either SCOOTER or BIKE")
    private String bikeType;

    @NotBlank(message = "Customer name cannot be blank")
    private String custName;

    @Pattern(regexp = "^[0-9]{10}$")
    private String custPhone;

    @NotBlank(message = "Sales date is required")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "sales date should be in the format YYYY-MM-DD")
    private String salesDate;

    @NotBlank(message = "Price is required")
    private Double price;

    @NotBlank(message = "Delivery location is required")
    private String deliveryLocation;

    @Pattern(regexp = "^(CASH|CARD|EMI)$",message = "payment mode should be either Cash or card or EMI")
    private String paymentMode;

    @NotBlank(message = "Sales person name is required")
    private String salesPersonName;

    private int numberOfService;

    @NotBlank(message = "Sale status is required")
    @Pattern(regexp = "^(PENDING|COMPLETED)$", message = "Sale status should be either Pending or Completed")
    private String saleStatus;
}
