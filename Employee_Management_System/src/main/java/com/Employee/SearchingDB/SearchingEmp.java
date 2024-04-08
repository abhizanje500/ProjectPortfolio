package com.Employee.SearchingDB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import com.Employee.DBCon.DBConnection;
import com.Employee.ExceptionList.WrongInputChoiceException;
import com.Employee.PrimeClass.Employee;

public class SearchingEmp {
	public void searchEmployee() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Employee emp = new Employee();
		
		System.out.println();
		System.out.println("Chose how you want to search emplyee");
		System.out.println("Press 1 : to Search Employee detains by ID");
		System.out.println("Press 2 : to Search Employee detains by Name");
		
		int choice = -1;
		
		try {
			choice = Integer.parseInt(br.readLine());
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		if(choice ==1) {
			try {
				System.out.println("Enter ID of Employee you want to search");
				emp.setID(Integer.parseInt(br.readLine()));
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			String query = "SELECT * FROM employees WHERE id = '"+emp.getID()+"';";
			
			Statement connect = DBConnection.getConnectivity();
			try {
				ResultSet rs = connect.executeQuery(query);
				
				while(rs.next()){
					
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String position = rs.getString("position");
					double salary = rs.getDouble("salary");
					
					System.out.println("-------------------------------------------");
					System.out.println("ID : "+ id);
					System.out.println("Name : "+name);
					System.out.println("Position : "+position);
					System.out.println("Salary : "+salary);
					System.out.println("-------------------------------------------");
					
					System.out.println();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}else if(choice==2) {
			try {
				System.out.println("Enter name of Employee you want to search");
				emp.setName(br.readLine());
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

			String query = "SELECT * FROM employees WHERE name = '"+emp.getName()+"';";

			Statement connect = DBConnection.getConnectivity();
			try {
				ResultSet rs = connect.executeQuery(query);
					
				while(rs.next()){
			
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String position = rs.getString("position");
					double salary = rs.getDouble("salary");

					System.out.println("-------------------------------------------");
					System.out.println("ID : "+ id);
					System.out.println("Name : "+name);
					System.out.println("Position : "+position);
					System.out.println("Salary : "+salary);
					System.out.println("-------------------------------------------");
					
					System.out.println();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		}else {
			try{
				throw new WrongInputChoiceException("You have not entered correct input");
			}catch(WrongInputChoiceException dfe) {
				System.out.println(dfe.getMessage());
			}
		}
	}
}
