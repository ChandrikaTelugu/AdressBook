package com.bvrit.addressbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	Connection conn;
	public Connection getConnection() throws ClassNotFoundException
	{
		String url = "jdbc:mysql://localhost:3306/addressbookdb";
		String username = "root";
		String password = "123456";
		Connection conn = null;
		try {
			//load Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			//create connection
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("successfully connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
