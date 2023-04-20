package com.mountains.micro.common.entity;

import com.mountains.micro.common.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString()
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Entity
@Table(name = "biz_food_truck")
public class BizFoodTruck extends BaseEntity {

    @Column(name = "applicant")
    private String applicant;

    @Column(name = "facility_type")
    private String facilityType;

}
