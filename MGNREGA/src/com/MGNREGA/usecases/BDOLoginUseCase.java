package com.MGNREGA.usecases;

import java.util.Scanner;

import com.MGNREGA.bean.BDO;
import com.MGNREGA.dao.BDODao;
import com.MGNREGA.dao.BDODaoImpl;
import com.MGNREGA.exceptions.BDOException;

public class BDOLoginUseCase {
	
	
	public static void run() {
		
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter Username:");
		String uname = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		BDODao dao = new BDODaoImpl();
		
		try {
			BDO bdo= dao.loginBDO(uname, pass);
		
	 		System.out.println("Welcome :"+bdo.getBname());
	 	
	 	
		}catch (BDOException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
	}


}
