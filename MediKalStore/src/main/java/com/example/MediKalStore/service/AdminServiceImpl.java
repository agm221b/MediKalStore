package com.example.MediKalStore.service;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MediKalStore.Model.CustomerModel;
import com.example.MediKalStore.Model.OrderModel;
import com.example.MediKalStore.Model.ProductModel;
import com.example.MediKalStore.repository.AdminRepository;
import com.example.MediKalStore.repository.CartRepository;
import com.example.MediKalStore.repository.CustomerRepository;
import com.example.MediKalStore.repository.OrderRepository;
import com.example.MediKalStore.repository.ProductRepository;


/**
 * @author Aditya
 * 
 * Class that performs service level operations of Admin
 *
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	
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
	

	/**
	 * @param ProductModel productModel
	 * @return ProductModel
	 * Takes in product model to be created and adds it to the database
	 */
	@Override
	public ProductModel createProduct(ProductModel productModel) {
		// TODO Auto-generated method stub
		productRepository.save(productModel);
		return productModel;
	}

	/**
	 *	@param ProductModel productModel
	 *	@return productModel
	 *	
	 *	updates product qty from incoming product model
	 */
	@Override
	public ProductModel addProductQuantity(ProductModel productModel) {
		// TODO Auto-generated method stub
		productRepository.save(productModel);									//persisting directly instead of find and update
		return productModel;
	}

	@Override
	public ProductModel removeProductQuantity(ProductModel productModel) {
		// TODO Auto-generated method stub
		productRepository.save(productModel);									//persisting directly instead of find and update
		return productModel;
	}

	@Override
	public ProductModel editProduct(ProductModel productModel) {
		// TODO Auto-generated method stub
		productRepository.save(productModel);									//persisting directly instead of find and update
		return productModel;
	}

	@Override
	public List<ProductModel> viewAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findByDeleteFlag(0);
	}

	@Override
	public List<OrderModel> viewAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findByDeleteFlag(0);
	}
	
	

	@Override
	public Integer deleteProductFromDatabase(BigInteger productId) {
		// TODO Auto-generated method stub
		productRepository.findByProductIdAndDeleteFlag(productId, 0).setDeleteFlag(1);
		return 1;
	}

	@Override
	public Integer deleteOrderFromDatabase(BigInteger orderId) {
		// TODO Auto-generated method stub
		orderRepository.findByOrderIdAndDeleteFlag(orderId, 0).setDeleteFlag(1);
		return 1;
	}

	@Override
	public Integer deleteCustomerFromDatabase(BigInteger customerId) {
		// TODO Auto-generated method stub
		CustomerModel cust =customerRepository.findByCustomerIdAndDeleteFlag(customerId, 0);
		cust.getCart().setDeleteFlag(1);
		cust.setDeleteFlag(1);
		return 1;
	}
	
	
	
	

	
	
}
