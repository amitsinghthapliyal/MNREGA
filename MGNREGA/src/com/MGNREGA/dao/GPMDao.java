package com.MGNREGA.dao;

import java.util.List;

import com.MGNREGA.bean.Employee;
import com.MGNREGA.bean.GramPanchayatMember;
import com.MGNREGA.exceptions.EmployeeException;
import com.MGNREGA.exceptions.GPMException;
import com.MGNREGA.exceptions.ProjectException;

public interface GPMDao {
	
	public GramPanchayatMember loginGPM(String username, String password)throws GPMException;
	
	public String registerEmployee(int eid, String ename, String emobile, String eaddress, int dayworked, String ewages);

	public List<Employee> getAllEmployee()throws EmployeeException;
	
	public String registerEmployeeToProject(int pid, int eid)throws ProjectException, EmployeeException ;


	public Employee getEmployeeByMobile(String emobile)throws EmployeeException;
}
