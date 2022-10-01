package com.MGNREGA.usecases;

import java.util.List;
import java.util.Scanner;

import com.MGNREGA.bean.EmployeeDTO;
import com.MGNREGA.dao.BDODao;
import com.MGNREGA.dao.BDODaoImpl;

public class GetAllEmployeeByPnameUseCase {
	
public static void run() {
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the Project Name :");
		
		String pname= sc.next();

		
		BDODao dao = new BDODaoImpl();
		
		try {
		List<EmployeeDTO> dtos= dao.getAllEmployeeByPname(pname);
		
		dtos.forEach(dto -> {
		
			System.out.println("Employee name :"+dto.getEname());
			System.out.println("Employee mobile :"+dto.getEmobile());
			System.out.println("Employee address :"+dto.getEaddress());
			System.out.println("Employee total day worked :"+dto.getDayworked());
			System.out.println("Employee wages :"+dto.getEwages());
			
			System.out.println("=======================");
		
		});
		
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
