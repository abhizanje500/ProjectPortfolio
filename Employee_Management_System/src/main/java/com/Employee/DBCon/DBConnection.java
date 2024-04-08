package com.Employee.DBCon;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Statement getConnectivity() {
		
		Statement stmt = null;
		
		String url = "jdbc:mysql://localhost:3306/emplyee_management_system";
		String userName = "root";
		String password = "Stunning@467";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, userName, password);
		stmt = con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return stmt;
	}
}
