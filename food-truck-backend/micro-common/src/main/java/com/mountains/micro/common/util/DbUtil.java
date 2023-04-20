package com.mountains.micro.common.util;


import com.mountains.micro.common.entity.base.BaseEntity;

import java.util.Date;

public class DbUtil {

    public static Object setAuditInfo(Object o) {

//        String username = LoginUtil.getUsername();
        String username = "Morgen";

        if (o instanceof BaseEntity entity) {
            if (entity.getId() == null || ValidationUtil.isStringEmpty(entity.getCreateBy())) {
                entity.setCreateTime(new Date());
                entity.setCreateBy(username);
            }
            entity.setUpdateTime(DateUtil.getCurrentJavaDate());
            entity.setUpdateBy(username);

            return entity;
        }

        return o;
    }

}
