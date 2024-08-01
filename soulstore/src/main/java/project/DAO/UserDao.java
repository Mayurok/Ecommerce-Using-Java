package project.DAO;
import java.sql.*;
import project.Model.Register;
import project.Connection.ConnectionProvider;
import project.Model.Users;
public class UserDao {
	
	private Connection con ;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public UserDao(Connection con) {
		this.con = con;
	}
	
	public Users userlogin(String email , String password) {
		Users user = null;
		try {
			query = "select * from users where email=? and password=?"; 
			ConnectionProvider.getConnection();	
			pst = this.con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			rs = pst.executeQuery();
			
			if(rs.next()) {
			 user = new Users();
				user.setId(rs.getInt("user_id"));
				user.setName(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}

		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return user;
	}
	
	public Register registeruser(String name ,String email , String password) {
		Register reg = null;
		try {
			query = "insert into users(username,email,password) values(?,?,?)"; 
			ConnectionProvider.getConnection();	
			pst = this.con.prepareStatement(query);
			pst.setString(1,name);
			pst.setString(2,email);
			pst.setString(3,password);
			int rowAffected = pst.executeUpdate();
			
			if (rowAffected > 0) {
                reg = new Register();
                reg.setName(name);
                reg.setEmail(email);
                reg.setPassword(password);
            }

		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return reg;
	}
	
	
}
