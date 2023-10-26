package com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @TableName product
 */
public class Product implements Serializable {
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
    private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    private static final long serialVersionUID = 1L;

    /**
     * 产品ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 产品ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 产品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 产品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 优先级
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 优先级
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 产品类别
     */
    public Long getCategory() {
        return category;
    }

    /**
     * 产品类别
     */
    public void setCategory(Long category) {
        this.category = category;
    }

    /**
     * 产品状态 (0 = 无效, 1 = 有效)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 产品状态 (0 = 无效, 1 = 有效)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 产品图片链接
     */
    public String getImgurl() {
        return imgurl;
    }

    /**
     * 产品图片链接
     */
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    /**
     * 产品描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 产品描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 产品价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 产品价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 产品数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 产品数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 已售数量
     */
    public Integer getSold() {
        return sold;
    }

    /**
     * 已售数量
     */
    public void setSold(Integer sold) {
        this.sold = sold;
    }

    /**
     * 折扣后

     */
    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    /**
     * 折扣后

     */
    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
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
    public Date getDiscountBegin() {
        return discountBegin;
    }

    /**
     * 
     */
    public void setDiscountBegin(Date discountBegin) {
        this.discountBegin = discountBegin;
    }

    /**
     * 
     */
    public Date getDiscountEnd() {
        return discountEnd;
    }

    /**
     * 
     */
    public void setDiscountEnd(Date discountEnd) {
        this.discountEnd = discountEnd;
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
        Product other = (Product) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPriority() == null ? other.getPriority() == null : this.getPriority().equals(other.getPriority()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getImgurl() == null ? other.getImgurl() == null : this.getImgurl().equals(other.getImgurl()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getSold() == null ? other.getSold() == null : this.getSold().equals(other.getSold()))
            && (this.getDiscountPrice() == null ? other.getDiscountPrice() == null : this.getDiscountPrice().equals(other.getDiscountPrice()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getDeletedAt() == null ? other.getDeletedAt() == null : this.getDeletedAt().equals(other.getDeletedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()))
            && (this.getDiscountBegin() == null ? other.getDiscountBegin() == null : this.getDiscountBegin().equals(other.getDiscountBegin()))
            && (this.getDiscountEnd() == null ? other.getDiscountEnd() == null : this.getDiscountEnd().equals(other.getDiscountEnd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPriority() == null) ? 0 : getPriority().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getImgurl() == null) ? 0 : getImgurl().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getSold() == null) ? 0 : getSold().hashCode());
        result = prime * result + ((getDiscountPrice() == null) ? 0 : getDiscountPrice().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getDeletedAt() == null) ? 0 : getDeletedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        result = prime * result + ((getDiscountBegin() == null) ? 0 : getDiscountBegin().hashCode());
        result = prime * result + ((getDiscountEnd() == null) ? 0 : getDiscountEnd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", priority=").append(priority);
        sb.append(", category=").append(category);
        sb.append(", status=").append(status);
        sb.append(", imgurl=").append(imgurl);
        sb.append(", description=").append(description);
        sb.append(", price=").append(price);
        sb.append(", num=").append(num);
        sb.append(", sold=").append(sold);
        sb.append(", discountPrice=").append(discountPrice);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", discountBegin=").append(discountBegin);
        sb.append(", discountEnd=").append(discountEnd);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}