package com.service;

import com.entity.vo.LoginVo;
import com.entity.vo.UserVO;

public interface LoginService {
    UserVO login(LoginVo loginVo);
     void logout();
}
