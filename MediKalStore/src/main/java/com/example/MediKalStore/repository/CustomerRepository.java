package com.example.MediKalStore.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MediKalStore.Model.CustomerModel;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, BigInteger> {
	
	List<CustomerModel> findByDeleteFlag(int deleteFlag);
	CustomerModel findByCustomerIdAndDeleteFlag(BigInteger customerId, int deleteFlag);

}
