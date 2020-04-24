package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;

public class ConnectionDB {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(123465);
		Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "system", "Oracle123");
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM my_table");
        while (rs.next()){
            System.out.println(rs.getString(1) +  " " + rs.getString(2) + " " + rs.getLong(3) + " " + rs.getLong(4));
        }
        
        rs.close();
        st.close();
        con.close();
        
	}

}
