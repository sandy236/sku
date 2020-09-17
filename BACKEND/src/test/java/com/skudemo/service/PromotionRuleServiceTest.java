package com.skudemo.service;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.skudemo.model.CartMaster;
import com.skudemo.model.PromotionRule;
import com.skudemo.model.SKUMaster;
import com.skudemo.repository.PromotionRuleRepository;

@RunWith(SpringRunner.class)
public class PromotionRuleServiceTest {
	@InjectMocks
	private PromotionRuleService promotionSerice;
	@Mock
	private PromotionRuleRepository promotionRepo;
	@Test
	public void testcalculatePromotion() {
		PromotionRule rule = new PromotionRule();
		rule.setIsComboId(0);
		rule.setPrice(10.0);
		rule.setPromotionRule("2");
		List<PromotionRule> ruleList = new ArrayList<>();
		ruleList.add(rule);
		
		
		Mockito.when(promotionRepo.findBySkuMaster(Mockito.any(), Mockito.anyBoolean(), Mockito.anyBoolean(), Mockito.anyInt())).thenReturn(ruleList
				);
		
		CartMaster cart = new CartMaster();
		SKUMaster sku = new SKUMaster();
		sku.setPrice(10.00);
		sku.setQuantity(1);
		sku.setSkuId(1L);
		Set<SKUMaster> skuList = new HashSet();
		skuList.add(sku);
		cart.setSkus(skuList);
		
		
		
		double d =promotionSerice.calculatePromotion(cart);
		System.out.println(d);
		assertNotEquals(d, 100);
		
	}
	
	
	@Test
	public void testcalculatePromotion2() {
		PromotionRule rule = new PromotionRule();
		rule.setIsComboId(1);
		rule.setPrice(10.0);
		rule.setPromotionRule("3");
		List<PromotionRule> ruleList = new ArrayList<>();
		ruleList.add(rule);
		
		
		Mockito.when(promotionRepo.findBySkuMaster(Mockito.any(), Mockito.anyBoolean(), Mockito.anyBoolean(), Mockito.anyInt())).thenReturn(ruleList
				);
		
		CartMaster cart = new CartMaster();
		SKUMaster sku = new SKUMaster();
		sku.setPrice(10.00);
		sku.setQuantity(1);
		sku.setSkuId(1L);
		Set<SKUMaster> skuList = new HashSet();
		skuList.add(sku);
		cart.setSkus(skuList);
		
		
		
		double d =promotionSerice.calculatePromotion(cart);
		System.out.println(d);
		assertNotEquals(d, 100);
		
	}
}
