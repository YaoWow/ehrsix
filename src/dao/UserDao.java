package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.UserBean;
import service.BaseService;

public class UserDao {
public BaseService bs=new BaseService();
	
	public int insertUser(UserBean user){
		String sql="insert into admin values(?,?,?)";
		return bs.update(sql, new Object[] {user.getUserName(),user.getUserType(),user.getUserPwd()});
	}
	public int deleteUser(String userName){
		String sql="delete from admin where user_name=?";
		return bs.update(sql, new Object[] {userName} );
	}
	public int updateUser(UserBean user){
		String sql="update admin set USER_PWD=? where user_name=?";
		return bs.update(sql, new Object[] {user.getUserPwd(),user.getUserName()});
	}
	public UserBean findByID(String userName){
		String sql="select * from admin where user_name=?";
		Map m=bs.getSingleRow(sql,new Object[]{userName});
		if (m==null) {
			return null;
		}
		UserBean user=new UserBean((String)m.get("USER_NAME"),(String)m.get("USER_TYPE"),(String)m.get("USER_PWD"));
		return user;
	}
	public List<UserBean> getAllUser(){
		String sql="select * from admin";
		List<Map> list=bs.getList(sql);
		List<UserBean> allUser=new ArrayList();
		if(list==null || list.size()==0){
			return null;
		}
		for(int i=0;i<list.size();i++){
			UserBean user;
			Map m=list.get(i);
			user= new UserBean((String)m.get("USER_NAME"),(String)m.get("USER_TYPE"),(String)m.get("USER_PWD"));
			allUser.add(user);
		}
		return allUser;
	}
}
