package com.Employee.DataRequest;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Employee.DBCon.DBConnection;

public class DBEmployees {
	public void displayDB() {
		
		String query = "SELECT * FROM employees";
		System.out.println();
		
		Statement connect = DBConnection.getConnectivity();
		
		try{
			ResultSet rs = connect.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String position = rs.getString("position");
				double salary = rs.getDouble("salary");
				
				System.out.println("ID : "+id+", Name : "+name+", Position : "+position+", Salary : "+salary);
				System.out.println("--------------------------------------------------------------------------------------------------");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
