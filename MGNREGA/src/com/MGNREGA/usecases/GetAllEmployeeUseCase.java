package com.MGNREGA.usecases;

import java.util.List;

import com.MGNREGA.bean.Employee;
import com.MGNREGA.dao.GPMDao;
import com.MGNREGA.dao.GPMDaoImpl;
import com.MGNREGA.exceptions.EmployeeException;

public class GetAllEmployeeUseCase {
	
public static void run() {
		
		GPMDao dao = new GPMDaoImpl();
		
		try {
		List<Employee> students= dao.getAllEmployee();
		
		students.forEach(e ->{
			
			System.out.println("Employee id :"+e.getEid());
			System.out.println("Employee name :"+e.getEname());
			System.out.println("Employee mobile :"+e.getEmobile());
			System.out.println("Employee address :"+e.getEaddress());
			System.out.println("Employee day worked :"+e.getDayworked());
			System.out.println("Employee wages :"+e.getEwages());

			
			System.out.println("=======================");
		});
		
		
		
		
		}catch(EmployeeException se) {
			System.out.println(se.getMessage());
		}
		
		
		
		
		
	}

}
