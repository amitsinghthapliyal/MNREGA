package com.MGNREGA.usecases;

import java.util.List;

import com.MGNREGA.bean.Project;
import com.MGNREGA.dao.BDODao;
import com.MGNREGA.dao.BDODaoImpl;
import com.MGNREGA.exceptions.ProjectException;

public class GetListOfProjectUseCase {
	
	public static void run() {
		
		BDODao dao = new BDODaoImpl();
		
		try {
		List<Project> projects= dao.getListOfProject();
		
		projects.forEach(s ->{
			
			System.out.println("Project id :"+s.getPid());
			System.out.println("Project Name :"+s.getPname());
			System.out.println("Project Cost :"+s.getPcost());
			System.out.println("Project Issue Date :"+s.getPissuedate());
			
			System.out.println("=======================");
		});
		
		
		
		
		}catch(ProjectException se) {
			System.out.println(se.getMessage());
		}
		
		
		
		
		
	}

}
