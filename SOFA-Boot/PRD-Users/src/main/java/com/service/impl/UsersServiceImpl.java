package com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.Users;
import com.service.UsersService;
import com.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
* @author 15012
* @description 针对表【users】的数据库操作Service实现
* @createDate 2023-10-22 21:33:45
*/
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users>
    implements UsersService{

}




