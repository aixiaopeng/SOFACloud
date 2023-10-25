package com.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDTO {

    private Long userId;
    private String userName;
    private String addr;
    private String phone;

    private Long productId;
    private String name;
    private String imgUrl;

    private BigDecimal price;
    private BigDecimal discountPrice;

}
