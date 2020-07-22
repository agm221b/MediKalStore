package com.example.MediKalStore.Model;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Customer_Table")
public class CustomerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_id")
	private BigInteger customerId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_password")
	private String customerPassword;
	
	@Column(name="role")
	private String role;
	
	@Column(name="customer_email")
	private String customerEmail;
	
	@Column(name="customer_phone")
	private String customerPhone;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private CartModel cart;
	 
	 @OneToMany(mappedBy="customer", fetch = FetchType.LAZY)
	 private Set<OrderModel> listOfOrders=new HashSet<OrderModel>();
	
	public CustomerModel()
	{
		
	}

	public CustomerModel(BigInteger customerId, String customerName, String customerPassword, String role,
			String customerEmail, String customerPhone, CartModel cart, Set<OrderModel> listOfOrders) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.role = role;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.cart = cart;
		this.listOfOrders = listOfOrders;
	}

	public BigInteger getCustomerId() {
		return customerId;
	}

	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public CartModel getCart() {
		return cart;
	}

	public void setCart(CartModel cart) {
		this.cart = cart;
	}

	public Set<OrderModel> getListOfOrders() {
		return listOfOrders;
	}

	public void setListOfOrders(Set<OrderModel> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}

	

	
	

	
	
	
}
