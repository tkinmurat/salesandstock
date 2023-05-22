package tr.com.muratproje.frontend;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import tr.com.muratproje.dal.CategoryDal;
import tr.com.muratproje.interfaces.FrontEndInterfaces;

public class AddCustomerFE extends JDialog implements FrontEndInterfaces {

	public AddCustomerFE() {
		initWindow();
	}

	@Override
	public void initWindow() {
		
		JPanel panel=initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Add Customer"));
		add(panel);
		setTitle("Add Customer");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		
		JPanel panel = new JPanel(new BorderLayout());
		JPanel fieldpanel = new JPanel(new GridLayout(6, 2));
		JPanel buttonPanel=new JPanel(new GridLayout(1,2));
		
		JLabel nameLabel = new JLabel("Name: ", JLabel.CENTER);
		fieldpanel.add(nameLabel);
		JTextField nameField = new JTextField(15);
		fieldpanel.add(nameField);

		JLabel lastNameLabel = new JLabel("Last Name: ", JLabel.CENTER);
		fieldpanel.add(lastNameLabel);
		JTextField lastNameField = new JTextField(15);
		fieldpanel.add(lastNameField);
		

		JLabel phoneNumberLabel = new JLabel("Phone Number: ", JLabel.CENTER);
		fieldpanel.add(phoneNumberLabel);
		JTextField phoneNumberField = new JTextField(15);
		fieldpanel.add(phoneNumberField);
		
		JLabel cityIdLabel = new JLabel("City ID: ", JLabel.CENTER);
		fieldpanel.add(cityIdLabel);
		JComboBox cityIdBox = new JComboBox();
		fieldpanel.add(cityIdBox);
		
		
		JLabel addressLabel = new JLabel("Address: ");
		fieldpanel.add(addressLabel);
		
		JTextArea addressArea = new JTextArea(6,1);
		JScrollPane pane= new JScrollPane(addressArea);
		pane.setBorder(BorderFactory.createTitledBorder("Address Information"));

		JButton saveButton = new JButton("Save");
		buttonPanel.add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		buttonPanel.add(cancelButton);
		
		panel.add(fieldpanel,BorderLayout.NORTH);
		panel.add(pane,BorderLayout.CENTER);
		panel.add(buttonPanel,BorderLayout.SOUTH);
		
		
		
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
