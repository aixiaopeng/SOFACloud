package com.service;

import com.entity.vo.LoginVo;

public interface LoginService {
    String login(LoginVo loginVo);
     void logout();
}
