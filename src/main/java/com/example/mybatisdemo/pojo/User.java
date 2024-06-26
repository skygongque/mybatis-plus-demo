package com.example.mybatisdemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId(type = IdType.AUTO) // mybatis-plus 指定主键更新方式
    private Integer id;
    private String name;
    private Short age;

}
