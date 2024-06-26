package com.example.mybatisdemo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisdemo.param.AddParam;
import com.example.mybatisdemo.param.EditParam;
import com.example.mybatisdemo.param.IdParam;
import com.example.mybatisdemo.param.PageParam;
import com.example.mybatisdemo.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {
//    public User findById(Integer id);
    Page<User> page(PageParam pageParam);
    void add(AddParam addParam);
    User queryEntity(Integer id) throws Exception;
    void edit(EditParam editParam) throws Exception;
    void delete(List<IdParam> idParamList);
}
