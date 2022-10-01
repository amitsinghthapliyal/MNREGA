package com.MGNREGA.usecases;

import java.util.Scanner;

import com.MGNREGA.dao.GPMDao;
import com.MGNREGA.dao.GPMDaoImpl;

public class RegisterEmployeeToProjectUseCase {
	
public static void run() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the project id:");
		int pid= sc.nextInt();

		System.out.println("Enter the Employee id:");
		int eid= sc.nextInt();
	
		
		
		GPMDao dao = new GPMDaoImpl();
		
		try {
		String result = dao.registerEmployeeToProject(pid, eid);
		
		System.out.println(result);
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
	}

}
