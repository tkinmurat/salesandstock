package tr.com.muratproje.complex.types;

import java.sql.Date;

public class StockContractComplex {


	private int id;
	private String productName;
	private String employeeName;
	private Date date;
	private int pieces;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPieces() {
		return pieces;
	}
	public void setPieces(int pieces) {
		this.pieces = pieces;
	}
	 @Override
	public String toString() {
		 return employeeName+" "+productName;
	}
	
}
