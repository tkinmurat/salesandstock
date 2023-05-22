package tr.com.muratproje.types;

import java.sql.Date;

public class StockContract {
	
	private int id;
	private int employeeId;
	private String productId;
	private Date date;
	private int piece;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPiece() {
		return piece;
	}
	public void setPiece(int piece) {
		this.piece = piece;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+" "+employeeId+" "+productId+" "+date+" "+piece;
	}
	

}
