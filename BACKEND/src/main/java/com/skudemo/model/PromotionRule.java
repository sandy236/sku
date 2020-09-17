package com.skudemo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class PromotionRule {
	@Id
	@GeneratedValue
	private Long ruleId;
	private Integer isComboId;
	private String promotionName;
	private Boolean isActive;
	private Date updatedDate;
	private Date createdDate;
	private Boolean isDeleted;
	private String promotionRule;

    @ManyToOne
    @JoinColumn(name = "sku_id")
	private SKUMaster skuMaster;
	private Double price;
	public Long getRuleId() {
		return ruleId;
	}
	public void setRuleId(Long ruleId) {
		this.ruleId = ruleId;
	}
	
	
	public Integer getIsComboId() {
		return isComboId;
	}
	public void setIsComboId(Integer isComboId) {
		this.isComboId = isComboId;
	}
	public String getPromotionRule() {
		return promotionRule;
	}
	public void setPromotionRule(String promotionRule) {
		this.promotionRule = promotionRule;
	}
	
	
	public SKUMaster getSkuMaster() {
		return skuMaster;
	}
	public void setSkuMaster(SKUMaster skuMaster) {
		this.skuMaster = skuMaster;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	

}
