package tr.com.muratproje.frontend;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import tr.com.muratproje.interfaces.FrontEndInterfaces;
import tr.com.muratproje.utilities.MenusCom;

public class MainWindowFE extends JFrame implements FrontEndInterfaces {

	public MainWindowFE() {
		initWindow();
	}

	@Override
	public void initWindow() {
	
		JPanel panel= initPanel();
		JMenuBar bar= initBar();
		
		add(panel);
		setJMenuBar(bar);
		setTitle("SALES and STOCK");
		setSize(600,250);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public JPanel initPanel() {
		
		JPanel panel= new JPanel(new BorderLayout());
		
		JTabbedPane pane=initTabs();
		
		panel.add(pane,BorderLayout.CENTER);
		return panel;
	} 

	@Override
	public JMenuBar initBar() {
		JMenuBar bar=MenusCom.initBar();
		return bar;
	}

	@Override
	public JTabbedPane initTabs() {
		
			JTabbedPane pane=new JTabbedPane();
			
			ImageIcon icon=new ImageIcon("icons/stockss.png");
			ImageIcon icon2=new ImageIcon("icons/stockss.png");
			
			JPanel stockPanel=new JPanel(new BorderLayout());
			JPanel salesPanel=new JPanel(new BorderLayout());
			
			JPanel stockLeftPanel=new JPanel(new BorderLayout());
			JPanel stockTopLeftPanel=new JPanel(new GridLayout(4,2));
			JPanel stockBottomLeftPanel=new JPanel();
			
			stockLeftPanel.setBorder(BorderFactory.createTitledBorder("Stocks Process"));
			Object [] stockColumns= {"Id","EmployeeName","Product's Name","Pieces","Date"};
			DefaultTableModel model= new DefaultTableModel(stockColumns,0);
			
			JTable table =new JTable(model);
			
			JScrollPane stockTablePane= new JScrollPane(table);

			
			JLabel stockProductNameLabel=new JLabel("Product Name:",JLabel.RIGHT);
			stockTopLeftPanel.add(stockProductNameLabel);
			JComboBox stockProductNameBox=new JComboBox();
			stockTopLeftPanel.add(stockProductNameBox);
			JLabel stockPiecesLabel=new JLabel("Pieces:",JLabel.RIGHT);
			stockTopLeftPanel.add(stockPiecesLabel);
			JTextField stockPiecesField= new JTextField(10);
			stockTopLeftPanel.add(stockPiecesField);
			JLabel stockDateLabel=new JLabel("Stock Date",JLabel.RIGHT);
			stockTopLeftPanel.add(stockDateLabel);
			JDateChooser stockDate=new JDateChooser();
			stockTopLeftPanel.add(stockDate);
			
			JButton addStockButton = new JButton("Add Stock");
			stockTopLeftPanel.add(addStockButton);
			JButton refreshButton = new JButton("Refresh");
			stockTopLeftPanel.add(refreshButton);
			
			
			///////////////////////
			
			JPanel salesRightPanel=new JPanel(new BorderLayout());
			JPanel salesTopRightPanel=new JPanel(new GridLayout(5,2));
			JPanel salesBottomRightPanel=new JPanel();
			
			salesRightPanel.setBorder(BorderFactory.createTitledBorder("Sales Process"));
			Object [] salesColumns= {"Id","EmployeeName","Customer Name","Product's Name","Pieces","Date"};
			DefaultTableModel salesmodel= new DefaultTableModel(salesColumns,0);
			
			JTable salestable =new JTable(salesmodel);
			
			JScrollPane salesTablePane= new JScrollPane(salestable);

			
			JLabel salesProductNameLabel=new JLabel("Product Name:",JLabel.RIGHT);
			salesTopRightPanel.add(salesProductNameLabel);
			JComboBox salesProductNameBox=new JComboBox();
			salesTopRightPanel.add(salesProductNameBox);
			JLabel salesCustomerNameLabel=new JLabel("Customer Name:",JLabel.RIGHT);
			salesTopRightPanel.add(salesCustomerNameLabel);
			JComboBox salesCustomerNameBox=new JComboBox();
			salesTopRightPanel.add(salesCustomerNameBox);
			JLabel salesPiecesLabel=new JLabel("Pieces:",JLabel.RIGHT);
			salesTopRightPanel.add(salesPiecesLabel);
			JTextField salesPiecesField= new JTextField(10);
			salesTopRightPanel.add(salesPiecesField);
			JLabel salesDateLabel=new JLabel("Sales Date",JLabel.RIGHT);
			salesTopRightPanel.add(salesDateLabel);
			JDateChooser saleskDate=new JDateChooser();
			salesTopRightPanel.add(saleskDate);
			
			JButton saveButton = new JButton("Sales");
			salesTopRightPanel.add(saveButton);
			JButton cancelButton = new JButton("Refresh");
			salesTopRightPanel.add(cancelButton);
			
			
			
			stockPanel.add(stockLeftPanel,BorderLayout.WEST);
			stockPanel.add(stockTablePane,BorderLayout.CENTER);
			stockLeftPanel.add(stockTopLeftPanel,BorderLayout.NORTH);
			stockLeftPanel.add(stockBottomLeftPanel,BorderLayout.SOUTH);
			
			salesPanel.add(salesRightPanel,BorderLayout.WEST);
			salesPanel.add(salesTablePane,BorderLayout.CENTER);
			salesRightPanel.add(salesTopRightPanel,BorderLayout.NORTH);
			salesRightPanel.add(salesBottomRightPanel,BorderLayout.SOUTH);
			
			
			
			
			
			pane.addTab("Stocks ", icon, stockPanel,"Stocks");
			pane.addTab("Sales ", icon2, salesPanel, "Sales");
			return pane;
	}

}
