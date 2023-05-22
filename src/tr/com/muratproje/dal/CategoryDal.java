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

public class CategoryDal extends ObjectHelper implements DALInterfaces<CategoryContract>{

	@Override
	public void Insert(CategoryContract entity) {
		Connection connection= getConnection();
		try {
			Statement statement=connection.createStatement();
			
			statement.executeUpdate("INSERT INTO Category(name,parentId) VALUES('" + entity.getName()+"',"+entity.getParentId()+")");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		
	}

	@Override
	public List<CategoryContract> GetAll() {

		List<CategoryContract> datacontract= new ArrayList<CategoryContract>();
		Connection connection=getConnection();
		CategoryContract contract;
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet= statement.executeQuery("Select * from category");
			while(resultSet.next()) {
				contract= new CategoryContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setName(resultSet.getString("name"));
				contract.setParentId(resultSet.getInt("parentId"));
				datacontract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datacontract;
	}
	
	public List<CategoryContract> GetAllParentId(){
		
		List<CategoryContract> datacontract= new ArrayList<CategoryContract>();
		Connection connection=getConnection();
		CategoryContract contract;
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet= statement.executeQuery("Select * from category where parentId=0");
			while(resultSet.next()) {
				contract= new CategoryContract();
				contract.setId(resultSet.getInt("Id"));
				contract.setName(resultSet.getString("name"));
				contract.setParentId(resultSet.getInt("parentId"));
				datacontract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datacontract;
		
	}

	
	@Override
	public CategoryContract Delete(CategoryContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(CategoryContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoryContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}




}
