package com.bvrit.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.bvrit.addressbook.dao.ConnectionDAO;

public class JDBCApp {
	public static void main(String args[]) {
		String url = "jdbc:mysql://localhost:3306/addressbookdb";
		String username = "root";
		String password = "password";
		Connection conn = null;
		Statement st = null;
		ConnectionDAO cd = new ConnectionDAO();
		String query = "insert into user values('tom','jerry')";
		try {
			
			cd.getConnection();
			//load driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver loaded");
			//create connection
			conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);
			//create statement
			st = conn.createStatement();
			System.out.println(st);
			//execute query
			int result = st.executeUpdate(query);
			if(result >= 1)
			{
				System.out.println("record inserted");
			}
			else
			{
				System.out.println("record not inserted");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		finally
		{
			try {
				if(conn != null)
				{
					conn.close();
				}
				if(st != null)
				{
					st.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}

	}
}
