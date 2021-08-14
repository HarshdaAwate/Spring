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

import com.met.model.Employee;

//@Component
@Repository
public class EmployeeDAO {

	private Map<Integer, Employee> mapEmployees = new HashMap<>();
	
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
	
	
	public void saveUsingDataSource(Employee employee){
		
		try(Connection con = dataSource.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into EmployeeTbl values(?,?,?,?)")
				){
			
			
			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getDesignation());
			pstmt.setString(4, employee.getEmailId());
			
			
			pstmt.executeUpdate();
			con.commit();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void saveEmployee(Employee employee){
		
		System.out.println("EmployeeDAO :: saveEmployee: " + employee);
		//mapEmployees.put(employee.getId(), employee);
		
		saveUsingDataSource(employee);
		
		//save it into db
		

		
		
	}
	
	
	public Collection<Employee> getAllEmployees(){
		
		return mapEmployees.values();
		
	}
	
}




