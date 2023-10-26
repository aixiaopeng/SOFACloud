package com.entity.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderVO {
    private Long id;

    private String userName;

    private String phone;

    private String addr;

    private String productName;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private String note;


}
