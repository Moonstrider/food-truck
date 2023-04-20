package com.mountains.micro.food.truck.controller;

import com.mountains.micro.common.api.ApiResult;
import com.mountains.micro.common.vo.FoodTruckVO;
import com.mountains.micro.food.truck.param.RequestPageParam;
import com.mountains.micro.food.truck.service.BizFoodTruckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Tag(name = "food truck")
@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/food_truck")
public class BizFoodTruckController {

    private final BizFoodTruckService bizFoodTruckService;



    @Operation(summary = "query all food truck")
    @GetMapping(value = "/all")
    public ApiResult<List<FoodTruckVO>> queryAllFoodTruck() {
        return ApiResult.ok(bizFoodTruckService.queryAllFoodTruck());
    }

    @Operation(summary = "query page list food truck")
    @GetMapping(value = "/page_list")
    public ApiResult<Page<FoodTruckVO>> queryPageList(
            @Validated @RequestBody RequestPageParam requestPageParam) {
        return ApiResult.ok(bizFoodTruckService.queryPageList(requestPageParam));
    }



}
