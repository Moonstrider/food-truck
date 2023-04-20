package com.mountains.micro.food.truck.param;

import com.mountains.micro.common.util.ValidationUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class PageParam implements Serializable {
    @Serial
    private static final long serialVersionUID = -1263921952635611211L;

    private static final int SIZE_LIMIT = 100;

    private static final String SIZE_NAME = "page size";

    private String search;

    private String sort;

    private Integer page = 0;

    private Integer size = 10;

    public PageParam(String search) {
        this.search = search;
    }

    public PageParam(String search, String sort) {
        this.search = search;
        this.sort = sort;
    }

    public PageParam(Integer page, Integer size) {
        ValidationUtil.checkOverLimit(SIZE_NAME, size, SIZE_LIMIT);
        this.page = page;
        this.size = size;
    }

    public PageParam(String search, String sort, Integer page, Integer size) {
        ValidationUtil.checkOverLimit(SIZE_NAME, size, SIZE_LIMIT);
        this.search = search;
        this.sort = sort;
        this.page = page;
        this.size = size;
    }

    public void setSize(Integer size) {
        ValidationUtil.checkOverLimit(SIZE_NAME, size, SIZE_LIMIT);
        this.size = size;
    }

    public PageRequest getPageRequest() {
        return PageRequest.of(this.getPage(), this.getSize());
    }

    public void setMaxSize() {
        this.size = Integer.MAX_VALUE;
    }
}
