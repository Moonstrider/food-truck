package com.mountains.micro.common.entity.base;

import com.mountains.micro.common.util.ValidationUtil;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -2231451542178967521L;

    public static final Integer INT_TRUE = 1;
    public static final Integer INT_FALSE = 0;

    public static final int ACTIVE = INT_TRUE;
    public static final int NOT_ACTIVE = INT_FALSE;


    @Id
    @Column(name = "id", unique = true, nullable = false)
//    @GeneratedValue(generator = "snowFlakeId")
//    @GenericGenerator(name = "snowFlakeId", strategy = "com.mountains.micro.common.util.SnowflakeIdGenerator")
    public Long id;

    @Column(name = "create_time", length = 6, updatable = false)
    private Date createTime;

    @Column(name = "create_by", length = 50, updatable = false)
    private String createBy;

    @Column(name = "update_time", length = 6)
    private Date updateTime;

    @Column(name = "update_by", length = 50)
    private String updateBy;

    @Column(name = "is_active", length = 16, insertable = false, nullable = false, columnDefinition = "int2 DEFAULT 1")
    private Integer isActive;

    @Column(name = "version", length = 32, insertable = false, nullable = false, columnDefinition = "int2 DEFAULT 1")
    private Integer version;


    public boolean checkIsNewRecord() {
        return ValidationUtil.isObjectNull(this.id);
    }

    public boolean checkIsExistingRecord() {
        return ValidationUtil.isObjectNotNull(this.id);
    }

    public boolean checkIsActive() {
        return ACTIVE == this.isActive;
    }

    public boolean checkIsNotActive() {
        return NOT_ACTIVE == this.isActive;
    }

}
