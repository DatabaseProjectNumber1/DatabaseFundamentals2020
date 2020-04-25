package com;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

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

public class LogIn {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	Connection connection;
	PreparedStatement pst;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LogIn window = new LogIn();
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
	public LogIn() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
	    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
	    frame.setLocation(x, y);
	    
	    frame.setVisible(true);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(59, 82, 127, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(59, 138, 127, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(206, 87, 127, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(281, 202, 110, 30);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Log In");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(36, 11, 160, 50);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(206, 143, 127, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Haven't registered yet? ");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(91, 258, 148, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sign Up");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(240, 258, 48, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
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
				SignUp signUp = new SignUp();
				
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("oracle.jdbc.OracleDriver");
			        connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "system", "Oracle123");
			        
			        String query = "SELECT * FROM sign_up WHERE username = ? AND secret_word = ?";
			        pst = connection.prepareStatement(query);
			        pst.setString(1, textField.getText());
			        pst.setString(2, String.valueOf(passwordField.getPassword()));
			        ResultSet rs = pst.executeQuery();
			        
			        if (rs.next()) {
			        	JOptionPane.showMessageDialog(null, "Right username and password.");
			        	frame.dispose();
			        	MedicalRegistration medicalRegistration = new MedicalRegistration();
			        } else {
			        	JOptionPane.showMessageDialog(null, "Wrong username or password.");
			        	textField.setText("");
			        	passwordField.setText("");
			        }
			        
			        connection.close();
					
					
				} catch(Exception ex) {
					System.out.println("ERROR");
				}
			}
		});
	}
}
