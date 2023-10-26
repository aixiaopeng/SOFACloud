package com.entity.vo;

import io.swagger.models.auth.In;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ShoppingCartVO {

    private Long productId;

    private String name;

    private String imgUrl;

    private String description;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private Date createdAt;

    private Integer num;
}
