package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName discount
 */
public class Discount implements Serializable {
    /**
     * 折扣ID
     */
    private Long id;

    /**
     * 关联的产品ID
     */
    private Long productId;

    /**
     * 折扣价格
     */
    private BigDecimal price;

    /**
     * 折扣开始时间
     */
    private Date startTime;

    /**
     * 折扣结束时间
     */
    private Date endTime;

    private static final long serialVersionUID = 1L;

    /**
     * 折扣ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 折扣ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 关联的产品ID
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 关联的产品ID
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 折扣价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 折扣价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 折扣开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 折扣开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 折扣结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 折扣结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Discount other = (Discount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", price=").append(price);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}