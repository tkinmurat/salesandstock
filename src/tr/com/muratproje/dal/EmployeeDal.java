package tr.com.muratproje.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.muratproje.core.ObjectHelper;
import tr.com.muratproje.interfaces.DALInterfaces;
import tr.com.muratproje.types.CategoryContract;
import tr.com.muratproje.types.EmployeeContract;

public class EmployeeDal extends ObjectHelper implements DALInterfaces<EmployeeContract> {

	@Override
	public void Insert(EmployeeContract entity) {
		Connection connection= getConnection();
		try {
			Statement statement=connection.createStatement();
			
			statement.executeUpdate("INSERT INTO Employee(name,lastName,email) VALUES('" + entity.getName()+"','"+entity.getLastName()+"','"+entity.getEmail()+"')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<EmployeeContract> GetAll() {
		List<EmployeeContract> datacontract= new ArrayList<EmployeeContract>();
		Connection connection=getConnection();
		EmployeeContract contract;
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet= statement.executeQuery("Select * from employee");
			while(resultSet.next()) {
				contract= new EmployeeContract();
				
				contract.setId(resultSet.getInt("Id"));
				contract.setName(resultSet.getString("name"));
				contract.setLastName(resultSet.getString("lastName"));
				contract.setEmail(resultSet.getString("email"));
				
				
				datacontract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datacontract;
	}

	@Override
	public EmployeeContract Delete(EmployeeContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(EmployeeContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmployeeContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
