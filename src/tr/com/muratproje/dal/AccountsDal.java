package tr.com.muratproje.dal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tr.com.muratproje.core.ObjectHelper;
import tr.com.muratproje.interfaces.DALInterfaces;
import tr.com.muratproje.types.AccountsContract;
import tr.com.muratproje.types.CategoryContract;
import tr.com.muratproje.types.EmployeeContract;

public class AccountsDal extends ObjectHelper implements DALInterfaces<AccountsContract> {

	@Override
	public void Insert(AccountsContract entity) {
		Connection connection= getConnection();
		try {
			Statement statement=connection.createStatement();
			
			statement.executeUpdate("INSERT INTO accounts(titleId,employeeId,password) VALUES(" + entity.getTitleId()+","+entity.getEmployeeId()+",'"+entity.getPassword()+"')");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	public AccountsContract GetEmployeeIdAndPassword(int employeeId,String password){
		
		AccountsContract contract=  new AccountsContract();
		List<AccountsContract> listcontract= new ArrayList<AccountsContract>();
		Connection connection=getConnection();

		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet= statement.executeQuery("select * FROM accounts "+ "where employeeId="+employeeId+" and password='"+password.trim()+"'");
			while(resultSet.next()) {
				contract.setId(resultSet.getInt("Id"));
				contract.setEmployeeId(resultSet.getInt("employeeId"));
				contract.setPassword(resultSet.getString("password"));
				contract.setTitleId(resultSet.getInt("titleId"));

			}
			
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contract;
	}

public AccountsContract GetTitleId(int employeeId){
		
		AccountsContract contract=  new AccountsContract();
		List<AccountsContract> listcontract= new ArrayList<AccountsContract>();
		Connection connection=getConnection();

		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet= statement.executeQuery("select * FROM accounts "+ "where employeeId="+employeeId+"");
			while(resultSet.next()) {
				contract.setId(resultSet.getInt("Id"));
				contract.setEmployeeId(resultSet.getInt("employeeId"));
				contract.setTitleId(resultSet.getInt("titleId"));

			}
			
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contract;
	}
		
	
	@Override
	public List<AccountsContract> GetAll() {
		List<AccountsContract> datacontract= new ArrayList<AccountsContract>();
		Connection connection=getConnection();
		AccountsContract contract;
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet= statement.executeQuery("Select * from accounts");
			while(resultSet.next()) {
				contract= new AccountsContract();
				
				
				datacontract.add(contract);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datacontract;
	}

	@Override
	public AccountsContract Delete(AccountsContract entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(AccountsContract entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AccountsContract> GetById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}
