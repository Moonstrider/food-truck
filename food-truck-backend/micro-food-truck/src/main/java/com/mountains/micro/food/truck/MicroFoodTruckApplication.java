package com.mountains.micro.food.truck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@EntityScan(basePackages = "com.mountains.micro.common.entity")
public class MicroFoodTruckApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroFoodTruckApplication.class, args);
    }

}
