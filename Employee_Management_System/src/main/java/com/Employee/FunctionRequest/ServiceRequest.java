package com.Employee.FunctionRequest;

import com.Employee.DataRequest.*;
import com.Employee.ExceptionList.*;
import com.Employee.PrimeClass.Employee;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServiceRequest {
	public void manageEmployee() {
		Services serv = new Services();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Employee emp = new Employee();
		
		System.out.println();
		System.out.println("Press the number according to What operation do you want to perform");
		System.out.println("Press 1 : to add a employee");
		System.out.println("Press 2 : to delete a employee");
		System.out.println("Press 3 : to update existing employee");
		
		int option = 0;
		
		try {
			option = Integer.parseInt(br.readLine());
		}catch(IOException e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
			
			/////////////////////////////////////////////////////////////////////////////////////////
			
			// Logic to add employee
			
		if(option==1) {
			System.out.println("Enter employee details as follow");
			
			try {
				System.out.println("Enter full name of a employee");
				emp.setName(br.readLine());
				
				System.out.println("Enter position of a employee");
				emp.setPosition(br.readLine());
				
				System.out.println("Enter salary of a employee");
				emp.setSalary (Double.parseDouble(br.readLine()));
				
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}finally {
				try {
					br.close();
				}catch(IOException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
			serv.addEmployee(emp);
		
			//////////////////////////////////////////////////////////////////////////////////////////
			
			// Logic to delete Employee
			
		}else if(option==2) {
			int id = 0;
			String name = null;

			try {
				System.out.println("Enter ID of Enmployee");
				id = Integer.parseInt(br.readLine());
				//emp.setID(id);
				System.out.println("Enter Name of Enmployee");
				name = br.readLine();
				//emp.setName(name);
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}finally {
				try {
					br.close();
				}catch(IOException e){
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}
			serv.deleteEmployee(id, name);
		
			///////////////////////////////////////////////////////////////////////////////////////////////
			
			// Logic to update Employee
			
		}else if(option==3) {
			
			System.out.println("Enter a number in accordance with what you want to update");
			System.out.println("Press 1 : to update id of a employee");
			System.out.println("Press 2 : to update name of a employee");
			System.out.println("Press 3 : to update position of a employee");
			System.out.println("Press 4 : to update salary of a employee");
			
			int operation = -1;
			try {
				operation = Integer.parseInt(br.readLine());
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			/////////////////////////////////////////////////////////////////////////////////////////////////
			// To update the ID of a employee.
			
			// Inside the if (operation == 1) block
			if (operation == 1) {
			    String name = null;
			    int oldID = -1;
			    int newID = -1;
			    
			    try {
			        System.out.println("Enter existing ID of employee");
			        oldID = Integer.parseInt(br.readLine());
			        emp.setID(oldID);  // Correct method used here
			        System.out.println("Enter name of employee");
			        name = br.readLine();
			        emp.setName(name);  // Correct method used here
			        System.out.println("Enter new ID you want to assign to employee");
			        newID = Integer.parseInt(br.readLine());
			    } catch (IOException e) {
			        e.printStackTrace();
			        System.out.println(e.getMessage());
			    }
			    
			    serv.updateEmployee(newID, emp);

				/////////////////////////////////////////////////////////////////////////////////////////////////
				// To update the name of a employee.
			}else if(operation==2){
				int id = -1;
				String oldName = null;
				String newName = null;
				
				try {
					System.out.println("Enter the ID of Employee");
					id = Integer.parseInt(br.readLine());
					emp.setID(id);
					System.out.println("Enter Existing name of employee into database");
					oldName = br.readLine();
					emp.setName(oldName);
					System.out.println("Enter new name you want to assign");
					newName = br.readLine();
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				
				serv.updateEmployee(operation, newName, emp);
				
				/////////////////////////////////////////////////////////////////////////////////////////////////
				// To update the position of a employee.

			}else if(operation==3){
				int id = -1;
				String name = null;
				String newPosition = null;
				
				try {
					System.out.println("Enter the ID of Employee");
					id = Integer.parseInt(br.readLine());
					emp.setID(id);
					System.out.println("Enter Existing name of employee into database");
					name = br.readLine();
					emp.setName(name);
					System.out.println("Enter new position you want to assign");
					newPosition = br.readLine();
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				
				serv.updateEmployee(operation, newPosition, emp);
				
				/////////////////////////////////////////////////////////////////////////////////////////////////
				// To update the salary of a employee.
				
			}else if(operation==4){
				int id = -1;
				String name = null;
				double newSalary = -1;
				try {
					System.out.println("Enter the ID of Employee");
					id = Integer.parseInt(br.readLine());
					emp.setID(id);
					System.out.println("Enter Existing name of employee into database");
					name = br.readLine();
					emp.setName(name);
					System.out.println("Enter new salary you want to assign");
					newSalary = Double.parseDouble(br.readLine());
				}catch (NumberFormatException | IOException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				
				serv.updateEmployee(newSalary, emp);
				
			}else {
				try{
					throw new WrongInputChoiceException("You have not entered correct input");
				}catch(WrongInputChoiceException dfe) {
					System.out.println(dfe.getMessage());
				}
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
