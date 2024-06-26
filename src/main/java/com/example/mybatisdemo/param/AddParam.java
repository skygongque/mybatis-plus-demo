package com.example.mybatisdemo.param;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AddParam {
    private Integer id;
//     validation 实现数据校验
    @NotEmpty(message = "name不能为空")
    private String name;
    private Short age;
}
