package com.service.impl;


import com.entity.vo.LoginUser;
import com.entity.vo.LoginVo;
import com.service.LoginService;
import com.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public void logout() {
        //在SecurityContextHolder中获得id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        LoginUser loginUser = (LoginUser)authentication.getPrincipal();

        String username=loginUser.getUsername();

        //删除redis中的值
        redisTemplate.opsForValue().getAndDelete("login:"+username);
    }

    @Override
    public String login(LoginVo loginVo) {
        //进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(loginVo.getUsername(),loginVo.getPassword());
        Authentication authentication=authenticationManager.authenticate(authenticationToken);

        //认证失败
        if (Objects.isNull(authentication)) {
            throw new RuntimeException("登录失败");
        }

        //认证成功，生产jwt，存入到redis中，并返回
        LoginUser loginUser=(LoginUser)authentication.getPrincipal();
        String jwtToken = JwtUtil.createJWT(loginUser.getUsername());

        redisTemplate.opsForValue().set("login:"+loginUser.getUsername(),loginUser);

        return jwtToken;
    }
}
