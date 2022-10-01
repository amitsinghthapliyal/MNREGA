package com.MGNREGA.usecases;

import java.util.Scanner;

import com.MGNREGA.dao.BDODao;
import com.MGNREGA.dao.BDODaoImpl;

public class AllocateProjectToGPMUseCase {
	
public static void run() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the Project id:");
		int pid= sc.nextInt();

		System.out.println("Enter the GPM id:");
		int gid = sc.nextInt();
		
		
		BDODao dao = new BDODaoImpl();
		
		try {
		String result = dao.allocateProjectToGPM(pid, gid);
		
		System.out.println(result);
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		
	}

}
