package com.example.mybatisdemo.param;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EditParam {
    @NotNull(message = "id不能为空")
    private Integer id;
    private String name;
    private Short age;
}
