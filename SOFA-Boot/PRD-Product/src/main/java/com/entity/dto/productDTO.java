package com.entity.dto;

import io.swagger.models.auth.In;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class productDTO {
    private Long id;
    private String name;
    private Integer priority;
    private Long categoryId;
    private Integer status;
    private String imgUrl;
    private String description;
    private BigDecimal price;
    private Integer num;
    private Integer sold;
    private BigDecimal discountPrice;

}
