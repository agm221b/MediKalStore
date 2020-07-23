package com.example.MediKalStore.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.MediKalStore.Model.CartModel;
import com.example.MediKalStore.Model.CustomerModel;
import com.example.MediKalStore.Model.OrderModel;
import com.example.MediKalStore.Model.ProductModel;
import com.example.MediKalStore.repository.AdminRepository;
import com.example.MediKalStore.repository.CartRepository;
import com.example.MediKalStore.repository.CustomerRepository;
import com.example.MediKalStore.repository.OrderRepository;
import com.example.MediKalStore.repository.ProductRepository;

public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public Integer addProductToCart(ProductModel productModel, BigInteger cartId,Integer quantity) {
		// TODO Auto-generated method stub
		CartModel cart = cartRepository.findByCartIdAndDeleteFlag(cartId, 0);				//create cart on creating User.
		cart.getListOfProducts().put(productModel,quantity); 										//calculate cart amount and refresh
		return 1;
	}

	@Override
	public Integer removeProductFromCart(ProductModel productModel, BigInteger cartId) {
		// TODO Auto-generated method stub
		CartModel cart = cartRepository.findByCartIdAndDeleteFlag(cartId, 0);				//create cart on creating User.
		cart.getListOfProducts().remove(productModel);										//calculate cart amount and refresh
		return 1;
	}

	@Override
	public List<ProductModel> searchProduct(String productName) {
		// TODO Auto-generated method stub													//search via name
		return productRepository.findByDeleteFlag(0);
	}

	@Override
	public List<ProductModel> viewAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findByDeleteFlag(0);
	}

	@Override
	public CartModel checkoutCart(CartModel cartModel) {
		// TODO Auto-generated method stub
																							//status variable 
		return null;
	}

	@Override
	public Set<OrderModel> viewHisOrders(BigInteger customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findByCustomerIdAndDeleteFlag(customerId, 0).getListOfOrders();					//find orderbycustomer
		
	}

	@Override
	public Integer cancelOrder(BigInteger orderId) {
		// TODO Auto-generated method stub													//change status variable
		return null;
	}

	@Override
	public CustomerModel editDetails(CustomerModel customerModel) {
		// TODO Auto-generated method stub
		return customerRepository.save(customerModel);												//diresctly					
	}

}
