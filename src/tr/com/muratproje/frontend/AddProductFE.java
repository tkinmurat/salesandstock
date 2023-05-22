package tr.com.muratproje.frontend;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

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
import tr.com.muratproje.dal.ProductsDal;
import tr.com.muratproje.interfaces.FrontEndInterfaces;
import tr.com.muratproje.types.CategoryContract;
import tr.com.muratproje.types.ProductContract;

public class AddProductFE extends JDialog implements FrontEndInterfaces {

	public AddProductFE() {
		initWindow();

	}

	@Override
	public void initWindow() {
		JPanel panel = initPanel();

		panel.setBorder(BorderFactory.createTitledBorder("Product Registration Area"));
		add(panel);
		setTitle("Add Product");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {

		JPanel panel = new JPanel(new GridLayout(5, 2));

		JLabel nameLabel = new JLabel("Product's Name: ", JLabel.CENTER);
		panel.add(nameLabel);
		JTextField nameField = new JTextField(10);
		panel.add(nameField);

		JLabel categoryLabel = new JLabel("Category: ", JLabel.CENTER);
		panel.add(categoryLabel);
		JComboBox categoryBox = new JComboBox(new CategoryDal().GetAll().toArray());
		panel.add(categoryBox);

		JLabel dateLabel = new JLabel("Date: ", JLabel.CENTER);
		panel.add(dateLabel);
		JDateChooser dateeDate = new JDateChooser();
		panel.add(dateeDate);

		JLabel priceLabel = new JLabel("Price: ", JLabel.CENTER);
		panel.add(priceLabel);
		JTextField priceField = new JTextField(10);
		panel.add(priceField);

		JButton saveButton = new JButton("Save");
		panel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProductContract contract=new ProductContract();
				CategoryContract casContract= (CategoryContract) categoryBox.getSelectedItem();
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				
				String date = format.format(dateeDate.getDate());
				
				contract.setName(nameField.getText());
				contract.setCategoryId(casContract.getId());
				contract.setDate(date);
				contract.setPrice(Float.parseFloat(priceField.getText()));
				
				new ProductsDal().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getName()+" successfully added");
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
