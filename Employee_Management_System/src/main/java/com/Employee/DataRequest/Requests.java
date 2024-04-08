package com.Employee.DataRequest;

import com.Employee.PrimeClass.*;

public interface Requests {
	public void addEmployee(Employee emp);
	public void deleteEmployee(int id, String name);
	public void updateEmployee(int newID, Employee emp);
	public void updateEmployee(int operation, String str, Employee emp);
	public void updateEmployee(double newSalary, Employee emp);
}
