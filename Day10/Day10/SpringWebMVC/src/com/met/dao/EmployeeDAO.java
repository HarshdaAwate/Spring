package com.met.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	//@Qualifier("sessionFactoryBean")
	private SessionFactory sessionFactory;

	public void saveUsingJDBC(){
		
		//Creating connection
		//creatin pstmt
		//insert into db values()
		
	}
	
	public void saveUsingHibernate(Employee employee){
		
		System.out.println("Save Employee using Hibernate");
		
		Session session = null;
		Transaction tx = null;
		
		try{
			
			session = sessionFactory.openSession();			//@Before
			tx  = session.beginTransaction();				//@Before
				
			session.save(employee);							//BusinessLogic
			
			tx.commit();									//@AfterReturning
			
		}catch(HibernateException ex){					
			ex.printStackTrace();							//@AfterThrowing
			if(tx != null) tx.rollback();
		}finally {											//@After		
			if(session != null) session.close();
		}
		
		
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
	
	public void saveUsingJDBCTemplate(Employee employee){
		
		System.out.println("Saving Employee using JDBCTemplate.....");
		
		jdbcTemplate.update("insert into EmployeeTbl values(?,?,?,?)", 
				new Object[]{employee.getId(), employee.getName(),
						employee.getDesignation(), employee.getEmailId()});
		
		
		
	}
	
	
	//@Transactional(transactionManager="hibernateTransactionManager")
	//@Transactional(rollbackFor=Exception.class, noRollbackFor=NullPointerException.class)
	@Transactional(rollbackFor=Exception.class)
	public void saveEmployee(Employee employee){
		
		System.out.println("EmployeeDAO :: saveEmployee: " + employee);
		//mapEmployees.put(employee.getId(), employee);
		
		//saveUsingDataSource(employee);
		
		//saveUsingJDBCTemplate(employee);
		
		//saveUsingHibernate(employee);
		
		
		
		Session session = sessionFactory.getCurrentSession();//1000
		session.save(employee);	
		
		
		//save it into db
		updateEmployeeCOunt();
	}
	
	public void updateEmployeeCOunt(){
		
		Session session = sessionFactory.getCurrentSession();
		session.createSQLQuery("update employeecount set count=count+1").executeUpdate();
		
	}
	
	public Collection<Employee> getAllEmployees(){
		
		//COnnection, pstmt
		//ResultSet
		
		//List<EMployee> listEMployee = new ArrayList<>();
		
		//iterate throught resultset
		
		
		
		//Employee emp = new Employee();
		//emp.setId(rs.get(1));
		//emp.setString(rs.get(2));
		//emp.setDesignation(rs.get(3));
		
		//listEMployee.add(emp);
		
		
		/*class BeanPropertyRowMapper implements RowMapper{
			
			
		}*/
		
		return jdbcTemplate.query("select * from employeetbl", 
				new BeanPropertyRowMapper<Employee>(Employee.class));
		
		//return mapEmployees.values();
		
	}
	
}

/*
class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		
		Employee emp = new Employee();
		emp.setId(rs.getInt(1));
		emp.setName(rs.getString(2));
		emp.setDesignation(rs.getString(3));
		emp.setEmailId(rs.getString(4));
		
		return emp;
	}
}*/


