package com.Impl;

import com.entity.Users;
import com.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UsersDetailServiceImpl implements UserDetailsService {

//    自定义数据库登录

    @Autowired
    private UsersServiceImpl usersDal;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersDal.lambdaQuery().eq(Users::getUsername, username).one();

        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        //根据用户查询权限信息 添加到LoginUser中
        String role=user.getRole();
        List<String> list = new ArrayList<>(Arrays.asList(role));
        return new LoginUser(user,list);
    }
}
