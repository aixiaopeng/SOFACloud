package com.entity;

import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName shopping_cart
 */
public class ShoppingCart implements Serializable {
    /**
     * 购物车记录的唯一标识
     */
    private Long id;

    /**
     * 用户 ID，与用户表相关联
     */
    private Long userId;

    /**
     * 产品 ID，与产品表相关联
     */
    private Long productId;

    /**
     * 记录创建时间
     */
    private Date createdAt;

    /**
     * 记录删除时间
     */
    private Date deletedAt;

    /**
     * 记录更新时间
     */
    private Date updatedAt;

    private Integer num;

    private static final long serialVersionUID = 1L;

    /**
     * 购物车记录的唯一标识
     */
    public Long getId() {
        return id;
    }

    public Integer getNum(){
        return num;
    }


    public void setNum(Integer num){
        this.num=num;
    }
    /**
     * 购物车记录的唯一标识
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户 ID，与用户表相关联
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户 ID，与用户表相关联
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 产品 ID，与产品表相关联
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 产品 ID，与产品表相关联
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 记录创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 记录创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 记录删除时间
     */
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     * 记录删除时间
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * 记录更新时间
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 记录更新时间
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
        ShoppingCart other = (ShoppingCart) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getDeletedAt() == null ? other.getDeletedAt() == null : this.getDeletedAt().equals(other.getDeletedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getDeletedAt() == null) ? 0 : getDeletedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", productId=").append(productId);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}