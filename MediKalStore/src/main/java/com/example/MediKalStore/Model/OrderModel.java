package com.example.MediKalStore.Model;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Order_Table")
public class OrderModel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_id")
	private BigInteger orderId;
	
	@Column(name="order_amount")
	private float orderAmount;
	
	@Column(name="order_status")
	private boolean orderStatus;
	
	@Column(name="order_date")
	private LocalDate orderDate;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id_fk")
	private CustomerModel customer;
 
	
	
  public OrderModel()
  {
	  
  }
public OrderModel(BigInteger orderId, float orderAmount, boolean orderStatus, CustomerModel customer,
		LocalDate orderDate) {
	super();
	this.orderId = orderId;
	this.orderAmount = orderAmount;
	this.orderStatus = orderStatus;
	this.customer = customer;
	this.orderDate = orderDate;
}
public BigInteger getOrderId() {
	return orderId;
}
public void setOrderId(BigInteger orderId) {
	this.orderId = orderId;
}
public float getOrderAmount() {
	return orderAmount;
}
public void setOrderAmount(float orderAmount) {
	this.orderAmount = orderAmount;
}
public boolean isOrderStatus() {
	return orderStatus;
}
public void setOrderStatus(boolean orderStatus) {
	this.orderStatus = orderStatus;
}
public CustomerModel getCustomer() {
	return customer;
}
public void setCustomer(CustomerModel customer) {
	this.customer = customer;
}
public LocalDate getOrderDate() {
	return orderDate;
}
public void setOrderDate(LocalDate orderDate) {
	this.orderDate = orderDate;
}
  
}
