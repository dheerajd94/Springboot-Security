package com.jwtauthentication.demo.model;

public class JwtRequest {
	
	private String userName;
	private String passWord;
	public JwtRequest() {
		
	}
	public JwtRequest(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	@Override
	public String toString() {
		return "JwtRequest [userName=" + userName + ", passWord=" + passWord + "]";
	}
	
	
	 

}