package project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import project.Connection.ConnectionProvider;
import project.Model.Order;
import project.Model.product;

@SuppressWarnings("unused")
public class OrderDao {

	private Connection con ;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public OrderDao(Connection con) {
		this.con = con;
	}
	
	public boolean insertOrder(Order model) {
		boolean result = false;
		
		try {
			
			query= "insert into orders(p_id,u_id,o_quantity,o_date) values(?,?,?,?)";
			pst = this.con.prepareStatement(query);
			pst.setInt(1,model.getId());
			pst.setInt(2,model.getuId());
			pst.setInt(3, model.getQuantity());
			pst.setString(4,model.getDate());
			pst.executeUpdate();
			result = true;

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Order> userorder(int id)
	{
		List<Order> list = new ArrayList<Order>();

		try {
			
			query= "select * from orders where u_id=? order by orders.o_id desc";
			pst = this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs= pst.executeQuery();
			
			while(rs.next())
			{
				Order order = new Order();
				ProductDao pdao = new ProductDao(this.con);
				//int Pid = rs.getInt("p_id");
				
				product p = pdao.getSingleProduct(rs.getInt("p_id"));
				
				order.setOrderId(rs.getInt("o_id"));
				order.setId(rs.getInt("p_id"));
				order.setName(p.getName());
				order.setCategory(p.getCategory());
				order.setPrice(p.getPrice() * rs.getInt("o_quantity"));
				order.setQuantity(rs.getInt("o_quantity"));
				order.setDate(rs.getString("o_date"));
				list.add(order);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public int CancleOrder(int id)
	{
		try {
			query= "delete from orders where o_id=?";
			pst = this.con.prepareStatement(query);
			pst.setInt(1,id);
			pst.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	
}
