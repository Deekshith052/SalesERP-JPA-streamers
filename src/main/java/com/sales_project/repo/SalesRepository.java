package com.sales_project.repo;

import com.sales_project.model.BikeSales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<BikeSales,Long> {

}
