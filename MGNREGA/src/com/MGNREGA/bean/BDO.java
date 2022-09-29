package com.MGNREGA.bean;

public class BDO {
	private int bid;
	private String bname;
	private String baddress;
	private String bmobile;
	private String bemail;

	public BDO() {
		
	}

	public BDO(int bid, String bname, String baddress, String bmobile, String bemail) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.baddress = baddress;
		this.bmobile = bmobile;
		this.bemail = bemail;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBaddress() {
		return baddress;
	}

	public void setBaddress(String baddress) {
		this.baddress = baddress;
	}

	public String getBmobile() {
		return bmobile;
	}

	public void setBmobile(String bmobile) {
		this.bmobile = bmobile;
	}

	public String getBemail() {
		return bemail;
	}

	public void setBemail(String bemail) {
		this.bemail = bemail;
	}


	@Override
	public String toString() {
		return "BDO [BDOid=" + bid + ", BDOname=" + bname + ", BDOaddress=" + baddress + ", BDOmobile=" + bmobile + ", BDOemail="
				+ bemail + "]";
	}
	
	

}
