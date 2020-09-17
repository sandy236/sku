package com.skudemo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class CartMaster {
	
	@Id
	@GeneratedValue
	private Long cartId;
	private Date updatedDate;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "CartSkuMap", 
        joinColumns = { @JoinColumn(name = "cart_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "sku_id") }
    )
	private Set<SKUMaster> skus;
	
	private Double totalPrice;
	
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public Set<SKUMaster> getSkus() {
		return skus;
	}
	public void setSkus(Set<SKUMaster> skus) {
		this.skus = skus;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	

}
