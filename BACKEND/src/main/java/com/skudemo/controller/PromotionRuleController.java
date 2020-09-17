package com.skudemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skudemo.model.CartMaster;
import com.skudemo.model.SKUMaster;
import com.skudemo.repository.SKUMasterRepository;
import com.skudemo.service.PromotionRuleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class PromotionRuleController {

	
	@Autowired
	private PromotionRuleService promotionRuleService;
	@Autowired
	private SKUMasterRepository skuRepository;
	@PostMapping("/addpromotions")
	public Double createEmployee(@Valid @RequestBody CartMaster cartMaster) {
		return promotionRuleService.calculatePromotion(cartMaster);
	}
	
	@GetMapping("/skus")
	public List<SKUMaster> getAllEmployees() {
		return skuRepository.findBySkus();
	}
	
	}
