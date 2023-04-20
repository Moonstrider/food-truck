package com.mountains.micro.common.convertor;

import com.mountains.micro.common.entity.BizFoodTruck;
import com.mountains.micro.common.vo.FoodTruckVO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class BizFoodTruckConverter {

    public static FoodTruckVO bizFoodTruckToFoodTruckVO(BizFoodTruck bizFoodTruck) {
        FoodTruckVO foodTruckVO = new FoodTruckVO();
        foodTruckVO.setLocationId(String.valueOf(bizFoodTruck.getId()));
        foodTruckVO.setFacilityType(bizFoodTruck.getFacilityType());
        foodTruckVO.setApplicant(bizFoodTruck.getApplicant());
        return foodTruckVO;
    }

    public static List<FoodTruckVO> bizFoodTruckToFoodTruckVO(
            List<BizFoodTruck> bizFoodTruckList) {
        if (CollectionUtils.isEmpty(bizFoodTruckList)) {
            return new ArrayList<>();
        }
        List<FoodTruckVO> foodTruckVOList = new ArrayList<>(bizFoodTruckList.size() + 2);
        for (BizFoodTruck bizFoodTruck : bizFoodTruckList) {
            foodTruckVOList.add(bizFoodTruckToFoodTruckVO(bizFoodTruck));
        }
        return foodTruckVOList;
    }


}
