package com.Employee.DataRequest;

import java.sql.SQLException;
import java.sql.Statement;

import com.Employee.DBCon.DBConnection;
import com.Employee.ExceptionList.*;
import com.Employee.PrimeClass.Employee;
import com.Employee.FunctionRequest.UpdateFunctions;

public class Services implements Requests {
	
	UpdateFunctions upd = new UpdateFunctions();
	@Override
	public void addEmployee(Employee emp) {
		//add new recruit/employee in database
		
		String query = "insert into employees (name, position, salary) values ('"+emp.getName()+"','"+emp.getPosition()+"','"+emp.getSalary()+"');";
		Statement connect = DBConnection.getConnectivity();
		
		int changes = -1;
		
		try {
			changes = connect.executeUpdate(query);
			//connect.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		// executeUpdate() returns integer value which represents the number of rows affected.
		
		if(changes==1){
			System.out.println("Data has been inserted into database.");
		}else {
			try{
				throw new DataNotFilledException("Data has not been filled");
			}catch(DataNotFilledException dfe) {
				System.out.println(dfe.getMessage());
			}
		}
	}

	
	@Override
	
	public void deleteEmployee(int id, String name) {
	    String query2 = null;
	    int changes = -1;
	    
	    Statement connect = DBConnection.getConnectivity();
	    
	    query2 = "delete from employees where id = '"+id+"' and name = '"+name+"'";
	    System.out.println("ID : "+id+"; Name : "+name);
	    try {
	        changes = connect.executeUpdate(query2);
	    } catch(SQLException e) {
	        e.printStackTrace();
	        System.out.println(e.getMessage());
	    }
	    
	    if(changes == 1) {
	        System.out.println("Data has been deleted from database.");
	    } else {
	    	try{
				throw new DataNotDeletedException("Data has not been deleted from database");
			}catch(DataNotDeletedException dfe) {
				System.out.println(dfe.getMessage());
			}
	    }
	}
	
	
	@Override

	public void updateEmployee(int newID, Employee emp) {
		//update existing employee's ID
		Statement connect = DBConnection.getConnectivity();
		int changes = -1;
		
		try {
			changes = connect.executeUpdate(upd.updateID(newID, emp));
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		if(changes == 1) {
	        System.out.println("ID of employee has been Updated in database.");
	    } else {
	    	try{
				throw new DataNotUpdatedException("Data has not been updated into database");
			}catch(DataNotUpdatedException dfe) {
				System.out.println(dfe.getMessage());
			}
	    }
	}
	
	@Override

	public void updateEmployee(int operation, String str, Employee emp) {
		//update existing employee's Name or Position
		Statement connect = DBConnection.getConnectivity();
		int changes = -1;
		
		if(operation==2) {
			//update existing employee's Name
			try {
				changes = connect.executeUpdate(upd.updateName(str, emp));
			}catch(SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			if(changes == 1) {
		        System.out.println("Name of employee has been Updated in database.");
		    } else {
		    	try{
					throw new DataNotUpdatedException("Data has not been updated into database");
				}catch(DataNotUpdatedException dfe) {
					System.out.println(dfe.getMessage());
				}
		    }
			
		}else if(operation==3) {
			//update existing employee's position
			try {
				changes = connect.executeUpdate(upd.updatePosition(str, emp));
			}catch(SQLException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			if(changes == 1) {
		        System.out.println("Position of employee has been Updated in database.");
		    } else {
		    	try{
					throw new DataNotUpdatedException("Data has not been updated into database");
				}catch(DataNotUpdatedException dfe) {
					System.out.println(dfe.getMessage());
				}
		    }
		}
		
	}
	
	@Override

	public void updateEmployee(double newSalary, Employee emp) {
		//update existing employee's Salary
		Statement connect = DBConnection.getConnectivity();
		int changes = -1;
		
		try {
			changes = connect.executeUpdate(upd.updateSalary(newSalary, emp));
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		if(changes == 1) {
	        System.out.println("Position of employee has been Updated in database.");
	    } else {
	    	try{
				throw new DataNotUpdatedException("Data has not been updated into database");
			}catch(DataNotUpdatedException dfe) {
				System.out.println(dfe.getMessage());
			}
	    }
	}
}
