package com.skudemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skudemo.model.SKUMaster;

@Repository
public interface SKUMasterRepository extends JpaRepository<SKUMaster, Long>{

	@Query(value = "SELECT * FROM skumaster   ", nativeQuery = true)
	public List<SKUMaster> findBySkus();
}
