package service;

import java.util.List;

import bean.UserBean;
import dao.UserDao;

public class UserService {
	
	public UserDao ud = new UserDao();

	
	
	//登录函数
	public int login(String userName,String userType, String userPwd) {
		UserBean user = ud.findByID(userName);		//
		if (user == null) {
			return -1;                          //用户名不存在返回-1
		}
		if (userPwd.equals(user.getUserPwd())){
			if(userType.equals("super")){
				if(userType.equals(user.getUserType()))
					return 1;						//用户名存在，密码正确，超级管理员权限正确返回1
				return -2;							//用户名存在，密码正确，但不是超级管理员返回-2
			}
			return 2;								//用户名存在，密码正确，以普通身份登录返回2
		}							
		return -3;								//用户名存在但密码错误返回-3
	}
	
	public boolean addUser(String userName, String userType, String userPwd){
		UserBean user=new UserBean(userName,userType,userPwd);
		
		if((ud.findByID(userName))==null){
			ud.insertUser(user);
			return true;
		}
		return false;
	}
	
	public boolean deleteUser(String userName){
		if(ud.findByID(userName)==null){
			return false;
		}
		ud.deleteUser(userName);
		return true;
	}
	
	public boolean editUser(String userName,String userType,String userPwd){
		UserBean user=new UserBean(userName,userType,userPwd);
		if(ud.findByID(userName)==null){
			return false;
		}
		ud.updateUser(user);
		return true;
	}
	
	public List<UserBean> listAllUser(){
		return ud.getAllUser();
	}
}
