package com.mountains.micro.food.truck.service.impl;

import com.mountains.micro.common.convertor.BizFoodTruckConverter;
import com.mountains.micro.common.entity.BizFoodTruck;
import com.mountains.micro.common.vo.FoodTruckVO;
import com.mountains.micro.food.truck.param.Paging;
import com.mountains.micro.food.truck.param.RequestPageParam;
import com.mountains.micro.food.truck.repository.BizFoodTruckRepository;
import com.mountains.micro.food.truck.service.BizFoodTruckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class BizFoodTruckServiceImpl implements BizFoodTruckService {

    private final BizFoodTruckRepository bizFoodTruckRepository;

    @Override
    public List<FoodTruckVO> queryAllFoodTruck() {
        List<BizFoodTruck> bizFoodTrucks = bizFoodTruckRepository.queryAll();
        return BizFoodTruckConverter.bizFoodTruckToFoodTruckVO(bizFoodTrucks);
    }


    @Override
    public Page<FoodTruckVO> queryPageList(RequestPageParam requestPageParam) {
        PageRequest pageParam = PageRequest.of(requestPageParam.getPage(), requestPageParam.getSize());
        Page<Map<String, Object>> pageMaps = bizFoodTruckRepository.nativeQueryPageList(pageParam);
        List<FoodTruckVO> alertVOList = pageMaps.stream().map(FoodTruckVO::new).toList();
        return new Paging<>(alertVOList, pageMaps.getPageable(), pageMaps.getTotalElements());

    }


}
