package com.entity.vo;

import com.entity.Users;
import lombok.Data;

@Data
public class UserVO {
    private Long userId;
    private String name;
    private String userName;
    private String addr;
    private String phone;
    private String token;
    private String bankCard;
}
