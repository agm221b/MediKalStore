package com.example.MediKalStore.Model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditingEntityListener.class)
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
 
	@Column(name="delete_flag")
	private int deleteFlag;
	
	@CreatedBy
	protected String createdBy;
	
	@CreatedDate	
	@Temporal(TemporalType.TIMESTAMP)
	protected Date creationDate;
	
	@LastModifiedBy
	protected String lastModifiedBy;
	
	@LastModifiedDate
	protected String lastModifiedDate;
	
	
	
  public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public String getLastModifiedBy() {
		return lastModifiedBy;
	}


	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}


	public String getLastModifiedDate() {
		return lastModifiedDate;
	}


	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}


public OrderModel()
  {
	  
  }


public OrderModel(BigInteger orderId, float orderAmount, boolean orderStatus, LocalDate orderDate,
		CustomerModel customer, int deleteFlag) {
	super();
	this.orderId = orderId;
	this.orderAmount = orderAmount;
	this.orderStatus = orderStatus;
	this.orderDate = orderDate;
	this.customer = customer;
	this.deleteFlag = deleteFlag;
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


public LocalDate getOrderDate() {
	return orderDate;
}


public void setOrderDate(LocalDate orderDate) {
	this.orderDate = orderDate;
}


public CustomerModel getCustomer() {
	return customer;
}


public void setCustomer(CustomerModel customer) {
	this.customer = customer;
}


public int getDeleteFlag() {
	return deleteFlag;
}


public void setDeleteFlag(int deleteFlag) {
	this.deleteFlag = deleteFlag;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((customer == null) ? 0 : customer.hashCode());
	result = prime * result + deleteFlag;
	result = prime * result + Float.floatToIntBits(orderAmount);
	result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
	result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
	result = prime * result + (orderStatus ? 1231 : 1237);
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	OrderModel other = (OrderModel) obj;
	if (customer == null) {
		if (other.customer != null)
			return false;
	} else if (!customer.equals(other.customer))
		return false;
	if (deleteFlag != other.deleteFlag)
		return false;
	if (Float.floatToIntBits(orderAmount) != Float.floatToIntBits(other.orderAmount))
		return false;
	if (orderDate == null) {
		if (other.orderDate != null)
			return false;
	} else if (!orderDate.equals(other.orderDate))
		return false;
	if (orderId == null) {
		if (other.orderId != null)
			return false;
	} else if (!orderId.equals(other.orderId))
		return false;
	if (orderStatus != other.orderStatus)
		return false;
	return true;
}


@Override
public String toString() {
	return "OrderModel [orderId=" + orderId + ", orderAmount=" + orderAmount + ", orderStatus=" + orderStatus
			+ ", orderDate=" + orderDate + ", customer=" + customer + ", deleteFlag=" + deleteFlag + "]";
}

  
  
}
