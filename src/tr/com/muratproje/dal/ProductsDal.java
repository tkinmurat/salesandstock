package tr.com.muratproje.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import tr.com.muratproje.core.ObjectHelper;
import tr.com.muratproje.interfaces.DALInterfaces;
import tr.com.muratproje.types.ProductContract;

public class ProductsDal extends ObjectHelper implements DALInterfaces<ProductContract>{

	@Override
	public void Insert(ProductContract entity) {
		Connection connection= getConnection();
		try {
			Statement statement=connection.createStatement();
			
			statement.executeUpdate("INSERT INTO products(name,categoryId,datee,price) VALUES('" + entity.getName()+"',"+entity.getCategoryId()+",'"+entity.getDate()+"',"+entity.getPrice()+")");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<ProductContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductContract Delete(ProductContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(ProductContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	

}
