package com.mountains.micro.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

@Data
@Accessors(chain = true)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FoodTruckVO {

    private String locationId;

    private String applicant;

    private String facilityType;

    public FoodTruckVO(Map<String, Object> map) {
        this.locationId = String.valueOf(map.get("id"));
        this.applicant =(String)map.get("applicant");
        this.facilityType = (String)map.get("facilityType");
    }

}
