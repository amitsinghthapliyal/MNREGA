package com.MGNREGA.usecases;

import java.util.List;

import com.MGNREGA.bean.GramPanchayatMember;
import com.MGNREGA.dao.BDODaoImpl;
import com.MGNREGA.exceptions.GPMException;

public class GetAllGPMUseCase {
	
public static void run() {
		
		BDODaoImpl dao = new BDODaoImpl();
		
		try {
		List<GramPanchayatMember> gpms= dao.getAllGPM();
		
		gpms.forEach(g ->{
			
			System.out.println("GPM id :"+g.getGid());
			System.out.println("GPM Name :"+g.getGname());
			System.out.println("GPM Email :"+g.getGemail());
			System.out.println("GPM Password :"+g.getGpassword());
			System.out.println("GPM Mobile :"+g.getGmobile());
			System.out.println("GPM Address :"+g.getGaddress());
			
			System.out.println("=======================");
		});
		
		
		
		
		}catch(GPMException se) {
			System.out.println(se.getMessage());
		}
		
		
		
		
		
	}

}
