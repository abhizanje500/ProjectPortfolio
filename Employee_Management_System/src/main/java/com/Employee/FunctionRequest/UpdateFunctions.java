package com.Employee.FunctionRequest;

import com.Employee.PrimeClass.*;

public class UpdateFunctions {
	
	//To update Employee ID
	
	public String updateID(int newID, Employee emp) {
		return "UPDATE employees SET id = '"+newID+"' WHERE id = '"+emp.getID()+"' AND name = '"+emp.getName()+"'";
	}
	
	//To update Employee name
	
	public String updateName(String newName, Employee emp) {
		return "UPDATE employees SET name = '"+newName+"' WHERE id = '"+emp.getID()+"' AND name = '"+emp.getName()+"'";
	}
	
	//To update Employee position
	
	public String updatePosition(String newPosition, Employee emp) {
		return "UPDATE employees SET position = '"+newPosition+"' WHERE id = '"+emp.getID()+"' AND name = '"+emp.getName()+"'";
	}
	
	//To update Employee salary
	
	public String updateSalary(double newSalary, Employee emp) {
		return "UPDATE employees SET salary = '"+newSalary+"' WHERE id = '"+emp.getID()+"' AND name = '"+emp.getName()+"'";
	}
}
