package com.entity.vo;

import com.entity.Users;
import lombok.Data;

@Data
public class UserVO extends Users {
    private String token;
}
