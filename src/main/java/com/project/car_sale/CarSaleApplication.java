package com.project.car_sale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.project.car_sale.mapper")
public class CarSaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSaleApplication.class, args);
	}

}
