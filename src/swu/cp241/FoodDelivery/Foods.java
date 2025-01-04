package swu.cp241.FoodDelivery;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class Foods extends JFrame implements ActionListener {

	//ArrayQueue queue = new ArrayQueue();
	LinkedQueue queue = new LinkedQueue();
	Object obj;
	Order e;
	double amounttotal;
	static String customername;
	static String[] Drinks = { "Coffee", "Iced tea", "Sofe drink", "Milk", "Water" };
	static String[] Desserts = { "Cake", "Muffin", "Jelly", "Pudding", "Cookie" };
	static String[] MainCoursess = { "Fried rice", "Minced pork omelet over rice", "Stewed pork leg on rice",
			"Roasted duck over rice", "Rice porridge" };
	static double[] priceDrinks = { 50, 30, 25, 40, 10 };
	static double[] priceDesserts = { 80, 30, 20, 60, 30 };
	static double[] priceMainCoursess = { 50, 50, 50, 60, 40 };
	private JLabel TextLabel,totalLabel,emailcustomer;
	private JPanel page1Panel, page2Panel, drinkPanel, dessertPanel, maincoursesPanel, myOrderPanel, homePanel;
	private static JButton RemoveOrderButton, ConfirmOrderButton, AddOrderButton, MenuButton, ConfirmOrder2Button,
	CancelOrderButton, LogOutButton;
	private static JTable orderTable;
	private static JSpinner countItem1, countItem2, countItem3, countItem4, countItem5, countItem6, countItem7,
			countItem8, countItem9, countItem10, countItem11, countItem12, countItem13, countItem14, countItem15;
	private static JTabbedPane MenutabbedPane;
	private static double amount1 = 0, amount2 = 0, amount3 = 0, amount4 = 0, amount5 = 0, amount6 = 0, amount7 = 0, amount8 = 0, amount9 = 0, amount10 = 0,
			amount11 = 0, amount12 = 0, amount13 = 0, amount14 = 0, amount15 = 0;
	private static double amount = 0;
	private static DefaultTableModel model;
	private static JLabel menu1, menu2, menu3, menu4, menu5, menu6, menu7, menu8, menu9, menu10, menu11, menu12, menu13,
			menu14, menu15; 
	
	public Foods(String Email) {
		Foods.customername = Email;
		foods();
		myOrder(e);
		menufoods();
		home();
	}

	private void foods() {
		setTitle("Food Delivery");
		setBounds(440, 100, 400, 470);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(SystemColor.control);
		Container contentPane;
		contentPane = getContentPane();
		contentPane.setLayout(null);
		page1Panel = new JPanel();
		page2Panel = new JPanel();
		drinkPanel = new JPanel();
		dessertPanel = new JPanel();
		maincoursesPanel = new JPanel();
		myOrderPanel = new JPanel();
		homePanel = new JPanel();

		page1Panel.setLayout(null);
		page1Panel.setBackground(SystemColor.control);

		page2Panel.setLayout(null);
		page2Panel.setBackground(SystemColor.control);

		drinkPanel.setLayout(null);
		drinkPanel.setBackground(SystemColor.control);

		dessertPanel.setLayout(null);
		dessertPanel.setBackground(SystemColor.control);

		maincoursesPanel.setLayout(null);
		maincoursesPanel.setBackground(SystemColor.control);

		myOrderPanel.setLayout(null);
		myOrderPanel.setBackground(SystemColor.control);
		
		homePanel.setLayout(null);
		homePanel.setBackground(SystemColor.control);

		TextLabel = new JLabel();
		TextLabel.setText("Total :   ");
		TextLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		TextLabel.setBackground(SystemColor.black);
		TextLabel.setForeground(Color.black);
		TextLabel.setBounds(40, 220, 100, 30);
		page1Panel.add(TextLabel);

		RemoveOrderButton = new JButton();
		RemoveOrderButton.setText("Remove");
		RemoveOrderButton.setFont(new Font("Cordia New", Font.BOLD, 20));
		RemoveOrderButton.setBackground(SystemColor.black);
		RemoveOrderButton.setForeground(Color.white);
		RemoveOrderButton.setBounds(80, 380, 100, 25);
		page2Panel.add(RemoveOrderButton);
		RemoveOrderButton.addActionListener(this);

		ConfirmOrderButton = new JButton();
		ConfirmOrderButton.setText("Confirm");
		ConfirmOrderButton.setFont(new Font("Cordia New", Font.BOLD, 20));
		ConfirmOrderButton.setBackground(SystemColor.black);
		ConfirmOrderButton.setForeground(Color.white);
		ConfirmOrderButton.setBounds(200, 380, 100, 25);
		page2Panel.add(ConfirmOrderButton);
		ConfirmOrderButton.addActionListener(this);

		AddOrderButton = new JButton();
		AddOrderButton.setText("Add Order");
		AddOrderButton.setFont(new Font("Cordia New", Font.BOLD, 20));
		AddOrderButton.setBackground(SystemColor.black);
		AddOrderButton.setForeground(Color.white);
		AddOrderButton.setBounds(145, 175, 95, 25);
		page2Panel.add(AddOrderButton);
		AddOrderButton.addActionListener(this);

		MenuButton = new JButton();
		MenuButton.setText("Menu");
		MenuButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		MenuButton.setBackground(SystemColor.black);
		MenuButton.setForeground(Color.white);
		MenuButton.setBounds(0, 0, 0, 0);
		homePanel.add(MenuButton);
		MenuButton.addActionListener(this);

		ConfirmOrder2Button = new JButton();
		ConfirmOrder2Button.setText("Confirm Order");
		ConfirmOrder2Button.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		ConfirmOrder2Button.setBackground(SystemColor.black);
		ConfirmOrder2Button.setForeground(Color.white);
		ConfirmOrder2Button.setBounds(0, 0, 0, 0);
		homePanel.add(ConfirmOrder2Button);
		ConfirmOrder2Button.addActionListener(this);

		CancelOrderButton = new JButton();
		CancelOrderButton.setText("Cancel Order");
		CancelOrderButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		CancelOrderButton.setBackground(SystemColor.black);
		CancelOrderButton.setForeground(Color.white);
		CancelOrderButton.setBounds(0, 0, 0, 0);
		homePanel.add(CancelOrderButton);
		CancelOrderButton.addActionListener(this);

		LogOutButton = new JButton();
		LogOutButton.setText("Log Out");
		LogOutButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		LogOutButton.setBackground(SystemColor.black);
		LogOutButton.setForeground(Color.white);
		LogOutButton.setBounds(0, 0, 0, 0);
		homePanel.add(LogOutButton);
		LogOutButton.addActionListener(this);

		menu1 = new JLabel();
		menu1.setText(" Coffee ------------------------- 50");
		menu1.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu1.setBounds(50, 7, 250, 25);
		drinkPanel.add(menu1);

		menu2 = new JLabel();
		menu2.setText(" Iced tea ----------------------- 30");
		menu2.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu2.setBounds(50, 29, 250, 25);
		drinkPanel.add(menu2);

		menu3 = new JLabel();
		menu3.setText(" Sofe drink -------------------- 25");
		menu3.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu3.setBounds(50, 51, 250, 25);
		drinkPanel.add(menu3);

		menu4 = new JLabel();
		menu4.setText(" Milk ---------------------------- 40");
		menu4.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu4.setBounds(50, 73, 250, 25);
		drinkPanel.add(menu4);

		menu5 = new JLabel();
		menu5.setText(" Water ------------------------- 10");
		menu5.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu5.setBounds(50, 95, 250, 25);
		drinkPanel.add(menu5);

		menu6 = new JLabel();
		menu6.setText(" Cake ------------------------- 80");
		menu6.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu6.setBounds(50, 7, 250, 25);
		dessertPanel.add(menu6);

		menu7 = new JLabel();
		menu7.setText(" Muffin ------------------------ 30");
		menu7.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu7.setBounds(50, 29, 250, 25);
		dessertPanel.add(menu7);

		menu8 = new JLabel();
		menu8.setText(" Jelly -------------------------- 20");
		menu8.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu8.setBounds(50, 51, 250, 25);
		dessertPanel.add(menu8);

		menu9 = new JLabel();
		menu9.setText(" Pudding --------------------- 60");
		menu9.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu9.setBounds(50, 73, 250, 25);
		dessertPanel.add(menu9);

		menu10 = new JLabel();
		menu10.setText(" Cookie ---------------------- 30");
		menu10.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu10.setBounds(50, 95, 250, 25);
		dessertPanel.add(menu10);

		menu11 = new JLabel();
		menu11.setText(" Fried rice ----------------------------- 50");
		menu11.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu11.setBounds(50, 7, 280, 25);
		maincoursesPanel.add(menu11);

		menu12 = new JLabel();
		menu12.setText(" Minced pork omelet over rice ---- 50");
		menu12.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu12.setBounds(50, 29, 280, 25);
		maincoursesPanel.add(menu12);

		menu13 = new JLabel();
		menu13.setText(" Stewed pork leg on rice ----------- 50");
		menu13.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu13.setBounds(50, 51, 280, 25);
		maincoursesPanel.add(menu13);

		menu14 = new JLabel();
		menu14.setText(" Roasted duck over rice ------------ 60");
		menu14.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu14.setBounds(50, 73, 280, 25);
		maincoursesPanel.add(menu14);

		menu15 = new JLabel();
		menu15.setText(" Rice porridge ------------------------ 40");
		menu15.setFont(new Font("Cordia New", Font.BOLD, 20));
		menu15.setBounds(50, 95, 280, 25);
		maincoursesPanel.add(menu15);

		countItem1 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem1.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem1.setBackground(SystemColor.white);
		countItem1.setForeground(Color.black);
		countItem1.setBounds(15, 11, 30, 18);
		drinkPanel.add(countItem1);

		countItem2 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem2.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem2.setBackground(SystemColor.white);
		countItem2.setForeground(Color.black);
		countItem2.setBounds(15, 33, 30, 18);
		drinkPanel.add(countItem2);

		countItem3 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem3.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem3.setBackground(SystemColor.white);
		countItem3.setForeground(Color.black);
		countItem3.setBounds(15, 55, 30, 18);
		drinkPanel.add(countItem3);

		countItem4 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem4.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem4.setBackground(SystemColor.white);
		countItem4.setForeground(Color.black);
		countItem4.setBounds(15, 77, 30, 18);
		drinkPanel.add(countItem4);

		countItem5 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem5.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem5.setBackground(SystemColor.white);
		countItem5.setForeground(Color.black);
		countItem5.setBounds(15, 99, 30, 18);
		drinkPanel.add(countItem5);

		countItem6 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem6.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem6.setBackground(SystemColor.white);
		countItem6.setForeground(Color.black);
		countItem6.setBounds(15, 11, 30, 18);
		dessertPanel.add(countItem6);

		countItem7 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem7.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem7.setBackground(SystemColor.white);
		countItem7.setForeground(Color.black);
		countItem7.setBounds(15, 33, 30, 18);
		dessertPanel.add(countItem7);

		countItem8 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem8.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem8.setBackground(SystemColor.white);
		countItem8.setForeground(Color.black);
		countItem8.setBounds(15, 55, 30, 18);
		dessertPanel.add(countItem8);

		countItem9 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem9.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem9.setBackground(SystemColor.white);
		countItem9.setForeground(Color.black);
		countItem9.setBounds(15, 77, 30, 18);
		dessertPanel.add(countItem9);

		countItem10 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem10.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem10.setBackground(SystemColor.white);
		countItem10.setForeground(Color.black);
		countItem10.setBounds(15, 99, 30, 18);
		dessertPanel.add(countItem10);

		countItem11 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem11.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem11.setBackground(SystemColor.white);
		countItem11.setForeground(Color.black);
		countItem11.setBounds(15, 11, 30, 18);
		maincoursesPanel.add(countItem11);

		countItem12 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem12.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem12.setBackground(SystemColor.white);
		countItem12.setForeground(Color.black);
		countItem12.setBounds(15, 33, 30, 18);
		maincoursesPanel.add(countItem12);

		countItem13 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem13.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem13.setBackground(SystemColor.white);
		countItem13.setForeground(Color.black);
		countItem13.setBounds(15, 55, 30, 18);
		maincoursesPanel.add(countItem13);

		countItem14 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem14.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem14.setBackground(SystemColor.white);
		countItem14.setForeground(Color.black);
		countItem14.setBounds(15, 77, 30, 18);
		maincoursesPanel.add(countItem14);

		countItem15 = new JSpinner(new SpinnerNumberModel(0, 0, 9, 1));
		countItem15.setFont(new Font("Cordia New", Font.BOLD, 18));
		countItem15.setBackground(SystemColor.white);
		countItem15.setForeground(Color.black);
		countItem15.setBounds(15, 99, 30, 18);
		maincoursesPanel.add(countItem15);

		MenutabbedPane = new JTabbedPane();
		MenutabbedPane.setBounds(40, 30, 310, 180);
		MenutabbedPane.add("Drink", drinkPanel);
		MenutabbedPane.add("Dessert", dessertPanel);
		MenutabbedPane.add("Main Courses", maincoursesPanel);
		page2Panel.add(MenutabbedPane);

		orderTable = new JTable();
		orderTable.setBounds(40, 250, 300, 100);
		orderTable.setEnabled(true);
		orderTable.setBackground(SystemColor.control);
		orderTable.setForeground(Color.black);
		orderTable.setBorder((Border) new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		orderTable.setFont(new Font("Cordia New", Font.BOLD, 18));
		orderTable.setRowHeight(20);
		page2Panel.add(orderTable);

		model = (DefaultTableModel) orderTable.getModel();
		model.addColumn("Qty.");
		model.addColumn("Item");
		model.addColumn("Amount");

		orderTable.getColumnModel().getColumn(0).setPreferredWidth(25);
		orderTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		orderTable.getColumnModel().getColumn(2).setPreferredWidth(50);
		
		totalLabel = new JLabel();
		totalLabel.setText("");
		totalLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		totalLabel.setBackground(SystemColor.black);
		totalLabel.setForeground(Color.black);
		totalLabel.setBounds(82, 370, 100, 30);
		page1Panel.add(totalLabel);
		
		emailcustomer = new JLabel();
		emailcustomer.setText("Email : " + customername);
		emailcustomer.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 17));
		emailcustomer.setBackground(SystemColor.black);
		emailcustomer.setForeground(Color.black);
		emailcustomer.setBounds( 240, 22, 100, 30);
		emailcustomer.add(totalLabel);
		
		contentPane.add(emailcustomer);


	}
	public void menufoods() {
		AddOrderButton.setBounds(145, 195, 95, 25);
		RemoveOrderButton.setBounds(80, 390, 100, 25);
		ConfirmOrderButton.setBounds(200, 390, 100, 25);
		MenuButton.setBounds(0, 0, 0, 0);
		ConfirmOrder2Button.setBounds(0, 0, 0, 0);
		CancelOrderButton.setBounds(0, 0, 0, 0);
		LogOutButton.setBounds(0, 0, 0, 0);
		menu1.setBounds(50, 7, 250, 25);
		menu2.setBounds(50, 29, 250, 25);
		menu3.setBounds(50, 51, 250, 25);
		menu4.setBounds(50, 73, 250, 25);
		menu5.setBounds(50, 95, 250, 25);
		menu6.setBounds(50, 7, 250, 25);
		menu7.setBounds(50, 29, 250, 25);
		menu8.setBounds(50, 51, 250, 25);
		menu9.setBounds(50, 73, 250, 25);
		menu10.setBounds(50, 95, 250, 25);
		menu11.setBounds(50, 7, 280, 25);
		menu12.setBounds(50, 29, 280, 25);
		menu13.setBounds(50, 51, 280, 25);
		menu14.setBounds(50, 73, 280, 25);
		menu15.setBounds(50, 95, 280, 25);
		countItem1.setBounds(15, 11, 30, 18);
		countItem2.setBounds(15, 33, 30, 18);
		countItem3.setBounds(15, 55, 30, 18);
		countItem4.setBounds(15, 77, 30, 18);
		countItem5.setBounds(15, 99, 30, 18);
		countItem6.setBounds(15, 11, 30, 18);
		countItem7.setBounds(15, 33, 30, 18);
		countItem8.setBounds(15, 55, 30, 18);
		countItem9.setBounds(15, 77, 30, 18);
		countItem10.setBounds(15, 99, 30, 18);
		countItem11.setBounds(15, 11, 30, 18);
		countItem12.setBounds(15, 33, 30, 18);
		countItem13.setBounds(15, 55, 30, 18);
		countItem14.setBounds(15, 77, 30, 18);
		countItem15.setBounds(15, 99, 30, 18);
		MenutabbedPane.setBounds(40, 30, 310, 155);
		orderTable.setBounds(40, 250, 310, 120);
		totalLabel.setBounds(82, 220, 100, 30);
		totalLabel.setText("0");
		TextLabel.setBounds(40, 220, 100, 30);
		emailcustomer.setBounds( 270, 22, 100, 30);
		emailcustomer.setText("Email : " + customername);
		
		getContentPane().add(totalLabel);
		getContentPane().add(TextLabel);
		getContentPane().add(RemoveOrderButton);
		getContentPane().add(ConfirmOrderButton);
		getContentPane().add(AddOrderButton);
		getContentPane().add(MenutabbedPane);
		getContentPane().add(orderTable);
		getContentPane().add(emailcustomer);
	}
	

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == RemoveOrderButton) {
			model = (DefaultTableModel) orderTable.getModel();
			int RemoveItem = orderTable.getSelectedRow();
			double priceSelected = Double.valueOf(orderTable.getValueAt(RemoveItem,2).toString());
			amount = amount - priceSelected;
			/*System.out.print(amount);
			if(amount == 0) {
				System.out.print("0");
			}*/
			model.removeRow(RemoveItem);
			totalLabel.setText(String.valueOf(amount));
		} else if (event.getSource() == ConfirmOrderButton) {
			try {
				e = getElement();
				obj = e;
				queue.enqueue(obj);
				//myOrder(e);
				myOrder2(e);
				home();
				amount = 0;
				amount1 = 0;
				amount2 = 0;
				amount3 = 0;
				amount4 = 0; 
				amount5 = 0;
				amount6 = 0;
				amount7 = 0;
				amount8 = 0;
				amount9 = 0;
				amount10 = 0;
				amount11 = 0;
				amount12 = 0;
				amount13 = 0;
				amount14 = 0;
				amount15 = 0;
				
			} catch (Exception er) {
				er.printStackTrace();
			}
		} else if (event.getSource() == AddOrderButton) {
			try {
				model = (DefaultTableModel) orderTable.getModel();
				model.setRowCount(0);
				Amount();
				totalLabel.setText(String.valueOf(amount));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "not order");
			}
		} else if (event.getSource() == MenuButton) {
			menufoods();
		} else if (event.getSource() == ConfirmOrder2Button) {
			try {
				obj = queue.dequeue();
				e = (Order)obj;
				myOrder(e);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No Order");
				home();
			}

		} else if (event.getSource() == CancelOrderButton) {
			try {
				queue.clear();
				JOptionPane.showMessageDialog(null, "Order canceled successfully.");
				//myOrder(e);
			} catch (Exception e){
				JOptionPane.showMessageDialog(null, "No Order");
			}
			
		} else if (event.getSource() == LogOutButton) {
			test();
		}

	}

	private void home() {
		model = (DefaultTableModel) orderTable.getModel();
		model.setRowCount(0);
		getContentPane().add(MenuButton);
		getContentPane().add(ConfirmOrder2Button);
		getContentPane().add(CancelOrderButton);
		getContentPane().add(LogOutButton);
		getContentPane().add(emailcustomer);
		
		TextLabel.setBounds(0, 0, 0, 0);
		totalLabel.setBounds(0, 0, 0, 0);
		MenuButton.setBounds(110, 95, 165, 40);
		ConfirmOrder2Button.setBounds(110, 155, 165, 40);
		CancelOrderButton.setBounds(110, 215, 165, 40);
		LogOutButton.setBounds(110, 275, 165, 40);
		RemoveOrderButton.setBounds(0, 0, 0, 0);
		ConfirmOrderButton.setBounds(0, 0, 0, 0);
		AddOrderButton.setBounds(0, 0, 0, 0);
		menu1.setBounds(0, 0, 0, 0);
		menu2.setBounds(0, 0, 0, 0);
		menu3.setBounds(0, 0, 0, 0);
		menu4.setBounds(0, 0, 0, 0);
		menu5.setBounds(0, 0, 0, 0);
		menu6.setBounds(0, 0, 0, 0);
		menu7.setBounds(0, 0, 0, 0);
		menu8.setBounds(0, 0, 0, 0);
		menu9.setBounds(0, 0, 0, 0);
		menu10.setBounds(0, 0, 0, 0);
		menu11.setBounds(0, 0, 0, 0);
		menu12.setBounds(0, 0, 0, 0);
		menu13.setBounds(0, 0, 0, 0);
		menu14.setBounds(0, 0, 0, 0);
		menu15.setBounds(0, 0, 0, 0);
		countItem1.setBounds(0, 0, 0, 0);
		countItem2.setBounds(0, 0, 0, 0);
		countItem3.setBounds(0, 0, 0, 0);
		countItem4.setBounds(0, 0, 0, 0);
		countItem5.setBounds(0, 0, 0, 0);
		countItem6.setBounds(0, 0, 0, 0);
		countItem7.setBounds(0, 0, 0, 0);
		countItem8.setBounds(0, 0, 0, 0);
		countItem9.setBounds(0, 0, 0, 0);
		countItem10.setBounds(0, 0, 0, 0);
		countItem11.setBounds(0, 0, 0, 0);
		countItem12.setBounds(0, 0, 0, 0);
		countItem13.setBounds(0, 0, 0, 0);
		countItem14.setBounds(0, 0, 0, 0);
		countItem15.setBounds(0, 0, 0, 0);
		MenutabbedPane.setBounds(0, 0, 0, 0);
		orderTable.setBounds(0, 0, 0, 0);
		emailcustomer.setBounds( 240, 22, 100, 30);
		emailcustomer.setText("Email : " + customername);

	}

	public void Amount() throws Exception {
		if ((int) countItem1.getValue() > 0) {
			amount1 = priceDrinks[0] * (int) countItem1.getValue();
			model.addRow(new Object[] { "     " + countItem1.getValue(), " " + Drinks[0], "      " + amount1 });
		}
		if ((int) countItem2.getValue() > 0) {
			amount2 = priceDrinks[1] * (int) countItem2.getValue();
			model.addRow(new Object[] { "     " + countItem2.getValue(), " " + Drinks[1], "      " + amount2 });
		}
		if ((int) countItem3.getValue() > 0) {
			amount3 = priceDrinks[2] * (int) countItem3.getValue();
			model.addRow(new Object[] { "     " + countItem3.getValue(), " " + Drinks[2], "      " + amount3 });
		}
		if ((int) countItem4.getValue() > 0) {
			amount4 = priceDrinks[3] * (int) countItem4.getValue();
			model.addRow(new Object[] { "     " + countItem4.getValue(), " " + Drinks[3], "      " + amount4 });
		}
		if ((int) countItem5.getValue() > 0) {
			amount5 = priceDrinks[4] * (int) countItem5.getValue();
			model.addRow(new Object[] { "     " + countItem5.getValue(), " " + Drinks[4], "      " + amount5 });
		}
		if ((int) countItem6.getValue() > 0) {
			amount6 = priceDesserts[0] * (int) countItem6.getValue();
			model.addRow(new Object[] { "     " + countItem6.getValue(), " " + Desserts[0], "      " + amount6 });
		}
		if ((int) countItem7.getValue() > 0) {
			amount7 = priceDesserts[1] * (int) countItem7.getValue();
			model.addRow(new Object[] { "     " + countItem7.getValue(), " " + Desserts[1], "      " + amount7 });
		}
		if ((int) countItem8.getValue() > 0) {
			amount8 = priceDesserts[2] * (int) countItem8.getValue();
			model.addRow(new Object[] { "     " + countItem8.getValue(), " " + Desserts[2], "      " + amount8 });
		}
		if ((int) countItem9.getValue() > 0) {
			amount9 = priceDesserts[3] * (int) countItem9.getValue();
			model.addRow(new Object[] { "     " + countItem9.getValue(), " " + Desserts[3], "      " + amount9 });
		}
		if ((int) countItem10.getValue() > 0) {
			amount10 = priceDesserts[4] * (int) countItem10.getValue();
			model.addRow(new Object[] { "     " + countItem10.getValue(), " " + Desserts[4], "      " + amount10 });
		}
		if ((int) countItem11.getValue() > 0) {
			amount11 = priceMainCoursess[0] * (int) countItem11.getValue();
			model.addRow(new Object[] { "     " + countItem11.getValue(), " " + MainCoursess[0], "      " + amount11 });
		}
		if ((int) countItem12.getValue() > 0) {
			amount12 = priceMainCoursess[1] * (int) countItem12.getValue();
			model.addRow(new Object[] { "     " + countItem12.getValue(), " " + MainCoursess[1], "      " + amount12 });
		}
		if ((int) countItem13.getValue() > 0) {
			amount13 = priceMainCoursess[2] * (int) countItem13.getValue();
			model.addRow(new Object[] { "     " + countItem13.getValue(), " " + MainCoursess[2], "      " + amount13 });
		}
		if ((int) countItem14.getValue() > 0) {
			amount14 = priceMainCoursess[3] * (int) countItem14.getValue();
			model.addRow(new Object[] { "     " + countItem14.getValue(), " " + MainCoursess[3], "      " + amount14 });
		}
		if ((int) countItem15.getValue() > 0) {
			amount15 = priceMainCoursess[4] * (int) countItem15.getValue();
			model.addRow(new Object[] { "     " + countItem15.getValue(), " " + MainCoursess[4], "      " + amount15 });
		}
		amount = amount1 + amount2 + amount3 + amount4 + amount5 + amount6 + amount7 + amount8 + amount9 + amount10
				+ amount11 + amount12 + amount13 + amount14 + amount15;
		System.out.print(amount);
	}

	public void test() {
		FoodDelivery test = new FoodDelivery();
		test.setVisible(true);
	}

	public void myOrder2(Order e) {
		final ImageIcon icon1 = new ImageIcon(Foods.class.getResource("/icon/order3.png"));
		String [] options = {"Home"};
		if(e!=null) {
			JOptionPane.showOptionDialog(null,"   Queue No. : " + queue.length() + "\n   Email : "  + e.getEmail() +  
					"\n   Order : " + "\n\n    " + e.getQty() +"\n\n   Total : "+ amount + "\n",
					"Confirm Order",JOptionPane.OK_OPTION,JOptionPane.PLAIN_MESSAGE,icon1,options,"home");
		
		}
		
	}
	public void  myOrder(Order e) {	
			final ImageIcon icon = new ImageIcon(Foods.class.getResource("/icon/confirm.png"));
			String [] options = {"Confirm"};
			if(e!=null) {
				JOptionPane.showOptionDialog(null,"\n   Email : "  + e.getEmail() +  "\n   Order : " + "\n\n    " 
			+ e.getQty() + "\n\n","Confirm Order",JOptionPane.OK_OPTION,JOptionPane.PLAIN_MESSAGE,icon,options,"Confirm");
			System.out.print("\n Email : "  + e.getEmail() + "\n Order : " + e.getQty()); 
		}
	}
	
	public static Order getElement() {
		Order Corder;
		String Email = customername;
		ArrayList<String> qtyC = new ArrayList<String>();
		model = (DefaultTableModel) orderTable.getModel();
		int RowAddItem = orderTable.getRowCount();

		for (int i = 0;i < RowAddItem ; i++) {
			for (int j = 0; j < 3; j++) {
				qtyC.add(String.valueOf(orderTable.getValueAt(i,j).toString()));
				
			}
			qtyC.add("             ");
			qtyC.add("\n   ");
		}
		Corder = new Order(customername,qtyC);
		Corder.setOrder(Email, qtyC);
		//System.out.println("\n Email : " + Corder.getEmail() + "\n Order : " + Corder.getQty());
		return Corder;
		
	}

}