package com.entity.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderVO {
    private Long orderId;

    private String userName;

    private String phone;

    private String addr;

    private String productName;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private String note;


    private String orderToken;

    private Date createdAt;

}
