package sales.web.app;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.met.hibernate.util.HibernateUtil;
import com.met.sales.model.Counter;
import com.met.sales.model.Customer;
import com.met.sales.model.InvoiceEntry;
import com.met.sales.model.Order;

public class CustomerBean implements java.io.Serializable{

	private String id;

	public final String getId(){return id;}

	//private static Sessionfactory sf = new COnfiguration().configure().buildSessionfactory();
	
	
	public void saveCustomer(){
		
		
	}
	
	
	@SuppressWarnings("deprecation")
	public boolean authenticate(String customerId, String password){
		/*try{
			Context naming = new InitialContext();
			DataSource ds = (DataSource)naming.lookup("jdbc/SalesDB");
			try(Connection con = ds.getConnection()){
				PreparedStatement pstmt = con.prepareStatement("select count(cust_id) from customers where cust_id=? and pwd=?");
				pstmt.setString(1, customerId);
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				int count = rs.getInt(1);
				rs.close();
				pstmt.close();
				if(count == 1){
					id = customerId;
					return true;
				}
				id = null;
				return false;
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}*/
		
		//select count(cust_id) from customers where cust_id=? and pwd=?
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			Criteria createCriteria = session.createCriteria(Customer.class);
			createCriteria.add(Restrictions.eq("userId", customerId));
			createCriteria.add(Restrictions.eq("pwd", password));
			Customer uniqueResult = (Customer) createCriteria.uniqueResult();
			
			if(uniqueResult != null){
				id = customerId;
				return true;
			}else{
				return false;
			}
			
		}
		
		
	}

	public int order(int productNo, int quantity){
		/*try{
			Context naming = new InitialContext();
			DataSource ds = (DataSource)naming.lookup("jdbc/SalesDB");
			try(Connection con = ds.getConnection()){
				CallableStatement cstmt = con.prepareCall("{call place_order(?, ?, ?, ?)}");
				cstmt.setString(1, id);
				cstmt.setInt(2, productNo);
				cstmt.setInt(3, quantity);
				cstmt.registerOutParameter(4, Types.INTEGER);
				cstmt.executeUpdate();
				int orderNo = cstmt.getInt(4);
				cstmt.close();
				return orderNo;
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}*/
		
		int orderNo = 0;
		
		Transaction tx = null;
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			tx = session.beginTransaction();
			
			Counter counter = session.get(Counter.class, "orders");
			int value = counter.getCounterValue();			//11
			
			orderNo = ++value + 1000;    //++11 + 1000=  // 12 + 1000 = 1012
			
			//update countervalue to 11
			
			counter.setCounterValue(value);		//12
			
			// insert order entry
			
			
			Order order = new Order();
			order.setOrderNo(orderNo);
			order.setOrderDate(new Date(System.currentTimeMillis()));
			order.setPno(productNo);
			order.setQty(quantity);
			order.setCustId(id);
			
			
			session.save(order);
			//session.update(counter);
			
			tx.commit(); // session.flush() + commit
			
		}catch (Exception e) {
			if(tx != null) tx.rollback();
			throw new RuntimeException(e);
		}
		
		
		return orderNo;
	}

	@SuppressWarnings("deprecation")
	public List<InvoiceEntry> getInvoice(){
		List<InvoiceEntry> invoice = new ArrayList<>();
		/*try{
			Context naming = new InitialContext();
			DataSource ds = (DataSource)naming.lookup("jdbc/SalesDB");
			try(Connection con = ds.getConnection()){
				PreparedStatement pstmt = con.prepareStatement
				("select ord_date, pno, qty, amt from invoices where cust_id=?");
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
					invoice.add(new InvoiceEntry(rs));
				rs.close();
				pstmt.close();
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}*/
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			
			Criteria createCriteria = session.createCriteria(com.met.sales.model.InvoiceEntry.class);
			createCriteria.add(Restrictions.eq("custId", id));
			invoice = createCriteria.list();
			
		}
		
		return invoice;
	}

	
}


