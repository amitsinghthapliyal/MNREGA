package com.MGNREGA.usecases;

import java.util.Scanner;

import com.MGNREGA.bean.Employee;
import com.MGNREGA.dao.GPMDao;
import com.MGNREGA.dao.GPMDaoImpl;
import com.MGNREGA.exceptions.EmployeeException;

public class GetEmployeeByMobileUseCase {
	
	public static void run() {
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Employee mobile Number:");
		String mobile = sc.next();
		
		
		GPMDao dao= new GPMDaoImpl();
		
		try {
		Employee employee= dao.getEmployeeByMobile(mobile);
		
			System.out.println("Employee id:"+employee.getEid());
			System.out.println("Employee name:"+employee.getEname());
			System.out.println("Employee address:"+employee.getEaddress());
			System.out.println("Employee mobile:"+employee.getEmobile());
			System.out.println("Employee day worked:"+employee.getDayworked());
			System.out.println("Employee wages:"+employee.getEwages());
		
		}catch (EmployeeException se) {
			System.out.println(se.getMessage());
		}
		
		
		

	}

}
