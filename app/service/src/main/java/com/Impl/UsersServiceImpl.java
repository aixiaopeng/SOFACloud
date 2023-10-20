package com.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Users;
import com.mapper.UsersMapper;
import com.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper,Users> implements UsersService {

}
