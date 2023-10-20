package com.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("users")
public class Users implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String realName;
    private String phone;
    private String role;
    private String bankCard;
    private Integer points;
    private Date created_at;
    private Date deleted_at;
    private Integer status;


}
