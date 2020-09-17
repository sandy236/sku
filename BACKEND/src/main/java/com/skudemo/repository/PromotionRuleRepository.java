package com.skudemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skudemo.model.PromotionRule;
import com.skudemo.model.SKUMaster;


@Repository
public interface PromotionRuleRepository extends JpaRepository<PromotionRule, Long>{
	@Query("SELECT u FROM PromotionRule u WHERE u.skuMaster = ?1 and u.isActive = ?2 and u.isDeleted=?3 and u.isComboId =?4")
	public List<PromotionRule> findBySkuMaster(SKUMaster skuId,Boolean isActive, Boolean idDeleted, Integer isComboId);
	
	

}
