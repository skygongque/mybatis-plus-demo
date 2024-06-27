package com.example.mybatisdemo.param;

import lombok.Data;

@Data
public class PageParam {
    private Integer current;
    /** 每页条数 */
    private Integer size;
    private String sortField;//排序字段，字段驼峰名称，如：userName
    /** 排序方式 */
    private String sortOrder;//排序方式，升序：ASCEND；降序：DESCEND
//    name是筛选条件
    private String name;


}
