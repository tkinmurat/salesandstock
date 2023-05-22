package tr.com.muratproje.frontend;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.com.muratproje.dal.EmployeeDal;
import tr.com.muratproje.interfaces.FrontEndInterfaces;
import tr.com.muratproje.types.EmployeeContract;

public class AddEmployeeFE extends JDialog implements FrontEndInterfaces {

	public AddEmployeeFE() {
		initWindow();
	}

	@Override
	public void initWindow() {
		JPanel panel= initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Employee Registration Area"));
		add(panel);
		setTitle("Add Employee");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel= new JPanel(new GridLayout(4, 2));
		JLabel nameLabel = new JLabel("Name: ", JLabel.CENTER);
		panel.add(nameLabel);
		JTextField nameField = new JTextField(20);
		panel.add(nameField);
		JLabel lastNameLabel = new JLabel("Last Name: ", JLabel.CENTER);
		panel.add(lastNameLabel);
		JTextField lastNameField = new JTextField(20);
		panel.add(lastNameField);
		JLabel emailLabel = new JLabel("e-mail: ", JLabel.CENTER);
		panel.add(emailLabel);
		JTextField emailField = new JTextField(20);
		panel.add(emailField);
		
		JButton saveButton = new JButton("Save");
		panel.add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		panel.add(cancelButton);
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EmployeeContract contract= new EmployeeContract();
			contract.setName(nameField.getText());
			contract.setLastName(lastNameField.getText());
			contract.setEmail(emailField.getText());
				
				new EmployeeDal().Insert(contract); 
			JOptionPane.showMessageDialog(null, "Staff named "+contract.getName()+" "+contract.getLastName()+" has been added");
				
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
