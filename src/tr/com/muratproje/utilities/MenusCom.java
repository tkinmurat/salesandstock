package tr.com.muratproje.utilities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import tr.com.muratproje.frontend.AddProductFE;
import tr.com.muratproje.frontend.AddTitleFE;
import tr.com.muratproje.frontend.GetPassFE;
import tr.com.muratproje.frontend.LoginFE;
import tr.com.muratproje.types.EmployeeContract;
import tr.com.muratproje.dal.AccountsDal;
import tr.com.muratproje.frontend.AddCategoryFE;
import tr.com.muratproje.frontend.AddCustomerFE;
import tr.com.muratproje.frontend.AddEmployeeFE;


public class MenusCom {

	public static JMenuBar initBar() {
		JMenuBar bar=new JMenuBar();
		JMenu fileMenu=new JMenu("File");
		bar.add(fileMenu);
		JMenuItem exitItem= new JMenuItem("Exit");
		fileMenu.add(exitItem);
		
		JMenu productsMenu=new JMenu("Products");
		bar.add(productsMenu);
		JMenuItem addProductItem=new JMenuItem("Add Products");
		productsMenu.add(addProductItem);
		JMenuItem addCategoryItem=new JMenuItem("Add Category");
		productsMenu.add(addCategoryItem);
		productsMenu.addSeparator();
		JMenuItem editProductItem= new JMenuItem("Edit Product");
		productsMenu.add(editProductItem);
		JMenuItem editCategoryItem= new JMenuItem("Edit Category");
		productsMenu.add(editCategoryItem);
		
		JMenu employeeMenu=new JMenu("Employees");
		bar.add(employeeMenu);
		JMenuItem addEmployeeItem= new JMenuItem("Add Employee");
		employeeMenu.add(addEmployeeItem);
		JMenuItem addTitleItem= new JMenuItem("Add Title");
		employeeMenu.add(addTitleItem);
		JMenuItem getPassItem= new JMenuItem("Password Setting");
		employeeMenu.add(getPassItem);
		employeeMenu.addSeparator();
		
		JMenuItem editEmployeeItem= new JMenuItem("Edit Employee");
		employeeMenu.add(editEmployeeItem);
		JMenuItem editTitleItem= new JMenuItem("Edit Title");
		employeeMenu.add(editTitleItem);
		JMenuItem editPassItem= new JMenuItem("Edit Password");
		employeeMenu.add(editPassItem);
		
		
		
		JMenu customersMenu=new JMenu("Customers");
		bar.add(customersMenu);
		JMenuItem addCustomerItem=new JMenuItem("Add Customer");
		customersMenu.add(addCustomerItem);
		JMenuItem addCityItem=new JMenuItem("Add City");
		customersMenu.add(addCityItem);
		customersMenu.addSeparator();
		
		JMenuItem editCustomerItem=new JMenuItem("Edit Customer");
		customersMenu.add(editCustomerItem);
		JMenuItem editCityItem=new JMenuItem("Edit City");
		customersMenu.add(editCityItem);
		
		EmployeeContract contract=(EmployeeContract) LoginFE.emailBox.getSelectedItem();
		
		if(new AccountsDal().GetTitleId(contract.getId()).getTitleId()==2) {
			
			employeeMenu.hide();
		}else if(new AccountsDal().GetTitleId(contract.getId()).getTitleId()==3){
			
			customersMenu.hide();
			employeeMenu.hide();
			productsMenu.hide();
		}
		
		
		addProductItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {

						new AddProductFE();
						
					}
				});
				
			}
		});
		
		addCategoryItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new AddCategoryFE();
				
			}
		});
		addEmployeeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new AddEmployeeFE();
						
					}
				});
				
			}
		});
		
		addTitleItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new AddTitleFE();
						
					}
				});
				
			}
		});
		
		getPassItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new GetPassFE();
				
			}
		});
		
		addCustomerItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						new AddCustomerFE();
						
					}
				});
				
			}
		});
		return bar;
	}
}
