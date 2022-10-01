package com.MGNREGA.main;

import java.util.Scanner;

import com.MGNREGA.usecases.GetAllEmployeeUseCase;
import com.MGNREGA.usecases.GetEmployeeByMobileUseCase;
import com.MGNREGA.usecases.RegisterEmployeeToProjectUseCase;
import com.MGNREGA.usecases.RegisterEmployeeUseCase;

public class GPMMain {
	
	public static void run() {
		
       Scanner s = new Scanner(System.in);
		
		System.out.println("===================================="
			           + "\n****** GRAM PANCHAYAT MEMBER *******"
			           + "\n====================================");
	
	System.out.println("* Please choose appropriate option *\n"
			+ "------------------------------------");
	
	System.out.println("\n"
			+ "1. CREATE EMPLOYEE\n"
			+ "2. VIEW THE DETAILS OF ALL EMPLOYEES\n"
			+ "3. ASSIGN EMPLOYEE TO A PROJECT\n"
			+ "4. VIEW TOTAL NO. OF DAY EMPLOYEE WORKED AND THIER WAGES\n"
			+ "5. LOGOUT");
	
	int gOption = s.nextInt();
	
	switch (gOption) {
	case 1:
		RegisterEmployeeUseCase.run();
		run();
		break;
		
	case 2:
		GetAllEmployeeUseCase.run();
		run();
		break;
		
	case 3:
		RegisterEmployeeToProjectUseCase.run();
		run();
		break;
		
	case 4:
		GetEmployeeByMobileUseCase.run();
		run();
		break;
		
	case 5:
		Main.run();
		break;
		
	default:
		System.out.println("Please Enter a valid key...");
		run();
		break;
	}
		
		
		
	}

}
