package com.MGNREGA.usecases;

import java.util.Scanner;

import com.MGNREGA.dao.BDODao;
import com.MGNREGA.dao.BDODaoImpl;

public class CreateProjectUseCase {
	
	public static void run() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Project Id:");
		int pid= sc.nextInt();
		
		System.out.println("Enter Project Name:");
		String pname= sc.next();
		
		System.out.println("Enter Project Cost:");
		String pcost= sc.next();
		
		System.out.println("Enter Project Issue Date:");
		String pissuedate= sc.next();
		
		
		BDODao dao = new BDODaoImpl();
		
		String result= dao.createProject(pid, pname, pcost, pissuedate);
		
		System.out.println(result);
	}


}
