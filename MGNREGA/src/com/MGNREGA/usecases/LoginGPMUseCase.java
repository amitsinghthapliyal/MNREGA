package com.MGNREGA.usecases;

import java.util.Scanner;

import com.MGNREGA.bean.GramPanchayatMember;
import com.MGNREGA.dao.GPMDao;
import com.MGNREGA.dao.GPMDaoImpl;
import com.MGNREGA.exceptions.GPMException;

public class LoginGPMUseCase {
	
	
	public static void run() {
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String uname = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		GPMDao dao = new GPMDaoImpl();
		
		try {
			GramPanchayatMember gpm= dao.loginGPM(uname, pass);
		
	 		System.out.println("Welcome Gram Panchayat Member :"+gpm.getGname());
	 	
	 	
		}catch (GPMException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
	}


}
