package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Dimension;

public class SignUp {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	
	
	Connection connection;
	PreparedStatement pst;
	
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignUp window = new SignUp();
//					
//					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//				    int x = (int) ((dimension.getWidth() - window.frame.getWidth()) / 2);
//				    int y = (int) ((dimension.getHeight() - window.frame.getHeight()) / 2);
//				    window.frame.setLocation(x, y);
//					
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 495, 676);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
//		frame = new JFrame();
//		frame.setResizable(false);
//		frame.setBounds(100, 100, 495, 676);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 202, 66);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(37, 108, 100, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(37, 162, 100, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblAddress = new JLabel("Phone");
		lblAddress.setBounds(37, 216, 100, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(37, 278, 100, 14);
		frame.getContentPane().add(lblGender);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(37, 340, 48, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(37, 405, 100, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(37, 463, 100, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(131, 527, 190, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(214, 105, 160, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(214, 159, 160, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(214, 213, 160, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(214, 337, 160, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(214, 402, 160, 20);
		frame.getContentPane().add(textField_4);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(214, 274, 78, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(296, 274, 78, 23);
		frame.getContentPane().add(rdbtnFemale);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(214, 460, 160, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Already registered?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(137, 599, 111, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Log In");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_4.setForeground(Color.PINK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_4.setForeground(Color.RED);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				LogIn logIn = new LogIn();
				
			}
		});
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(258, 606, 48, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnFemale.setSelected(false);
			}
		});
		rdbtnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton.setSelected(false);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Class.forName("oracle.jdbc.OracleDriver");
			        connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "system", "Oracle123");
			        
			        String query = "INSERT INTO sign_up VALUES(?,?,?,?,?,?,?)";
			        pst = connection.prepareStatement(query);
			        pst.setString(1, textField.getText());
			        pst.setString(2, textField_1.getText());
			        pst.setString(3, textField_2.getText());
			        String genderString = rdbtnNewRadioButton.isSelected() ? "Male" : "Female";
			        pst.setString(4, genderString);
			        pst.setString(5, textField_3.getText());
			        pst.setString(6, textField_4.getText());
			        pst.setString(7, String.valueOf(passwordField.getPassword()));
			        pst.executeUpdate();
			        JOptionPane.showMessageDialog(null, "REGISTERED SUCCESFULLY");
			        
			        frame.dispose();
			        LogIn logIn = new LogIn();
			        
			        textField.setText("");
			        textField_1.setText("");
			        textField_2.setText("");
			        textField_3.setText("");
			        textField_4.setText("");
			        rdbtnFemale.setSelected(false);
			        rdbtnNewRadioButton.setSelected(false);
			        passwordField.setText("");
			        
				} catch (Exception ex) {
					System.out.println("ERROR");
				}
			}
		});
	}
}
