package com.MGNREGA.usecases;

import java.util.Scanner;

import com.MGNREGA.dao.GPMDao;
import com.MGNREGA.dao.GPMDaoImpl;

public class RegisterEmployeeUseCase {
	
	public static void run() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Employee id:");
		int eid= sc.nextInt();
		
		System.out.println("Enter Employee name:");
		String ename= sc.next();
		
		System.out.println("Enter Employee mobile:");
		String emobile= sc.next();
		
		System.out.println("Enter Employee address:");
		String eaddress= sc.next();
		
		System.out.println("Enter Employee dayWorked:");
		int edayWorked= sc.nextInt();
		
		System.out.println("Enter Employee wages:");
		String ewages= sc.next();
		

		
		
		GPMDao dao=new GPMDaoImpl();
		
		
		String result= dao.registerEmployee(eid, ename, emobile, eaddress, edayWorked, ewages);
		
		System.out.println(result);
	}


}
