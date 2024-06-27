package com.example.mybatisdemo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollStreamUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisdemo.enums.CommonSortOrderEnum;
import com.example.mybatisdemo.mapper.UserMapper;
import com.example.mybatisdemo.param.AddParam;
import com.example.mybatisdemo.param.EditParam;
import com.example.mybatisdemo.param.IdParam;
import com.example.mybatisdemo.param.PageParam;
import com.example.mybatisdemo.pojo.User;
import com.example.mybatisdemo.service.UserService;

import com.example.mybatisdemo.util.CommonRequest;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
// mybatis-plus 实现条件查询，分页
    @Override
    public Page<User> page(PageParam pageParam) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().checkSqlInjection();
        if(ObjectUtil.isNotEmpty(pageParam.getName())) {
            // 按照name进行筛选
            queryWrapper.lambda().like(User::getName, pageParam.getName());
        }
        if(ObjectUtil.isAllNotEmpty(pageParam.getSortField(), pageParam.getSortOrder())) {
            // 根据sortField和sortOrder进行排序
            // sortField排序字段，sortOrder排序方式ascend或descend
            CommonSortOrderEnum.validate(pageParam.getSortOrder());
            queryWrapper.orderBy(true, pageParam.getSortOrder().equals(CommonSortOrderEnum.ASC.getValue().toLowerCase()),
                    StrUtil.toUnderlineCase(pageParam.getSortField()));
        } else {
            queryWrapper.lambda().orderByAsc(User::getId);
        }
        return this.page(CommonRequest.defaultPage(), queryWrapper);
//        return this.page(CommonRequest.defaultPage(), queryWrapper);
    }

    @Override
    public void add(AddParam addParam) {
        User user = BeanUtil.toBean(addParam, User.class);
        this.save(user);
    }

    @Override
    public User queryEntity(Integer id) throws Exception {
        User user = this.getById(id);
        if(ObjectUtil.isEmpty(user)) {
            throw new Exception("User不存在，id值为："+id);
        }
        return user;
    }

    @Override
    public void edit(EditParam editParam) throws Exception {
        User user = this.queryEntity(editParam.getId());
        BeanUtil.copyProperties(editParam, user);
        this.updateById(user);
    }

    @Override
    public void delete(List<IdParam> idParamList) {
        this.removeByIds(CollStreamUtil.toList(idParamList, IdParam::getId));
    }
}
