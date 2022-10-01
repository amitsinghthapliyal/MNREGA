package com.MGNREGA.dao;

import java.util.List;

import com.MGNREGA.bean.Employee;
import com.MGNREGA.bean.EmployeeDTO;
import com.MGNREGA.bean.GramPanchayatMember;
import com.MGNREGA.exceptions.EmployeeException;
import com.MGNREGA.exceptions.GPMException;
import com.MGNREGA.exceptions.ProjectException;

public interface GPMDao {
	
	public GramPanchayatMember loginGPM(String username, String password)throws GPMException;
	
	public String registerEmployee(int eid, String ename, String emobile, String eaddress, int dayworked, int ewages);

	public List<Employee> getAllGPM()throws EmployeeException;
	
	public String registerEmployeeToProject(int pid, int eid)throws ProjectException, EmployeeException ;


	public EmployeeDTO getEmployeeByMobile(String emobile)throws ProjectException;
}
