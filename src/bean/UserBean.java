package bean;

import java.io.Serializable;

public class UserBean implements Serializable{
	private String userName;
	private String userType;
	private String userPwd;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public UserBean(String uname,String utype,String upwd){
		this.userName=uname;
		this.userType=utype;
		this.userPwd=upwd;
	}
	
}
