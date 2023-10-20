package com.filter;

import com.mysql.jdbc.StringUtils;
import com.utils.JwtUtil;
import com.vo.LoginUser;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String token=request.getHeader("token");
        if(StringUtils.isNullOrEmpty(token)){
            //本次放行，（后面的拦截器会拦截）
            filterChain.doFilter(request,response);
            return;
        }
        String username;
        //解析token
        try {
            username = JwtUtil.parseJWT(token).getSubject();


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("非法的token");
        }


        //从redis中获取用户信息
        String redisKey="login:"+username;
        LoginUser loginUser = (LoginUser)redisTemplate.opsForValue().get(redisKey);
        if(Objects.isNull(loginUser)){
            throw new RuntimeException("请先登录");
        }


        //存入SecurityContextHolder中
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);


        //放行
        filterChain.doFilter(request,response);
    }
}
