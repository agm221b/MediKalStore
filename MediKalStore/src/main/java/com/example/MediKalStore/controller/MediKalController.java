package com.example.MediKalStore.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.MediKalStore.Model.OrderModel;
import com.example.MediKalStore.Model.ProductModel;
import com.example.MediKalStore.service.AdminServiceImpl;
import com.example.MediKalStore.service.CustomerServiceImpl;

@RestController
public class MediKalController {
	
	@Autowired
	private AdminServiceImpl adminService;
	
	@Autowired
	private CustomerServiceImpl customerService;
	
	@PostMapping("/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody ProductModel product)
	{
		ProductModel newProduct = adminService.createProduct(product);
		if(newProduct == null)
		{
			return new ResponseEntity<String>("Product not added",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else
		{
			return new ResponseEntity<ProductModel>(newProduct,HttpStatus.OK);
		}
    }
	
	@PostMapping("/addProductQuantity")
	public ResponseEntity<?> addProductQuantity(@RequestBody ProductModel product)
	{
		ProductModel updatedProduct = adminService.addProductQuantity(product);
		if(updatedProduct == null)
		{
			return new ResponseEntity<String>("Quantity not updated",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else
		{
			return new ResponseEntity<ProductModel>(updatedProduct,HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/removeProductQuantity")
	public ResponseEntity<?> removeProductQuantity(@RequestBody ProductModel product)
	{
		ProductModel updatedProduct = adminService.removeProductQuantity(product);
		if(updatedProduct == null)
		{
			return new ResponseEntity<String>("Quantity not removed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else
		{
			return new ResponseEntity<ProductModel>(updatedProduct,HttpStatus.OK);
		}
	}
	
	@PostMapping("/editProduct")
	public ResponseEntity<?> editProduct(@RequestBody ProductModel product)
	{
		ProductModel editedProduct = adminService.editProduct(product);
		if(editedProduct == null)
		{
			return new ResponseEntity<String>("Quantity not edited",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else
		{
			return new ResponseEntity<ProductModel>(editedProduct,HttpStatus.OK);
		}
	}
	
	@GetMapping("/viewAllProducts")
	public ResponseEntity<?> viewAllProducts()
	{
		List<ProductModel> listOfProducts = adminService.viewAllProducts();
		if(listOfProducts!=null)
		{
			return new ResponseEntity<List>(listOfProducts,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No item found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/viewAllOrders")
	public ResponseEntity<?> viewAllOrders()
	{
		List<OrderModel> listOfOrders = adminService.viewAllOrders();
		if(listOfOrders!=null)
		{
			return new ResponseEntity<List>(listOfOrders,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No order found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deleteProduct")
	public ResponseEntity<?> deleteProduct(@RequestParam("productId") BigInteger productId )
	{
		boolean isDeleted = adminService.deleteProduct(productId);
		if(isDeleted == true)
		{
			return new ResponseEntity<String>("Product deleted successfully",HttpStatus.OK);
		}
		else if(isDeleted == false)
		{
			return new ResponseEntity<String>("Product not deleted",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	

}
