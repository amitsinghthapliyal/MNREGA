package com.MGNREGA.dao;

import java.util.List;

import com.MGNREGA.bean.BDO;
import com.MGNREGA.bean.Project;
import com.MGNREGA.bean.GramPanchayatMember;
import com.MGNREGA.bean.EmployeeDTO;
import com.MGNREGA.exceptions.BDOException;
import com.MGNREGA.exceptions.GPMException;
import com.MGNREGA.exceptions.ProjectException;

public interface BDODao {
	
	
	public BDO loginBDO(String username, String password)throws BDOException;
	
	public String createProject(int pid, String pname, String pcost, String pissuedate);
	
	public List<Project> getListOfProject()throws ProjectException;
	
	public String registerGPM(int gid, String gname, String gemail, String gpassword, String gmobile, String gaddress, int bdoid);
	
	public List<GramPanchayatMember> getAllGPM()throws GPMException;
	
	
	public String allocateProjectToGPM(int pid, int gid)throws GPMException,ProjectException ;
	
	public List<EmployeeDTO> getAllEmployeeByPname(String pname)throws ProjectException;
	

}
