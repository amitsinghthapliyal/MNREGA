package com.MGNREGA.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.MGNREGA.bean.Employee;
import com.MGNREGA.bean.EmployeeDTO;
import com.MGNREGA.bean.GramPanchayatMember;
import com.MGNREGA.exceptions.EmployeeException;
import com.MGNREGA.exceptions.GPMException;
import com.MGNREGA.exceptions.ProjectException;
import com.MGNREGA.utility.DBUtil;

public class GPMDaoImpl implements GPMDao{

	@Override
	public GramPanchayatMember loginGPM(String username, String password) throws GPMException {

		GramPanchayatMember gpm = null;
		
		try(Connection conn = DBUtil.provideConnection()) {
			
			
			PreparedStatement ps= conn.prepareStatement("select * from gpm where gemail = ? AND gpassword = ?");			
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			
				if(rs.next()) {
				
				int id= rs.getInt("gid");
				String n= rs.getString("gname");
				String e= rs.getString("gemail");
				String p= rs.getString("gpassword");
				String m = rs.getString("gmoble");
				String a = rs.getString("gaddress");
				int bdoid = rs.getInt("bdoid");
				
				
				gpm =new GramPanchayatMember (id, n, e, p, m, a, bdoid);	
				
				
			}else
				throw new GPMException("Invalid Username or password.. ");
			
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		return gpm;
		
	}
	
	
	
	

	@Override
	public String registerEmployee(int eid, String ename, String emobile, String eaddress, int dayworked, int ewages) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllGPM() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String registerEmployeeToProject(int pid, int eid) throws ProjectException, EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO getEmployeeByMobile(String emobile) throws ProjectException {
		// TODO Auto-generated method stub
		return null;
	}

}
