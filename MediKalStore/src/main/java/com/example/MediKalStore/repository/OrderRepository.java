package com.example.MediKalStore.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MediKalStore.Model.OrderModel;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, BigInteger> {

}
