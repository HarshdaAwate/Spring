package com.met.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.met.dao.ProductDAO;
import com.met.model.Product;

//@Component
@Service
public class ProductService {

	//private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	@Autowired
	private ProductDAO productDAO;
	
//	public void saveProduct(Product product){
//		
//		//perform some validation on Employee object.
//		
////		String emailId = product.getEmailId();
////		
//		if(!emailId.contains(".") || !emailId.contains("@")){
//			
//			throw new RuntimeException("EmailId : " + emailId + " is invalid");
//			
//		}
		
//		
//		System.out.println("EmployeeService :: saveEmployee");
//		employeeDAO.saveEmployee(employee);
//		
//	}
//	
	public Collection<Product> getAllProduct(){
	
		return productDAO.getAllProduct();
		
	}
	
}



