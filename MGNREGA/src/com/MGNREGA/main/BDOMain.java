package com.MGNREGA.main;

import java.util.Scanner;

import com.MGNREGA.usecases.AllocateProjectToGPMUseCase;
import com.MGNREGA.usecases.CreateProjectUseCase;
import com.MGNREGA.usecases.GetAllEmployeeByPnameUseCase;
import com.MGNREGA.usecases.GetAllGPMUseCase;
import com.MGNREGA.usecases.GetListOfProjectUseCase;
import com.MGNREGA.usecases.RegisterGPMUseCase;

public class BDOMain {
	
	public static void run() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("===================================="
			       + "\n**** Block Development Officer *****"
			       + "\n====================================");
	
	System.out.println("* Please choose appropriate option *\n"
			+ "------------------------------------");
	
	System.out.println("\n"
			+ "1. CREATE PROJECT\n"
			+ "2. VIEW LIST OF PROJECT\n"
			+ "3. CREATE NEW GRAM PANCHAYAT MEMBER\n"
			+ "4. VIEW ALL GRAM PANCHAYAT MEMBER\n"
			+ "5. ALLOCATE PROJECT TO GRAM PANCHAYAT MEMBER\n"
			+ "6. SEE LIST OF EMPLOYEE WORKING ON A PROJECT\n"
			+ "7. LOGOUT");
	
	int bOption = s.nextInt();
	
	switch (bOption) {
	case 1:
		CreateProjectUseCase.run();
		run();
		break;
		
	case 2:
		GetListOfProjectUseCase.run();
		run();
		break;
		
	case 3:
		RegisterGPMUseCase.run();
		run();
		break;
		
	case 4:
		GetAllGPMUseCase.run();
		run();
		break;
		
	case 5:
		AllocateProjectToGPMUseCase.run();
		run();
		break;
		
	case 6:
		GetAllEmployeeByPnameUseCase.run();
		run();
		break;
		
	case 7:
		Main.run();
		break;

	default:
		System.out.println("Please Enter a valid key...");
		run();
		break;
	}
		
		
	}

}
