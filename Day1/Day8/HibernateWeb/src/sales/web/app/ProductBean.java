package sales.web.app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.met.hibernate.util.HibernateUtil;
import com.met.sales.model.ProductEntry;

public class ProductBean implements java.io.Serializable{

	////private static Sessionfactory sf = new COnfiguration().configure().buildSessionfactory();
	
	public List<ProductEntry> getEntries(){
		List<ProductEntry> entries = new ArrayList<>();
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			/*
			Context naming = new InitialContext();
			DataSource ds = (DataSource)naming.lookup("jdbc/SalesDB");
			try(Connection con = ds.getConnection()){
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select pno, price, stock from products");
				while(rs.next())
					entries.add(new ProductEntry(rs));
				rs.close();
				stmt.close();
			}
			*/
			
			Query<ProductEntry> createQuery = session.createQuery("from com.met.sales.model.ProductEntry", ProductEntry.class);
			entries = createQuery.list();
			
			
			
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return entries;
	}

	
}


