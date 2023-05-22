package tr.com.muratproje.core;

import java.sql.Connection;

public class CoreFields {

	
	private String userName="root";
	private String password="12345";
	private String url="jdbc:mysql://localhost/salesandstock?useUnicode=true&characterEndcoding=UTF-8";
	
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getUrl() {
		return url;
	}
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}
