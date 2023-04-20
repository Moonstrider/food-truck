package com.mountains.micro.food.truck.param;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Paging<T> extends PageImpl<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 2184161312604416491L;

    public Paging(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public Paging(List<T> content) {
        super(content);
    }

    public Paging(Page<Map<String, Object>> pageMap, Class<T> cls) {
        super(BeanUtil.copyToList(pageMap.getContent(), cls), pageMap.getPageable(), pageMap.getTotalElements());
    }

}
