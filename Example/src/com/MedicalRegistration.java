package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
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

public class MedicalRegistration {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	
	
	Connection connection1;
	PreparedStatement insert;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicalRegistration window = new MedicalRegistration();
					
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
				    int x = (int) ((dimension.getWidth() - window.frame.getWidth()) / 2);
				    int y = (int) ((dimension.getHeight() - window.frame.getHeight()) / 2);
				    window.frame.setLocation(x, y);
					
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MedicalRegistration() {
		initialize();
		tableUpdate();
	}
	
	private void tableUpdate() {
		int numberOfRows;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
	        connection1 = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "system", "Oracle123");
	        
	        insert = connection1.prepareStatement("SELECT * FROM my_table");
	        ResultSet rs = insert.executeQuery();
	        ResultSetMetaData Rss = rs.getMetaData();
	        numberOfRows = Rss.getColumnCount();
	        
	        DefaultTableModel Df = (DefaultTableModel) table.getModel();
	        Df.setRowCount(0);
	        
	        while (rs.next()) {
	        	Vector v2 = new Vector();
	        	
	        	for (int a = 1; a <= numberOfRows; a++) {
	        		v2.add(rs.getString("last_name"));
	        		v2.add(rs.getString("first_name"));
	        		v2.add(rs.getLong("born"));
	        		v2.add(rs.getLong("id_number"));
	        	}
	        	Df.addRow(v2);
	        	
	        }
	        
		} catch(Exception ex) {
			System.out.println("ERROR");
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 856, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Medical Registration");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setBounds(91, 11, 369, 30);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 105, 323, 284);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(29, 49, 80, 14);
		panel.add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(29, 87, 80, 14);
		panel.add(lblFirstName);
		
		JLabel lblBorn = new JLabel("Born");
		lblBorn.setBounds(29, 127, 80, 14);
		panel.add(lblBorn);
		
		JLabel lblNewLabel_2 = new JLabel("Id");
		lblNewLabel_2.setBounds(29, 171, 80, 14);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(139, 46, 120, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 84, 120, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(139, 124, 120, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(139, 168, 120, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(29, 232, 84, 23);
		panel.add(btnNewButton);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(123, 232, 84, 23);
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(213, 232, 84, 23);
		panel.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("Medical Registration");
		lblNewLabel_1.setBounds(10, 80, 139, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(358, 105, 442, 284);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel Df = (DefaultTableModel) table.getModel();
				int selectedRow = table.getSelectedRow();
				
				textField.setText(Df.getValueAt(selectedRow, 0).toString());
		        textField_1.setText(Df.getValueAt(selectedRow, 1).toString());
		        textField_2.setText(Df.getValueAt(selectedRow, 2).toString());
		        textField_3.setText(Df.getValueAt(selectedRow, 3).toString());
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Last Name", "First Name", "Born Date", "ID"
			}
		));
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lastName = textField.getText();
				String firstName = textField_1.getText();
				String bornDate = textField_2.getText();
				String id = textField_3.getText();
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
			        connection1 = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "system", "Oracle123");
			        
			        insert = connection1.prepareStatement("INSERT INTO my_table "
			        		+ "VALUES(?,?,?,?)");
			        insert.setString(1, lastName);
			        insert.setString(2, firstName);
			        insert.setLong(3, Long.parseLong(bornDate));
			        insert.setLong(4, Long.parseLong(id));
			        insert.executeUpdate();
			        
			        JOptionPane.showMessageDialog(frame, "Record Added");
			        tableUpdate();
			        
			        textField.setText("");
			        textField_1.setText("");
			        textField_2.setText("");
			        textField_3.setText("");
			        
			        
				} catch(Exception ex) {
					System.out.println("ERROR");
				}
			}
		});
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DefaultTableModel Df = (DefaultTableModel) table.getModel();
				int selectedRow = table.getSelectedRow();
				
				try {
					
					int idInDb = Integer.parseInt(Df.getValueAt(selectedRow, 3).toString());
					String lastName = textField.getText();
					String firstName = textField_1.getText();
					String bornDate = textField_2.getText();
					String id = textField_3.getText();
					
					
					Class.forName("oracle.jdbc.OracleDriver");
			        connection1 = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "system", "Oracle123");
			        
			        
			        insert = connection1.prepareStatement("UPDATE my_table SET "
			        		+ "last_name = ?,"
			        		+ "first_name = ?,"
			        		+ "born = ?,"
			        		+ "id_number = ?"
			        		+ " WHERE id_number = ?");
			        insert.setString(1, lastName);
			        insert.setString(2, firstName);
			        insert.setLong(3, Long.parseLong(bornDate));
			        insert.setLong(4, Long.parseLong(id));
			        insert.setLong(5, idInDb);
			        insert.executeUpdate();
			        
			        JOptionPane.showMessageDialog(frame, "Record Update");
			        tableUpdate();
			        
			        textField.setText("");
			        textField_1.setText("");
			        textField_2.setText("");
			        textField_3.setText("");
			        
				} catch(Exception ex) {
					System.out.println("ERROR");
				}
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel Df = (DefaultTableModel) table.getModel();
				int selectedRow = table.getSelectedRow();
				
				try {
			        
			        int dialogResult = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Warning", JOptionPane.YES_NO_OPTION);
			        if (dialogResult == JOptionPane.YES_OPTION) {
			        	int idInDb = Integer.parseInt(Df.getValueAt(selectedRow, 3).toString());
						
						Class.forName("oracle.jdbc.OracleDriver");
				        connection1 = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "system", "Oracle123");
				        
				        insert = connection1.prepareStatement("DELETE FROM my_table WHERE id_number = ?");
				        insert.setInt(1, idInDb);
				        insert.executeUpdate();
				        
				        JOptionPane.showMessageDialog(frame, "Deleted");
				        tableUpdate();
			        }
			        
			        
				} catch(Exception ex) {
					System.out.println("ERROR");
				}
			}
				
		});
		
	}
}
