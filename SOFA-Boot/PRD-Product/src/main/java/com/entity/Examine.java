package com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Examine {
    /**
     * 产品ID
     */
    private Long id;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 产品类别
     */
    private Long category;

    /**
     * 产品状态 (0 = 无效, 1 = 有效)
     */
    private Integer status;

    /**
     * 产品图片链接
     */
    private String imgurl;

    /**
     * 产品描述
     */
    private String description;

    /**
     * 产品价格
     */
    private BigDecimal price;

    /**
     * 产品数量
     */
    private Integer num;

    /**
     * 已售数量
     */
    private Integer sold;

    /**
     * 折扣后

     */
    private BigDecimal discountPrice;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 删除时间
     */
    private Date deletedAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     *
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date discountBegin;

    /**
     *
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date discountEnd;

    private static final long serialVersionUID = 1L;

    private String notes;
}
