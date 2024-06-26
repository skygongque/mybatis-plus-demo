package com.example.mybatisdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User>{
//    继承mybatis-plus的 BaseMapper
//    大部分，单表的增删改查都不用写

//    @Select("select * from user where id = #{id}")
//    public User findById(Integer id);
}
