package com.MGNREGA.main;

import java.util.Scanner;

import com.MGNREGA.usecases.BDOLoginUseCase;
import com.MGNREGA.usecases.LoginGPMUseCase;

public class Main {
	
    public static void run() {
    	
    	Scanner s = new Scanner(System.in);
		
    	System.out.println("===================================="
    			+ "\n******** WELCOME TO MGNREGA ********"
    			+ "\n====================================");
    	
    	System.out.println("* Please choose appropriate option *\n"
    			+ "------------------------------------");
    	
    	System.out.println("\n"
    			+ "1. LOGIN AS BLOCK DEVELOPMENT OFFICER\n"
    			+ "2. LOGIN AS GRAM PANCHAYAT MEMBER");
    	
    	int n = s.nextInt();
    	
    	switch (n) {
		case 1: BDOLoginUseCase.run();    	
			BDOMain.run();
			break;
			
		case 2: LoginGPMUseCase.run();
		    GPMMain.run();
		    break;

		default: System.out.println("Please enter a valid key...");
		    run();
			break;
		}
    	
	}
    
    
    public static void main(String[] args) {
		run();
	}

}
