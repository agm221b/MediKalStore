package com.example.MediKalStore.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import com.example.MediKalStore.Model.CartModel;
import com.example.MediKalStore.Model.CustomerModel;
import com.example.MediKalStore.Model.OrderModel;
import com.example.MediKalStore.Model.ProductModel;

public interface CustomerService {
	

	Integer addProductToCart(ProductModel productModel, BigInteger customerId,Integer quantity);
	Integer removeProductFromCart(ProductModel productModel, BigInteger customerId); 
	List<ProductModel> searchProduct(String productName);
	List<ProductModel> viewAllProduct();
	CartModel checkoutCart(CartModel cartModel);
	//integrate payment via 3rd party
	
	Set<OrderModel> viewHisOrders(BigInteger customerId);
	
	Integer cancelOrder(BigInteger orderId);
	
	CustomerModel editDetails(CustomerModel customerModel);
	//add address aggregation later on, change address option
	
	Integer refreshAmount(BigInteger cartId);
	
	
	
	

}
