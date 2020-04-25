package com;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;

public class ConnectionDB {

	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				SignUp signUp = new SignUp();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}

}
