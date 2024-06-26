package com.example.mybatisdemo.param;

import lombok.Data;

@Data
public class PageParam {
    private Integer current;

    /** 每页条数 */
    private Integer size;
//    name是筛选条件
    private String name;
}
