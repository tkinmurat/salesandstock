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

import tr.com.muratproje.dal.TitlesDal;
import tr.com.muratproje.interfaces.FrontEndInterfaces;
import tr.com.muratproje.types.TitlesContract;

public class AddTitleFE extends JDialog implements FrontEndInterfaces{

	public AddTitleFE() {
		initWindow();
	}

	@Override
	public void initWindow() {
		JPanel panel= initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Add Title"));
		add(panel);
		setTitle("Add Title");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel= new JPanel(new GridLayout(2, 2));
		JLabel nameLabel = new JLabel("Title Name: ", JLabel.CENTER);
		panel.add(nameLabel);
		JTextField nameField = new JTextField(20);
		panel.add(nameField);
		
		
		JButton saveButton = new JButton("Save");
		panel.add(saveButton);
		
		JButton cancelButton = new JButton("Cancel");
		panel.add(cancelButton);
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TitlesContract contract=new TitlesContract();
				
				contract.setName(nameField.getText());
				new TitlesDal().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getName()+" named title is added");
				
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
