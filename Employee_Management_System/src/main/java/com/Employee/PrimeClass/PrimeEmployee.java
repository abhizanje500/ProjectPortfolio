package com.Employee.PrimeClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.Employee.FunctionRequest.ServiceRequest;
import com.Employee.ExceptionList.WrongInputChoiceException;
import com.Employee.SearchingDB.SearchingEmp;
import com.Employee.DataRequest.DBEmployees;

public class PrimeEmployee {

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("This is Main Menu");
		System.out.println("Please Select one of the options to proceed with");
		System.out.println("Press 1 : to manage existing employees");
		System.out.println("Press 2 : to search employee in database");
		System.out.println("Press 3 : to see all the database");
		
		int choice = -1;
		
		try{
			choice = Integer.parseInt(br.readLine());
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		if(choice==1) {
			ServiceRequest sr = new ServiceRequest();
			sr.manageEmployee();
		}else if(choice==2) {
			SearchingEmp semp = new SearchingEmp();
			semp.searchEmployee();
		}else if(choice==3) {
			DBEmployees dbemp = new DBEmployees();
			dbemp.displayDB();
		}else {
			try{
				throw new WrongInputChoiceException("You have not entered correct input");
			}catch(WrongInputChoiceException dfe) {
				System.out.println(dfe.getMessage());
			}
		}
	}
}
