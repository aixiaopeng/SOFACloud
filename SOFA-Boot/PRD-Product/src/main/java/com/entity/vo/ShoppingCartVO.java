package com.entity.vo;

import com.entity.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class ShoppingCartVO  {

    private Long productId;

    private String name;

    private String imgUrl;

    private String description;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private Date createdAt;

    private Integer num;
}
