package com.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单信息表，用于存储用户订单信息
 * @TableName order
 */
public class Order implements Serializable {
    /**
     * 订单ID
     */
    private Long id;

    /**
     * 用户ID，关联到用户表
     */
    private Long userId;

    /**
     * 产品ID，关联到产品表
     */
    private Long productId;

    /**
     * 订单金额
     */
    private BigDecimal price;

    /**
     * 配送地址
     */
    private String addr;

    /**
     * 订单状态
     */
    private String status;

    /**
     * 订单备注
     */
    private String note;

    /**
     * 退款时间
     */
    private Date refundTime;

    /**
     * 退款金额
     */
    private BigDecimal refundAmount;

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
    private String userName;

    /**
     * 
     */
    private String phone;

    /**
     * 
     */
    private String productName;

    /**
     * 
     */
    private String productImgurl;

    /**
     * 
     */
    private BigDecimal discountprice;

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 订单ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户ID，关联到用户表
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户ID，关联到用户表
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 产品ID，关联到产品表
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 产品ID，关联到产品表
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 订单金额
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 订单金额
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 配送地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 配送地址
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * 订单状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 订单状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 订单备注
     */
    public String getNote() {
        return note;
    }

    /**
     * 订单备注
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 退款时间
     */
    public Date getRefundTime() {
        return refundTime;
    }

    /**
     * 退款时间
     */
    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    /**
     * 退款金额
     */
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    /**
     * 退款金额
     */
    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    /**
     * 创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 删除时间
     */
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     * 删除时间
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    /**
     * 更新时间
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 更新时间
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 
     */
    public String getProductImgurl() {
        return productImgurl;
    }

    /**
     * 
     */
    public void setProductImgurl(String productImgurl) {
        this.productImgurl = productImgurl;
    }

    /**
     * 
     */
    public BigDecimal getDiscountprice() {
        return discountprice;
    }

    /**
     * 
     */
    public void setDiscountprice(BigDecimal discountprice) {
        this.discountprice = discountprice;
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
        Order other = (Order) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getAddr() == null ? other.getAddr() == null : this.getAddr().equals(other.getAddr()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getRefundTime() == null ? other.getRefundTime() == null : this.getRefundTime().equals(other.getRefundTime()))
            && (this.getRefundAmount() == null ? other.getRefundAmount() == null : this.getRefundAmount().equals(other.getRefundAmount()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getDeletedAt() == null ? other.getDeletedAt() == null : this.getDeletedAt().equals(other.getDeletedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getProductImgurl() == null ? other.getProductImgurl() == null : this.getProductImgurl().equals(other.getProductImgurl()))
            && (this.getDiscountprice() == null ? other.getDiscountprice() == null : this.getDiscountprice().equals(other.getDiscountprice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getAddr() == null) ? 0 : getAddr().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getRefundTime() == null) ? 0 : getRefundTime().hashCode());
        result = prime * result + ((getRefundAmount() == null) ? 0 : getRefundAmount().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getDeletedAt() == null) ? 0 : getDeletedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getProductImgurl() == null) ? 0 : getProductImgurl().hashCode());
        result = prime * result + ((getDiscountprice() == null) ? 0 : getDiscountprice().hashCode());
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
        sb.append(", price=").append(price);
        sb.append(", addr=").append(addr);
        sb.append(", status=").append(status);
        sb.append(", note=").append(note);
        sb.append(", refundTime=").append(refundTime);
        sb.append(", refundAmount=").append(refundAmount);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", userName=").append(userName);
        sb.append(", phone=").append(phone);
        sb.append(", productName=").append(productName);
        sb.append(", productImgurl=").append(productImgurl);
        sb.append(", discountprice=").append(discountprice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}