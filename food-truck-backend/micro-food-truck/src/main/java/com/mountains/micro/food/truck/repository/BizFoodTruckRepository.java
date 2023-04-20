package com.mountains.micro.food.truck.repository;

import com.mountains.micro.common.entity.BizFoodTruck;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BizFoodTruckRepository extends CrudRepository<BizFoodTruck, Long> {

    @Query(value = "select * from biz_food_truck where 1=1 " +
            "order by id desc ",
            nativeQuery = true)
    List<BizFoodTruck> queryAll();


}
