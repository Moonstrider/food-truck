package com.mountains.micro.common.vo;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
public class FoodTruckVO {

    private String locationId;

    private String applicant;

    private String facilityType;

}
