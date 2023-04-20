package com.mountains.micro.food.truck.service;

import com.mountains.micro.common.vo.FoodTruckVO;
import com.mountains.micro.food.truck.param.RequestPageParam;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BizFoodTruckService {

    List<FoodTruckVO> queryAllFoodTruck();

    Page<FoodTruckVO> queryPageList(RequestPageParam requestPageParam);


}
