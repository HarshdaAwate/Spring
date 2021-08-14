package com.met.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.met.model.Product;

//@Component
@Repository
public class ProductDAO {

	private Map<Integer, Product> mapProducts = new HashMap<>();
	
	@Autowired
	@Qualifier("myOracledataSource")
	private DataSource dataSource;


	/*@Autowired
	@Qualifier("mySQLDataSource")
	private DataSource dataSource1;*/

	public void saveUsingJDBC(){
		
		//Creating connection
		//creatin pstmt
		//insert into db values()
		
	}
	
	
	public void saveUsingDataSource(Product product){
		
		try(Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into Product values(?,?,?)")
				){
			
			
			pstmt.setInt(1, product.getProductNo());
			pstmt.setDouble(2, product.getPrice());
			pstmt.setInt(3, product.getStock());
	
			
			
			pstmt.executeUpdate();
			con.commit();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void saveProduct(Product product){
		
		System.out.println("ProductDAO :: saveProduct: " + product);
		//mapEmployees.put(employee.getId(), employee);
		
		saveUsingDataSource(product);
		
		//save it into db
		

		
		
	}
	
	
	public Collection<Product> getAllProducts(){
		
		return mapProducts.values();
		
	}
	
}




