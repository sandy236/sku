package com.skudemo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skudemo.model.CartMaster;
import com.skudemo.model.PromotionRule;
import com.skudemo.model.SKUMaster;
import com.skudemo.repository.PromotionRuleRepository;

@Service
public class PromotionRuleService {
	
	@Autowired
	private PromotionRuleRepository promotionRuleRepository;
	
	
	public Double calculatePromotion(CartMaster cartDetails) {
		Double totalAmount=0.0;
		Set <Integer> appliedCombo= new HashSet<>();
		for (SKUMaster sku : cartDetails.getSkus()) {
			System.out.println("0--------------- "+sku.getSkuId());
			List<PromotionRule> promoList =promotionRuleRepository.findBySkuMaster(sku,true,false,0);
			//non combo
			totalAmount = calculateForNoneCombo(totalAmount, sku, promoList);
			// combo
			
			List<PromotionRule> promoListForCombo =promotionRuleRepository.findBySkuMaster(sku,true,false,1);
			double totalComboPrice =0;
			for (PromotionRule promotionRule : promoListForCombo) {
				SKUMaster comboSku=null;
				for (SKUMaster sku2 : cartDetails.getSkus()) {
					if(sku2.getSkuId().toString().equals(promotionRule.getPromotionRule()) && !appliedCombo.contains(promotionRule.getIsComboId())) {
						comboSku =sku2;
						appliedCombo.add(promotionRule.getIsComboId());
						break;
					}
					
				}
				if(comboSku!=null) {
					
					if(comboSku.getQuantity().intValue()>sku.getQuantity().intValue()) {
					int remainingQty = 	comboSku.getQuantity().intValue()-sku.getQuantity().intValue();
					totalComboPrice= remainingQty*comboSku.getPrice().intValue();
					totalComboPrice =promotionRule.getPrice() * sku.getQuantity().intValue() +totalComboPrice;
					totalAmount += totalComboPrice;
					}
					else if(sku.getQuantity().intValue()>comboSku.getQuantity().intValue()) {
						int remainingQty = 	sku.getQuantity().intValue()-comboSku.getQuantity().intValue();
						totalComboPrice= remainingQty*sku.getPrice().intValue();
						totalComboPrice =promotionRule.getPrice() * comboSku.getQuantity().intValue() +totalComboPrice;
						totalAmount += totalComboPrice;
					}
					else {
						
						totalComboPrice =promotionRule.getPrice() * comboSku.getQuantity().intValue() +totalComboPrice;
						totalAmount += totalComboPrice;
					}
				}else {
					if(!appliedCombo.contains(promotionRule.getIsComboId())) {
						totalAmount += sku.getPrice()*sku.getQuantity();	
					}
					
				}
			}
		}
		
		return totalAmount;
	}


	private Double calculateForNoneCombo(Double totalAmount, SKUMaster sku, List<PromotionRule> promoList) {
		for (PromotionRule promotionRule : promoList) {
			int promoAppliedQty= sku.getQuantity()/Integer.parseInt(promotionRule.getPromotionRule());
			double promoAmount= promoAppliedQty* promotionRule.getPrice();
			int remainingQuantity = sku.getQuantity()%Integer.parseInt(promotionRule.getPromotionRule());;
			double remainingkuAmt = remainingQuantity*sku.getPrice();
			totalAmount += promoAmount +remainingkuAmt;
		}
		return totalAmount;
	}

}
