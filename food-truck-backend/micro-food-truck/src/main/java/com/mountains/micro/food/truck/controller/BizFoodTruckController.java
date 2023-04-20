package com.mountains.micro.food.truck.controller;

import com.mountains.micro.common.api.ApiResult;
import com.mountains.micro.common.vo.FoodTruckVO;
import com.mountains.micro.food.truck.service.BizFoodTruckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@Tag(name = "food truck")
@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/food_truck")
public class BizFoodTruckController {

    private final BizFoodTruckService bizFoodTruckService;


    /**
     * not a page query
     *
     * 200 records of samples
     */
    @Operation(summary = "query all food truck")
    @GetMapping(value = "/all")
    public ApiResult<List<FoodTruckVO>> queryAllFoodTruck() {
        return ApiResult.ok(bizFoodTruckService.queryAllFoodTruck());
    }

//    @Operation(summary = "query all food truck by name")
//    @GetMapping(value = "/all")
//    public ApiResult<List<FoodTruckVO>> queryAllFoodTruckByName(
//            @RequestParam String name
//    ) {
//        return ApiResult.ok(bizFoodTruckService.queryAllFoodTruckByName());
//    }


}
