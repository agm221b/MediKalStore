package com.example.MediKalStore.service;

import java.math.BigInteger;
import java.util.List;

import com.example.MediKalStore.Model.OrderModel;
import com.example.MediKalStore.Model.ProductModel;

public interface AdminService {
	
	ProductModel createProduct(ProductModel productModel);
	ProductModel addProductQuantity(ProductModel productModel);
	ProductModel removeProductQuantity(ProductModel productModel);
	ProductModel editProduct(ProductModel productModel);
	Integer deleteProductFromDatabase(BigInteger productId);
	

	List<ProductModel> viewAllProducts();
	List<OrderModel> viewAllOrders();

	
	Integer deleteOrderFromDatabase(BigInteger orderId);
	
	Integer deleteCustomerFromDatabase(BigInteger customerId);
	


}
