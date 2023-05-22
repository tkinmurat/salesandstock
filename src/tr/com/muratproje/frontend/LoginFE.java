package tr.com.muratproje.frontend;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;

import tr.com.muratproje.dal.AccountsDal;
import tr.com.muratproje.dal.EmployeeDal;
import tr.com.muratproje.interfaces.FrontEndInterfaces;
import tr.com.muratproje.types.EmployeeContract;

public class LoginFE extends JDialog implements FrontEndInterfaces{
	
	public static JComboBox emailBox;
	public LoginFE() {

initWindow();
	}

	@Override
	public void initWindow() {
		
		JPanel panel=initPanel();
		add(panel);
		pack();
		setTitle("Login");
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3,2));
		JLabel emailLabel=new JLabel("Email: ",JLabel.RIGHT);
		panel.add(emailLabel);
		emailBox=new JComboBox(new EmployeeDal().GetAll().toArray());
		panel.add(emailBox);
		
		JLabel passwordLabel=new JLabel("Password: ",JLabel.RIGHT);
		panel.add(passwordLabel);
		JPasswordField passwordField=new JPasswordField(15);
		panel.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		panel.add(loginButton);
		JButton cancelButton = new JButton("Cancel");
		panel.add(cancelButton);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				EmployeeContract contract=(EmployeeContract) emailBox.getSelectedItem();

				if(new AccountsDal().GetEmployeeIdAndPassword(contract.getId(), passwordField.getText()).getId()!=0) {
					new MainWindowFE();
				}else {
					JOptionPane.showMessageDialog(null, "Wrong Password or Username");
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
