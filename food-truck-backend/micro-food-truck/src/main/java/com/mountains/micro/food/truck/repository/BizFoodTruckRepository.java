package com.mountains.micro.food.truck.repository;

import com.mountains.micro.common.entity.BizFoodTruck;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BizFoodTruckRepository extends CrudRepository<BizFoodTruck, Long> {

    @Query(value = "select * from biz_food_truck where 1=1 " +
            "order by id desc ",
            nativeQuery = true)
    List<BizFoodTruck> queryAll();

    @Query(value = "select * from biz_food_truck where 1=1 " +
            "order by id desc ",
            nativeQuery = true)
    Page<Map<String, Object>> nativeQueryPageList(Pageable pageable);


}
