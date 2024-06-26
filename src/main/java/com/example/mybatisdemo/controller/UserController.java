package com.example.mybatisdemo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisdemo.param.AddParam;
import com.example.mybatisdemo.param.EditParam;
import com.example.mybatisdemo.param.IdParam;
import com.example.mybatisdemo.param.PageParam;
import com.example.mybatisdemo.pojo.User;
import com.example.mybatisdemo.service.UserService;
import com.example.mybatisdemo.util.CommonResult;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/page")
    public CommonResult<Page<User>> page(PageParam pageParam) {
        return CommonResult.data(userService.page(pageParam));
    }

    @RequestMapping("/detail")
    public CommonResult<User> findById(Integer id) throws Exception {
        return CommonResult.data(userService.queryEntity(id));
    }
//     validation 实现数据校验
    @PostMapping("/add")
    public CommonResult<String> add(@RequestBody @Valid AddParam addParam) {
        userService.add(addParam);
        return CommonResult.ok();
    }
    @PostMapping("/edit")
    public CommonResult<String> edit(@RequestBody @Valid EditParam editParam) throws Exception {
        userService.edit(editParam);
        return CommonResult.ok();
    }
    @PostMapping("/delete")
    public CommonResult<String> delete(@RequestBody @Valid @NotEmpty(message = "集合不能为空")
                                       List<IdParam> idParamList) {
        userService.delete(idParamList);
        return CommonResult.ok();
    }
}
