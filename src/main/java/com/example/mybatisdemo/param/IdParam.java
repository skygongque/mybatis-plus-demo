package com.example.mybatisdemo.param;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IdParam {
    @NotNull(message = "id不能为空")
    private Integer id;
}
