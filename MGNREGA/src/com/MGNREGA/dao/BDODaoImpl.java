package com.MGNREGA.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.MGNREGA.bean.BDO;
import com.MGNREGA.bean.EmployeeDTO;
import com.MGNREGA.bean.GramPanchayatMember;
import com.MGNREGA.bean.Project;
import com.MGNREGA.exceptions.BDOException;
import com.MGNREGA.exceptions.EmployeeException;
import com.MGNREGA.exceptions.GPMException;
import com.MGNREGA.exceptions.ProjectException;
import com.MGNREGA.utility.DBUtil;

public class BDODaoImpl implements BDODao{

	@Override
	public BDO loginBDO(String username, String password) throws BDOException {
		
		BDO bdo = null;
		
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from bdo where bemail = ? AND bpassword = ?");			
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			
				if(rs.next()) {
				
				int id= rs.getInt("bid");
				String n= rs.getString("bname");
				String e= rs.getString("bemail");
				String p= rs.getString("bpassword");
				String m= rs.getString("bmobile");
				String a= rs.getString("baddress");
				
				
			bdo = new BDO(id, n, a, m, e);	
				
				
			}else
				throw new BDOException("Invalid Username or password.. ");
			
		} catch (SQLException e) {
			throw new BDOException(e.getMessage());
		}
			
		return bdo;
	}

	
	
	
	
	@Override
	public String createProject(int pid, String pname, String pcost, String pissuedate) {
		
		String message = "Not Created..";
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into project(pid,pname,pcost,pissuedate) values(?,?,?,?)");
			
			
			ps.setInt(1, pid);
			ps.setString(2, pname);
			ps.setString(3, pcost);
			ps.setString(4, pissuedate);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "Project Created Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
	
	
		
		
		
		return message;
	}

	
	
	
	
	
	@Override
	public List<Project> getListOfProject() throws ProjectException {
		
		List<Project> projects= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from project");
			
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int id= rs.getInt("pid");
				String n= rs.getString("pname");
				String c= rs.getString("pcost");
				String d= rs.getString("pissuedate");
				int gpmid = rs.getInt("gpmID");
				
				
			Project project = new Project(id, n, c, d, gpmid);	
				
			projects.add(project);
				
				
				
			}
			
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
		
		
		if(projects.size() == 0)
			throw new ProjectException("No Project found..");
		
		
		return projects;
	}
	
	
	
	
	
	

	@Override
	public String registerGPM(int gid, String gname, String gemail, String gpassword, String gmobile, String gaddress,int bdoid) {
		
		String message = "Not Registered..";
	
		
	
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into gpm(gid,gname,gemail,gpassword,gmobile,gaddress,bdoid) values(?,?,?,?,?,?,?)");
			
			
			
			ps.setInt(1, gid);
			ps.setString(2, gname);
			ps.setString(3, gemail);
			ps.setString(4, gpassword);
			ps.setString(5, gmobile);
			ps.setString(6, gaddress);
			ps.setInt(7, bdoid);
			
			int x= ps.executeUpdate();
			
			
			if(x > 0)
				message = "GramPanchayatMember is Registered Sucessfully !";
			
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		
	
	
		
		return message;
		
	}
	
	
	
	
	
	

	@Override
	public List<GramPanchayatMember> getAllGPM() throws GPMException {
		
		List<GramPanchayatMember> gpms= new ArrayList<>();
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select * from gpm");
			
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				
				int id= rs.getInt("gid");
				String n= rs.getString("gname");
				String e= rs.getString("gemail");
				String p= rs.getString("gpassword");
				String m= rs.getString("gmobile");
				String a = rs.getString("gaddress");
				int bdoid = rs.getInt("bdoid");
				
				
				GramPanchayatMember gpm = new GramPanchayatMember(id, n, e, p, m, a, bdoid);	
				
			gpms.add(gpm);
				
				
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		
		if(gpms.size() == 0)
			throw new GPMException("No GramPanchayatMember found..");	
		
		return gpms;	
	}
	
	
	
	
	// TODO
	@Override
	public String allocateProjectToGPM(int pid, int gid) throws GPMException, ProjectException {

		String message ="Not Allocated..";
		
		
		try(Connection conn= DBUtil.provideConnection()) {
			
		 	PreparedStatement ps= conn.prepareStatement("select * from gpm where gid =?");
			
		 	
		 	ps.setInt(1, gid);
		 	
		 	ResultSet rs= ps.executeQuery();
			
		 	if(rs.next()) {
		 		
		 		PreparedStatement ps2= conn.prepareStatement("select * from project where pid=?");
		 		
		 		ps2.setInt(1, pid);

		 		ResultSet rs2= ps2.executeQuery();
		 		
		 		if(rs2.next()) {
		 			

		 			PreparedStatement ps3= conn.prepareStatement("insert into project_gpm values(?,?)");
		 			
		 			
		 			ps3.setInt(1, pid);
		 			ps3.setInt(2, gid);
		 			
		 			int x= ps3.executeUpdate();
		 			
		 			if(x > 0)
		 				message = "Project Assigned to GPM Sucessfully.. ";
		 			else
		 				throw new GPMException("Techical error..");
		 			
		 			
		 			
		 		}
		 		else
		 			throw new ProjectException("Invalid Project...");
		 				
		 	}else
		 		throw new GPMException("Invalid GPM...");
			
		} catch (SQLException e) {
			throw new GPMException(e.getMessage());
		}
		
		return message;
		
	}
	
	
	
	
	
	
	

	@Override
	public List<EmployeeDTO> getAllEmployeeByPname(String pname) throws ProjectException {
	
		List<EmployeeDTO> edtos = new ArrayList<>();
		
		
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select e.ename, e.emobile,e.eaddress, e.etotaldaywork, e.ewages, p.pname "
														+ "from  employee e INNER JOIN project p INNER JOIN project_employee pe "
														+ "ON e.eid = pe.eid AND p.pid = pe.pid AND p.pname= ?");
			
			ps.setString(1, pname);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				String n= rs.getString("ename");
				String m= rs.getString("emobile");
				
				String a= rs.getString("eaddress");
				int d= rs.getInt("etotaldaywork");
				String w = rs.getString("ewages");
				String p = rs.getString("pname");
				
				EmployeeDTO dto = new EmployeeDTO(n, m, a, d, w, p);
				
				edtos.add(dto);
				
				
				
			}		
			
		} catch (SQLException e) {
			throw new ProjectException(e.getMessage());
		}
			
		if(edtos.isEmpty())
			throw new ProjectException("No Employee found in the Project");
			
		return edtos;	
		
	}


}
