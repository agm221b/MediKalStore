package com.example.MediKalStore.Model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name="Cart_Table")
public class CartModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cart_id")
	private BigInteger cartId;
	
	@Column(name="cart_amount")
	private Double cartAmount;
	
	@Column(name="cart_address")
	private String cartAddress;
	
	@Column(name="cart_payment_mode")
	private String cartPaymentMode;
	
	@OneToOne(mappedBy = "cart", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private CustomerModel customer;
	
//	
//	@ElementCollection
//	@OneToMany(mappedBy="cart")
//    private Map<ProductModel,Integer> listOfProducts;
	
	@ElementCollection
	@MapKeyColumn(name = "product_type")
	@MapKeyEnumerated(EnumType.STRING)
	private Map<ProductModel, Integer>listOfProducts = new HashMap<ProductModel, Integer>();

	
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
	
	public CartModel()
	{
		
	}

	public CartModel(BigInteger cartId, Double cartAmount, String cartAddress, String cartPaymentMode,
			CustomerModel customer, Map<ProductModel, Integer> listOfProducts, int deleteFlag) {
		super();
		this.cartId = cartId;
		this.cartAmount = cartAmount;
		this.cartAddress = cartAddress;
		this.cartPaymentMode = cartPaymentMode;
		this.customer = customer;
		this.listOfProducts = listOfProducts;
		this.deleteFlag = deleteFlag;
	}

	public BigInteger getCartId() {
		return cartId;
	}

	public void setCartId(BigInteger cartId) {
		this.cartId = cartId;
	}

	public Double getCartAmount() {
		return cartAmount;
	}

	public void setCartAmount(Double cartAmount) {
		this.cartAmount = cartAmount;
	}

	public String getCartAddress() {
		return cartAddress;
	}

	public void setCartAddress(String cartAddress) {
		this.cartAddress = cartAddress;
	}

	public String getCartPaymentMode() {
		return cartPaymentMode;
	}

	public void setCartPaymentMode(String cartPaymentMode) {
		this.cartPaymentMode = cartPaymentMode;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}

	public Map<ProductModel, Integer> getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(Map<ProductModel, Integer> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cartAddress == null) ? 0 : cartAddress.hashCode());
		result = prime * result + ((cartAmount == null) ? 0 : cartAmount.hashCode());
		result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
		result = prime * result + ((cartPaymentMode == null) ? 0 : cartPaymentMode.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + deleteFlag;
		result = prime * result + ((listOfProducts == null) ? 0 : listOfProducts.hashCode());
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
		CartModel other = (CartModel) obj;
		if (cartAddress == null) {
			if (other.cartAddress != null)
				return false;
		} else if (!cartAddress.equals(other.cartAddress))
			return false;
		if (cartAmount == null) {
			if (other.cartAmount != null)
				return false;
		} else if (!cartAmount.equals(other.cartAmount))
			return false;
		if (cartId == null) {
			if (other.cartId != null)
				return false;
		} else if (!cartId.equals(other.cartId))
			return false;
		if (cartPaymentMode == null) {
			if (other.cartPaymentMode != null)
				return false;
		} else if (!cartPaymentMode.equals(other.cartPaymentMode))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (deleteFlag != other.deleteFlag)
			return false;
		if (listOfProducts == null) {
			if (other.listOfProducts != null)
				return false;
		} else if (!listOfProducts.equals(other.listOfProducts))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartModel [cartId=" + cartId + ", cartAmount=" + cartAmount + ", cartAddress=" + cartAddress
				+ ", cartPaymentMode=" + cartPaymentMode + ", customer=" + customer + ", listOfProducts="
				+ listOfProducts + ", deleteFlag=" + deleteFlag + "]";
	}

	

}
