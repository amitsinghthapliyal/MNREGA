package com.MGNREGA.bean;

public class GramPanchayatMember {
	
	private int gid;
	private String gname;
	private String gemail;
	private String gpassword;
	private int gmobile;
	private String gaddress;
	private int bdoid;
	

	public GramPanchayatMember() {
		
	}



	public GramPanchayatMember(int gid, String gname, String gemail, String gpassword, int gmobile, String gaddress,
			int bdoid) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gemail = gemail;
		this.gpassword = gpassword;
		this.gmobile = gmobile;
		this.gaddress = gaddress;
		this.bdoid = bdoid;
	}


	public int getGid() {
		return gid;
	}


	public void setGid(int gid) {
		this.gid = gid;
	}


	public String getGname() {
		return gname;
	}


	public void setGname(String gname) {
		this.gname = gname;
	}


	public String getGemail() {
		return gemail;
	}


	public void setGemail(String gemail) {
		this.gemail = gemail;
	}


	public String getGpassword() {
		return gpassword;
	}


	public void setGpassword(String gpassword) {
		this.gpassword = gpassword;
	}


	public int getGmobile() {
		return gmobile;
	}


	public void setGmobile(int gmobile) {
		this.gmobile = gmobile;
	}


	public String getGaddress() {
		return gaddress;
	}


	public void setGaddress(String gaddress) {
		this.gaddress = gaddress;
	}
	
	


	public int getBdoid() {
		return bdoid;
	}



	public void setBdoid(int bdoid) {
		this.bdoid = bdoid;
	}



	@Override
	public String toString() {
		return "GramPanchayatMember [gid=" + gid + ", gname=" + gname + ", gemail=" + gemail + ", gpassword="
				+ gpassword + ", gmobile=" + gmobile + ", gaddress=" + gaddress + ", bdoid=" + bdoid + "]";
	}




	
	

}
