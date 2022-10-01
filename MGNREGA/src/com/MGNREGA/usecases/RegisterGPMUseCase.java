package com.MGNREGA.usecases;

import java.util.Scanner;

import com.MGNREGA.dao.BDODaoImpl;

public class RegisterGPMUseCase {
	
	
	public static void run() {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Gram Panchayat Member id:");
		int gid = sc.nextInt();
		
		System.out.println("Enter Gram Panchayat Member Name:");
		String gname = sc.next();
		
		System.out.println("Enter Gram Panchayat Member Email:");
		String gemail = sc.next();
		
		System.out.println("Assign a password to Gram Panchayat Member :");
		String gpassword = sc.next();
		
		System.out.println("Enter Gram Panchayat Member Mobile:");
		String gmobile = sc.next();
		
		System.out.println("Enter Gram Panchayat Member Address:");
		String gaddress = sc.next();
		
		System.out.println("Enter your (BDO) Id :");
		int bdoid = sc.nextInt();
	
		
		
		BDODaoImpl dao=new BDODaoImpl();
		
		String result= dao.registerGPM(gid, gname, gemail, gpassword, gmobile, gaddress, bdoid);
		
		System.out.println(result);
	}

}
