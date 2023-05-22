package tr.com.muratproje.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.muratproje.core.ObjectHelper;
import tr.com.muratproje.interfaces.DALInterfaces;
import tr.com.muratproje.types.EmployeeContract;
import tr.com.muratproje.types.TitlesContract;

public class TitlesDal extends ObjectHelper implements DALInterfaces<TitlesContract>{

	@Override
	public void Insert(TitlesContract entity) {
		Connection connection= getConnection();
		try {
			Statement statement=connection.createStatement();
			
			statement.executeUpdate("INSERT INTO titles(name) VALUES('" + entity.getName()+"')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TitlesContract> GetAll() {
		List<TitlesContract> datacontract= new ArrayList<TitlesContract>();
		Connection connection=getConnection();
		TitlesContract contract;
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet= statement.executeQuery("Select * from titles");
			while(resultSet.next()) {
				contract= new TitlesContract();
				
				contract.setId(resultSet.getInt("Id"));
				contract.setName(resultSet.getString("name"));
				
				
				datacontract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datacontract;
	}

	@Override
	public TitlesContract Delete(TitlesContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(TitlesContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TitlesContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
