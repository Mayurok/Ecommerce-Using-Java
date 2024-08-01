package project.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import project.Connection.ConnectionProvider;
import project.Model.Cart;
import project.Model.product;

public class ProductDao {

    private Connection con=null;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public ProductDao(Connection con) {
        this.con = con;
    }

    public List<product> getAllProducts() {
        List<product> products = new ArrayList<product>();
        try {
             query = "select * from products";
            if (this.con == null) {
                this.con = ConnectionProvider.getConnection();
            }
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                product row = new product();
                row.setId(rs.getInt("Id"));
                row.setName(rs.getString("name"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getDouble("price"));
                row.setImage(rs.getString("image"));
                products.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con == null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return products;
        
     
    }
    public List<Cart> getCartProducts(ArrayList<Cart> cartList){
  	  
    	List<Cart> products = new ArrayList<Cart>();
    	
    	try {
    		if(cartList.size()>0) {
    			for(Cart item: cartList)
    			{
    				query = "select * from products where id=?";
    	            pst = this.con.prepareStatement(query);
    	            pst.setInt(1,item.getId());
    	            rs = pst.executeQuery();
    	            while(rs.next())
    	            {
    	            	Cart row = new Cart();
    	            	row.setId(rs.getInt("id"));
    	            	row.setName(rs.getString("name"));
    	            	row.setCategory(rs.getString("category"));
    	            	row.setPrice(rs.getDouble("price")*item.getQuantity());
    	            	row.setQuantity(item.getQuantity());
    	            	products.add(row);
    	            	
    	            	
    	            }
    				
    			}
    		}
    		
    	}catch(Exception e)
    	{
    		System.out.print(e.getMessage());
    		e.printStackTrace();
    	}
    	
    	return products; 
    	}
    
    public Double getTotalCartPrice(ArrayList<Cart> cartList) {
		double sum = 0;
		
		try {
			if(cartList.size()>0)
			{
				for(Cart item : cartList)
				{
					pst= this.con.prepareStatement(query);
					pst.setInt(1,item.getId());
					rs= pst.executeQuery();
					
					while(rs.next())
					{
						sum+= rs.getDouble("price")*item.getQuantity();
					}
				}
			}
			query = "select price from product where id=?";
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sum;
	}
    
    public product getSingleProduct(int id) {
    	//List<Cart> products = new ArrayList<Cart>();

    	product row = null;
    	try {
    		query="select * from products where id=?";
			pst= this.con.prepareStatement(query);
			pst.setInt(1, id);
			rs= pst.executeQuery();
			row = new product();
			while(rs.next())
			{
				
				row.setId(rs.getInt("id"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getDouble("price"));
				row.setImage(rs.getString("image"));
			}
			
			
		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return row;
    }
    	
    public product AddProduct(String name, String category, String price, String image) {
        product prod = null;
        
        String query = "insert into products(name, category, price, image) values(?, ?, ?, ?)";
        
        try (Connection con = ConnectionProvider.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            
            pst.setString(1, name);
            pst.setString(2, category);
            pst.setString(3, price);
            pst.setString(4, image);
            pst.executeUpdate();
            
            prod = new product();
            prod.setName(name);
            prod.setCategory(category);
            prod.setPrice(Double.parseDouble(price));
            //prod.setPrice(price);

            prod.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return prod;
    }

    	}

 
    

