package com.tpb.wiki.beans;

public class User {
	private int id;
	private String userName;
	private String password;
	private String issuperadmin;
	private String status;
	
	
	
	
	public User(int id, String userName, String password, String issuperadmin, String status) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.issuperadmin = issuperadmin;
		this.status = status;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIssuperadmin() {
		return issuperadmin;
	}


	public void setIssuperadmin(String issuperadmin) {
		this.issuperadmin = issuperadmin;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
