package swu.cp241.FoodDelivery;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

import javax.swing.*;

public class FoodDelivery extends JFrame implements ActionListener {

	private String nameC, emailC, passwordC, cfpassC, telC, addressC;
	//QueueADT queue;
	String Email = "";
	String pass = "";
	String line;
	private JPanel fooddeliveryPanel;
	private JButton LoginButton, RegisterButton, buttonButton;
	private JLabel  EmailLabel, PassLabel, CfPassLabel, AddressLabel, TelLabel, NameLabel, iconLabel, RegisterLabel;
	private static JTextField emailTextId;
	private static JTextField passTextId;
	private static JTextField cfpassTextId;
	private static JTextField nameTextId;
	private static JTextField telTextId;
	private JTextField emailTextIdC;
	private JTextField passTextIdC;
	private static JTextArea AddressArea;

	public static void main(String[] args) throws Exception {
		FoodDelivery test = new FoodDelivery();
		test.setVisible(true);
	}

	static class Customer {
		String nameC, emailC, passwordC, cfpassC, telC, addressC;

		public Customer(String nameC, String emailC, String passwordC, String cfpassC, String telC, String addressC) {
			this.nameC = nameC;
			this.emailC = emailC;
			this.passwordC = passwordC;
			this.cfpassC = cfpassC;
			this.telC = telC;
			this.addressC = addressC;

		}
	}

	public FoodDelivery() {
		setTitle("Food Delivery");
		setBounds(440, 100, 400, 470);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setBackground(SystemColor.control);
		Container contentPane;
		contentPane = getContentPane();
		contentPane.setLayout(null);
		fooddeliveryPanel = new JPanel();

		fooddeliveryPanel.setLayout(null);
		fooddeliveryPanel.setBackground(SystemColor.control);

		LoginButton = new JButton();
		LoginButton.setText("Login");
		LoginButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		LoginButton.setBackground(SystemColor.black);
		LoginButton.setForeground(Color.white);
		LoginButton.setBounds(130, 330, 125, 30);
		fooddeliveryPanel.add(LoginButton);
		LoginButton.addActionListener(this);

		RegisterButton = new JButton();
		RegisterButton.setText("Register");
		RegisterButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		RegisterButton.setBackground(SystemColor.black);
		RegisterButton.setForeground(Color.white);
		RegisterButton.setBounds(250, 15, 125, 30);
		fooddeliveryPanel.add(RegisterButton);
		RegisterButton.addActionListener(this);

		buttonButton = new JButton();
		buttonButton.setText("");
		buttonButton.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		buttonButton.setBackground(SystemColor.black);
		buttonButton.setForeground(Color.white);
		fooddeliveryPanel.add(buttonButton);
		buttonButton.addActionListener(this);

		NameLabel = new JLabel();
		NameLabel.setText("");
		NameLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		NameLabel.setBackground(SystemColor.black);
		NameLabel.setForeground(Color.black);
		fooddeliveryPanel.add(NameLabel);

		nameTextId = new JTextField(null);
		nameTextId.setFont(new Font("Cordia New", Font.BOLD, 20));
		nameTextId.setBackground(SystemColor.white);
		nameTextId.setForeground(Color.black);
		fooddeliveryPanel.add(nameTextId);

		EmailLabel = new JLabel();
		EmailLabel.setText("Email : ");
		EmailLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		EmailLabel.setBackground(SystemColor.black);
		EmailLabel.setForeground(Color.black);
		EmailLabel.setBounds(60, 250, 100, 25);
		fooddeliveryPanel.add(EmailLabel);

		emailTextId = new JTextField(null);
		emailTextId.setFont(new Font("Cordia New", Font.BOLD, 20));
		emailTextId.setBackground(SystemColor.white);
		emailTextId.setForeground(Color.black);
		fooddeliveryPanel.add(emailTextId);

		PassLabel = new JLabel();
		PassLabel.setText("Password :");
		PassLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		PassLabel.setBackground(SystemColor.black);
		PassLabel.setForeground(Color.black);
		PassLabel.setBounds(60, 290, 100, 25);
		fooddeliveryPanel.add(PassLabel);
		
		fooddeliveryPanel.setLayout(null);
		iconLabel = new JLabel("");
		iconLabel.setBounds(80,65,310,160);
		iconLabel.setIcon(new ImageIcon(FoodDelivery.class.getResource("/icon/food3.png")));
		fooddeliveryPanel.add(iconLabel);

		passTextId = new JTextField(null);
		passTextId.setFont(new Font("Cordia New", Font.BOLD, 20));
		passTextId.setBackground(SystemColor.white);
		passTextId.setForeground(Color.black);
		fooddeliveryPanel.add(passTextId);

		CfPassLabel = new JLabel();
		CfPassLabel.setText("");
		CfPassLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		CfPassLabel.setBackground(SystemColor.black);
		CfPassLabel.setForeground(Color.BLACK);
		fooddeliveryPanel.add(CfPassLabel);

		cfpassTextId = new JTextField(null);
		cfpassTextId.setFont(new Font("Cordia New", Font.BOLD, 20));
		cfpassTextId.setBackground(SystemColor.white);
		cfpassTextId.setForeground(Color.black);
		fooddeliveryPanel.add(cfpassTextId);

		TelLabel = new JLabel();
		TelLabel.setText("");
		TelLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		TelLabel.setBackground(SystemColor.white);
		TelLabel.setForeground(Color.BLACK);
		fooddeliveryPanel.add(TelLabel);

		telTextId = new JTextField(null);
		telTextId.setFont(new Font("Cordia New", Font.BOLD, 20));
		telTextId.setBackground(SystemColor.white);
		telTextId.setForeground(Color.black);
		fooddeliveryPanel.add(telTextId);

		emailTextIdC = new JTextField(null);
		emailTextIdC.setFont(new Font("Cordia New", Font.BOLD, 20));
		emailTextIdC.setBackground(SystemColor.white);
		emailTextIdC.setForeground(Color.black);
		emailTextIdC.setBounds(120, 250, 200, 25);
		fooddeliveryPanel.add(emailTextIdC);

		passTextIdC = new JTextField(null);
		passTextIdC.setFont(new Font("Cordia New", Font.BOLD, 20));
		passTextIdC.setBackground(SystemColor.white);
		passTextIdC.setForeground(Color.black);
		passTextIdC.setBounds(150, 290, 170, 25);
		fooddeliveryPanel.add(passTextIdC);

		AddressLabel = new JLabel();
		AddressLabel.setText("");
		AddressLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
		AddressLabel.setBackground(SystemColor.black);
		AddressLabel.setForeground(Color.black);
		fooddeliveryPanel.add(AddressLabel);

		AddressArea = new JTextArea();
		AddressArea.setFont(new Font("Cordia New", Font.BOLD, 20));
		AddressArea.setBackground(SystemColor.white);
		AddressArea.setForeground(Color.black);
		fooddeliveryPanel.add(AddressArea);
		
		RegisterLabel = new JLabel();
		RegisterLabel.setText("Register");
		RegisterLabel.setBounds(0, 0, 0, 0);
		RegisterLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 35));
		RegisterLabel.setBackground(SystemColor.black);
		RegisterLabel.setForeground(Color.black);
		fooddeliveryPanel.add(RegisterLabel);

		contentPane.add(LoginButton);
		contentPane.add(RegisterButton);
		contentPane.add(EmailLabel);
		contentPane.add(PassLabel);
		contentPane.add(emailTextIdC);
		contentPane.add(passTextIdC);
		contentPane.add(iconLabel);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == LoginButton) {
			if ((emailTextIdC.getText() == null || emailTextIdC.getText().trim().equals(""))
					&& (passTextIdC.getText() == null || passTextIdC.getText().trim().equals(""))) {
				JOptionPane.showMessageDialog(null, "Please input Email and Password");
			} else {
				try {
					Email = emailTextIdC.getText();
					ReadCustomer();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else if (event.getSource() == RegisterButton) {
			registerpage();
		} else if (event.getSource() instanceof JButton) {
			String buttonButton = ((JButton) event.getSource()).getText();
			if (buttonButton == "Submit") {
				if ((nameTextId.getText() == null || nameTextId.getText().trim().equals(""))
						&& (emailTextId.getText() == null || emailTextId.getText().trim().equals(""))
						&& (passTextId.getText() == null || passTextId.getText().trim().equals(""))
						&& (cfpassTextId.getText() == null || cfpassTextId.getText().trim().equals(""))
						&& (telTextId.getText() == null || telTextId.getText().trim().equals(""))
						&& (AddressArea.getText() == null || AddressArea.getText().trim().equals(""))) {
					try {
						JOptionPane.showMessageDialog(null, "Please complete the information.");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else {
					if (passTextId.getText().equals(cfpassTextId.getText())) {
						writeCustomer(nameC, emailC, passwordC, cfpassC, telC, addressC);
						JOptionPane.showMessageDialog(null, "registration completed");
						Login();
					} else
						JOptionPane.showMessageDialog(null, "Password not equal");
				}
			}

		}

	}

	private void home() {
		Foods home = new Foods(Email);
		home.setVisible(true);

	}

	private void Login() {
		getContentPane().add(EmailLabel);
		getContentPane().add(PassLabel);
		getContentPane().add(CfPassLabel);
		getContentPane().add(emailTextIdC);
		getContentPane().add(passTextIdC);
		getContentPane().add(cfpassTextId);
		getContentPane().add(iconLabel);

		NameLabel.setBounds(0, 0, 0, 0);
		nameTextId.setBounds(0, 0, 0, 0);

		EmailLabel.setBounds(60, 250, 100, 25);
		emailTextId.setBounds(0, 0, 0, 0);
		emailTextIdC.setBounds(120, 250, 200, 25);

		PassLabel.setBounds(60, 290, 100, 25);
		passTextId.setBounds(0, 0, 0, 0);
		passTextIdC.setBounds(150, 290, 170, 25);

		CfPassLabel.setBounds(0, 0, 0, 0);
		cfpassTextId.setBounds(0, 0, 0, 0);

		TelLabel.setBounds(0, 0, 0, 0);
		telTextId.setBounds(0, 0, 0, 0);

		AddressLabel.setBounds(0, 0, 0, 0);
		AddressArea.setBounds(0, 0, 0, 0);

		iconLabel.setBounds(80,65,310,160);
		LoginButton.setBounds(130, 330, 125, 30);
		RegisterButton.setBounds(250, 15, 125, 30);
		buttonButton.setBounds(0, 0, 0, 0);
		RegisterLabel.setBounds(0, 0, 0, 0);
		
	}

	private void registerpage() {
		getContentPane().add(NameLabel);
		getContentPane().add(EmailLabel);
		getContentPane().add(PassLabel);
		getContentPane().add(CfPassLabel);
		getContentPane().add(TelLabel);
		getContentPane().add(AddressLabel);
		getContentPane().add(nameTextId);
		getContentPane().add(emailTextId);
		getContentPane().add(passTextId);
		getContentPane().add(cfpassTextId);
		getContentPane().add(telTextId);
		getContentPane().add(AddressArea);
		getContentPane().add(buttonButton);
		getContentPane().add(RegisterLabel);

		buttonButton.setText("Submit");

		NameLabel.setText("Name : ");
		NameLabel.setBounds(60, 80, 100, 25);
		nameTextId.setBounds(120, 80, 215, 25);

		EmailLabel.setText("Email : ");
		EmailLabel.setBounds(60, 110, 100, 25);
		emailTextId.setBounds(120, 110, 215, 25);
		emailTextIdC.setBounds(0, 0, 0, 0);

		PassLabel.setText("Password : ");
		PassLabel.setBounds(60, 140, 100, 25);
		passTextId.setBounds(150, 140, 185, 25);
		passTextIdC.setBounds(0, 0, 0, 0);

		CfPassLabel.setText("Confirm Password : ");
		CfPassLabel.setBounds(60, 170, 150, 25);
		cfpassTextId.setBounds(215, 170, 120, 25);

		TelLabel.setText("Tel : ");
		TelLabel.setBounds(60, 200, 100, 25);
		telTextId.setBounds(100, 200, 235, 25);

		AddressLabel.setText("Address : ");
		AddressLabel.setBounds(60, 230, 240, 25);
		AddressArea.setBounds(140, 230, 195, 50);

		iconLabel.setBounds(0,0,0,0);
		LoginButton.setBounds(0, 0, 0, 0);
		RegisterButton.setBounds(0, 0, 0, 0);
		buttonButton.setBounds(130, 320, 125, 30);
		RegisterLabel.setBounds(140, 15, 125, 40);
		
	}

	public void writeCustomer(String nameC, String emailC, String passwordC, String cfpassC, String telC, String addC) {
		try {
			FileWriter file_nameCustomer = new FileWriter("ame.txt", true);
			file_nameCustomer.write(nameTextId.getText());
			file_nameCustomer.write("\t");
			file_nameCustomer.write(emailTextId.getText());
			file_nameCustomer.write("\t");
			file_nameCustomer.write(passTextId.getText());
			file_nameCustomer.write("\t");
			file_nameCustomer.write(cfpassTextId.getText());
			file_nameCustomer.write("\t");
			file_nameCustomer.write(telTextId.getText());
			file_nameCustomer.write("\t");
			file_nameCustomer.write(AddressArea.getText());
			file_nameCustomer.write(System.getProperty("line.separator"));
			file_nameCustomer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ReadCustomer() {
		try (BufferedReader readcustomer = new BufferedReader(new FileReader("ame.txt"))) {
			ArrayList<Customer> ListCustomer = new ArrayList<Customer>();
			while ((line = readcustomer.readLine()) != null) {
				// System.out.println(line);
				String[] arr = line.split("\t");
				nameC = arr[0];
				emailC = arr[1];
				passwordC = arr[2];
				cfpassC = arr[3];
				telC = arr[4];
				addressC = arr[5];
				ListCustomer.add(new Customer(nameC, emailC, passwordC, cfpassC, telC, addressC));
			}
			int index = 0;
			readcustomer.close();
			pass = passTextIdC.getText();
			for (int i = 0; i < ListCustomer.size(); i++) {
				if (ListCustomer.get(i).emailC.equals(Email)) {
					index++;
					if (ListCustomer.get(i).passwordC.equals(pass)) {
						System.out.println(ListCustomer.get(i).emailC + " " + ListCustomer.get(i).passwordC);
						home();
					} else {
						JOptionPane.showMessageDialog(null, "Password not equals");
					}
				}
			}
			if (index <= 0) {
				JOptionPane.showMessageDialog(null, "You are not registered");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}