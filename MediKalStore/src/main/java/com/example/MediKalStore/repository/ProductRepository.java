package com.example.MediKalStore.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MediKalStore.Model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, BigInteger> {
	
	List<ProductModel> findByDeleteFlag(int deleteFlag);
	
	ProductModel findByProductIdAndDeleteFlag(BigInteger productId, int deleteFlag);

}
