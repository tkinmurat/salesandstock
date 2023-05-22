package tr.com.muratproje.frontend;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.muratproje.dal.AccountsDal;
import tr.com.muratproje.dal.EmployeeDal;
import tr.com.muratproje.dal.TitlesDal;
import tr.com.muratproje.interfaces.FrontEndInterfaces;
import tr.com.muratproje.types.AccountsContract;
import tr.com.muratproje.types.EmployeeContract;
import tr.com.muratproje.types.TitlesContract;

public class GetPassFE extends JDialog implements FrontEndInterfaces{

	public GetPassFE() {
		initWindow();
	}

	@Override
	public void initWindow() {


		JPanel panel= initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Get Password"));
		add(panel);
		setTitle("Get Password");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel= new JPanel(new GridLayout(5, 2));
		JLabel employeeLabel = new JLabel("Select Employee: ", JLabel.CENTER);
		panel.add(employeeLabel);
		JComboBox employeeBox=new JComboBox(new EmployeeDal().GetAll().toArray());
		panel.add(employeeBox);
		JLabel titleLabel= new JLabel("Select Title: ", JLabel.CENTER);
		panel.add(titleLabel);
		JComboBox titleBox=new JComboBox(new TitlesDal().GetAll().toArray());
		panel.add(titleBox);
		
		JLabel passLabel= new JLabel("Assign Password: ", JLabel.CENTER);
		panel.add(passLabel);
		JPasswordField passField=new JPasswordField(15);
		panel.add(passField);
		JLabel repPassLabel= new JLabel("Repeat Assign Password: ", JLabel.CENTER);
		panel.add(repPassLabel);
		JPasswordField repPassField=new JPasswordField(15);
		panel.add(repPassField);
		
		
		JButton saveButton = new JButton("Save");
		panel.add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		panel.add(cancelButton);
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AccountsContract contract=new AccountsContract();
				EmployeeContract pContract=(EmployeeContract) employeeBox.getSelectedItem();
				TitlesContract tContract= (TitlesContract) titleBox.getSelectedItem();
				
				if(passField.getText().equals(repPassField.getText())) {
					
					contract.setEmployeeId(pContract.getId());
					contract.setTitleId(tContract.getId());
					contract.setPassword(passField.getText());
					new AccountsDal().Insert(contract);
					JOptionPane.showMessageDialog(null,"Succesfully saved.");
					
				}else {
					JOptionPane.showMessageDialog(null,"Passwords are not same.");
				}
				
				
			}
		});
		
		return panel;
	}

	@Override
	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}
