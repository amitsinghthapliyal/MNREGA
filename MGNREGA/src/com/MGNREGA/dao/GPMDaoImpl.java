package com.MGNREGA.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.MGNREGA.bean.Employee;
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
				String m = rs.getString("gmobile");
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
	public String registerEmployee(int eid, String ename, String emobile, String eaddress, int dayworked, String ewages) {

		
		String message = "Not Registered..";
	
		
	
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into employee (eid, ename, emobile, eaddress, etotaldaywork, ewages) values(?,?,?,?,?,?)");
			
			
			ps.setInt(1, eid);
			ps.setString(2, ename);
			ps.setString(3, emobile);
			ps.setString(4, eaddress);
			ps.setInt(5, dayworked);
			ps.setString(6, ewages);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Empolyee Registered Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
	
	
		
		return message;
	}
	
	
	

	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {

		List<Employee> employees= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from employee");
			
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int id= rs.getInt("eid");
				String n= rs.getString("ename");
				String m= rs.getString("emobile");
				String a= rs.getString("eaddress");
				int d= rs.getInt("etotaldaywork");
				String w = rs.getString("ewages");
				
				
				
			Employee employee = new Employee(id, n, m, a, d, w);	
				
			employees.add(employee);
			}	
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		
		if(employees.size() == 0)
			throw new EmployeeException("No Employee found..");
		
		return employees;	
		
	}
	
	
	
	
	

	@Override
	public String registerEmployeeToProject(int pid, int eid) throws ProjectException, EmployeeException {

		String message ="Not Resgistered";
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
		 	PreparedStatement ps= conn.prepareStatement("select * from employee where eid =?");
			
		 	
		 	ps.setInt(1, eid);
		 	
		 	ResultSet rs= ps.executeQuery();
			
		 	if(rs.next()) {
		 		
		 		PreparedStatement ps2= conn.prepareStatement("select * from project where pid=?");
		 		
		 		ps2.setInt(1, pid);

		 		ResultSet rs2= ps2.executeQuery();
		 		
		 		if(rs2.next()) {
		 			

		 			PreparedStatement ps3= conn.prepareStatement("insert into project_employee values(?,?)");
		 			
		 			
		 			ps3.setInt(1, pid);
		 			ps3.setInt(2, eid);
		 			
		 			int x= ps3.executeUpdate();
		 			
		 			if(x > 0)
		 				message = "Employee registered to Project Sucessfully.. ";
		 			else
		 				throw new EmployeeException("Techical error..");
		 			
		 			
		 			
		 		}
		 		else
		 			throw new ProjectException("Invalid Project...");
		 				
		 	}else
		 		throw new EmployeeException("Invalid Employee...");
			
		} catch (SQLException e) {
			throw new EmployeeException(e.getMessage());
		}
		
		return message;
		
	}
	
	
	
	
	

	@Override
	public Employee getEmployeeByMobile(String emobile) throws EmployeeException {

		
		Employee employee =null;
		
		
		try (Connection conn= DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select * from employee where emobile=?");
			
			
			ps.setString(1, emobile);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				int id= rs.getInt("eid");
				String n= rs.getString("ename");
				String m= rs.getString("emobile");
				String a= rs.getString("eaddress");
				int d= rs.getInt("etotaldaywork");
				String w = rs.getString("ewages");
					
			employee =new Employee(id, n, m, a, d, w);	
				
				
			}else
				throw new EmployeeException("Employee does not exist with mobile "+emobile);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			throw new EmployeeException(e.getMessage());	
		}
	
		return employee;
	}

}
