package com.mountains.micro.food.truck.service.impl;

import com.mountains.micro.common.convertor.BizFoodTruckConverter;
import com.mountains.micro.common.entity.BizFoodTruck;
import com.mountains.micro.common.vo.FoodTruckVO;
import com.mountains.micro.food.truck.repository.BizFoodTruckRepository;
import com.mountains.micro.food.truck.service.BizFoodTruckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BizFoodTruckServiceImpl implements BizFoodTruckService {

    private final BizFoodTruckRepository bizFoodTruckRepository;

    @Override
    public List<FoodTruckVO> queryAllFoodTruck() {
        List<BizFoodTruck> bizFoodTruckList = bizFoodTruckRepository.queryAll();
        return BizFoodTruckConverter.bizFoodTruckToFoodTruckVO(bizFoodTruckList);
    }


}
