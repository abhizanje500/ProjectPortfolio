package com.Employee.PrimeClass;

public class Employee {
	
	int id;
	String name;
	String position;
	double salary;
	
	public void setID(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPosition() {
		return position;
	}
	public double getSalary() {
		return salary;
	}
}
