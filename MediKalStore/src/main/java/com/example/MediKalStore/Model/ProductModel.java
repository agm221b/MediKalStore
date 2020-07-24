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
@Table(name="Product_Table")
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="product_id")
	private BigInteger productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_description")
	private String productDescription;
	
	@Column(name="product_qty")
	private Integer productQuantity;
	
	@Column(name="product_price")
	private Double productPrice;
	
	@Column(name="product_exp_date")
	private LocalDate productExpDate;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    private CartModel cart;
	
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

	
	public ProductModel()
	{
		
	}


	public ProductModel(BigInteger productId, String productName, String productDescription, Integer productQuantity,
			Double productPrice, LocalDate productExpDate, CartModel cart, int deleteFlag) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productExpDate = productExpDate;
		this.cart = cart;
		this.deleteFlag = deleteFlag;
	}


	public BigInteger getProductId() {
		return productId;
	}


	public void setProductId(BigInteger productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductDescription() {
		return productDescription;
	}


	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}


	public Integer getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}


	public Double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}


	public LocalDate getProductExpDate() {
		return productExpDate;
	}


	public void setProductExpDate(LocalDate productExpDate) {
		this.productExpDate = productExpDate;
	}


	public CartModel getCart() {
		return cart;
	}


	public void setCart(CartModel cart) {
		this.cart = cart;
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
		result = prime * result + ((cart == null) ? 0 : cart.hashCode());
		result = prime * result + deleteFlag;
		result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
		result = prime * result + ((productExpDate == null) ? 0 : productExpDate.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + ((productPrice == null) ? 0 : productPrice.hashCode());
		result = prime * result + ((productQuantity == null) ? 0 : productQuantity.hashCode());
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
		ProductModel other = (ProductModel) obj;
		if (cart == null) {
			if (other.cart != null)
				return false;
		} else if (!cart.equals(other.cart))
			return false;
		if (deleteFlag != other.deleteFlag)
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (productExpDate == null) {
			if (other.productExpDate != null)
				return false;
		} else if (!productExpDate.equals(other.productExpDate))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (productPrice == null) {
			if (other.productPrice != null)
				return false;
		} else if (!productPrice.equals(other.productPrice))
			return false;
		if (productQuantity == null) {
			if (other.productQuantity != null)
				return false;
		} else if (!productQuantity.equals(other.productQuantity))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ProductModel [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productQuantity=" + productQuantity + ", productPrice=" + productPrice
				+ ", productExpDate=" + productExpDate + ", cart=" + cart + ", deleteFlag=" + deleteFlag + "]";
	}


	
	
	
}
