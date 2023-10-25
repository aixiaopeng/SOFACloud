package com.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 15012
* @description 针对表【users】的数据库操作Service
* @createDate 2023-10-22 21:33:45
*/
public interface UsersService extends IService<Users> {
    void addUser(Users user);

    //获取普通用户信息 回显数据
    Users getPublic(Long id);

    //获取管理员信息 回显数据
    Users getManager(Long id);

    //分页查询普通用户
    Page<Users> list(int page, int pageSize,int isPublic);

    //分页查询管理员
    Page<Users> listManager(int page,int pageSize);

    //修改用户信息
    Boolean updateUsers(Users user);

    //批量启用
    void enableUserByIds(List<Long> ids);

    //批量禁用
    void banUserByIds(List<Long> ids);

    //批量逻辑删除
   void  delete(List<Long> ids);



}
