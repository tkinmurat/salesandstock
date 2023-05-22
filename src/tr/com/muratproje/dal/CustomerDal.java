package tr.com.muratproje.dal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import tr.com.muratproje.core.ObjectHelper;
import tr.com.muratproje.interfaces.DALInterfaces;
import tr.com.muratproje.types.CustomerContract;

public class CustomerDal extends ObjectHelper implements DALInterfaces<CustomerContract> {

	@Override
	public void Insert(CustomerContract entity) {
		Connection connection= getConnection();
		try {
			Statement statement=connection.createStatement();
			
			statement.executeUpdate("INSERT INTO customer(name,lastName,address,phoneNumber,cityId) VALUES('" + entity.getName()+"','" + entity.getlastName()+"','" + entity.getAddress()+"','" + entity.getPhoneNumber()+"'," + entity.getCityId()+")");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public List<CustomerContract> GetAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerContract Delete(CustomerContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(CustomerContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
