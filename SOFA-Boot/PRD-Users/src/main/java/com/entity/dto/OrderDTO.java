package com.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDTO {

    private Long orderId;

    private String orderToken;

    private Long productId;

    private Integer num;

    private BigDecimal price;




}
