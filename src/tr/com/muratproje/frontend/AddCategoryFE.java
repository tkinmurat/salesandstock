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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import tr.com.muratproje.dal.CategoryDal;
import tr.com.muratproje.interfaces.FrontEndInterfaces;
import tr.com.muratproje.types.CategoryContract;

public class AddCategoryFE extends JDialog implements FrontEndInterfaces {

	public AddCategoryFE() {
		initWindow();
	}

	@Override
	public void initWindow() {
		
		JPanel panel=initPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Category Registration Area"));
		add(panel);
		setTitle("Add Category");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(3, 2));

		JLabel nameLabel = new JLabel("Category's Name: ", JLabel.CENTER);
		panel.add(nameLabel);
		JTextField nameField = new JTextField(15);
		panel.add(nameField);

		JLabel categoryLabel = new JLabel("Choose Category ", JLabel.CENTER);
		panel.add(categoryLabel);
		JComboBox categoryBox=new JComboBox(new CategoryDal().GetAllParentId().toArray());
		panel.add(categoryBox);
		categoryBox.insertItemAt("--Choose Category--", 0);
		categoryBox.setSelectedIndex(0);
		
		
		JButton saveButton = new JButton("Save");
		panel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CategoryContract contract =new CategoryContract();
				
				
				if(categoryBox.getSelectedIndex()!=0) {
					CategoryContract casContract= (CategoryContract) categoryBox.getSelectedItem();
				
					contract.setName(nameField.getText());
					contract.setParentId(casContract.getId());
					new CategoryDal().Insert(contract);
					JOptionPane.showMessageDialog(null,contract.getName()+" successfully added" );
				}else {
					contract.setName(nameField.getText());
					contract.setParentId(categoryBox.getSelectedIndex());
					new CategoryDal().Insert(contract);
					JOptionPane.showMessageDialog(null,contract.getName()+" successfully added" );
				
				
				}
				
				
			}
		});
		
		JButton cancelButton = new JButton("Cancel");
		panel.add(cancelButton);

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
