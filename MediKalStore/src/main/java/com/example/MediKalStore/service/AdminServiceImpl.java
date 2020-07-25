package com.example.MediKalStore.service;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Boolean deleteProduct(BigInteger productId) {
		// TODO Auto-generated method stub
		ProductModel product = productRepository.findById(productId).get();
		product.setDeleteFlag(1);
		if(product.getDeleteFlag()==1)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
