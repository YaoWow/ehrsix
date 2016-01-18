package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.DeptBean;
import bean.JobBean;
import service.BaseService;

public class DeptDao {
	public BaseService bs=new BaseService();
	
	
	//�½�����
	public int insertDept(DeptBean dept){
		String sql="insert into department values(?,?,?,?,?,?,?)";
		return bs.update(sql, new Object[] {dept.getDeptNumber(),dept.getDeptName(),dept.getDeptType(),
											dept.getDeptTel(),dept.getDeptSuper(),dept.getDeptDesc(),
											dept.getDeptSetdate()});
	}
	public int deleteDept(String deptNumber){
		String sql="delete from department where dep_number=?";
		return bs.update(sql, new Object[] {deptNumber} );
	}
	public int updateDept(DeptBean dept){
		String sql="update department set dep_name=?,dep_type=? ,dep_tel=?,"+
					"dep_super=?,dep_desc=?,dep_setdate=? where dep_number=?";
		return bs.update(sql, new Object[] {dept.getDeptName(),
											dept.getDeptType(),
											dept.getDeptTel(),
											dept.getDeptSuper(),
											dept.getDeptDesc(),
											dept.getDeptSetdate(),
											dept.getDeptNumber()});
	}
	
	
	public List<DeptBean> selectDept(String deptType, String deptNum, String deptName) {
		
		List<Map> list;
		if (deptType.equals("") && deptNum.equals("") && deptName.equals("")) {
			list = bs.getList("select * from department  order by dep_number");
		}else if (!deptType.equals("") && deptNum.equals("") && deptName.equals("")) {
			list = bs.getList("select * from department where dep_Type=? order by dep_number", new Object[] {deptType});
		}else if (deptType.equals("") && !deptNum.equals("") && deptName.equals("")) {
			list = bs.getList("select * from department where dep_Number=? order by dep_number", new Object[] {deptNum});
		}else if (deptType.equals("") && deptNum.equals("") && !deptName.equals("")) {
			list = bs.getList("select * from department where dep_Name=? order by dep_number", new Object[] {deptName});
		}else if (!deptType.equals("") && !deptNum.equals("") && deptName.equals("")) {
			list = bs.getList("select * from department where dep_Type=? and dep_Number=? order by dep_number", new Object[] {deptType,deptNum});
		}else if (!deptType.equals("") && deptNum.equals("") && !deptName.equals("")) {
			list = bs.getList("select * from department where dep_Type=? and dep_Name=? order by dep_number", new Object[] {deptType,deptName});
		}else if (deptType.equals("") && !deptNum.equals("") && !deptName.equals("")) {
			list = bs.getList("select * from department where dep_Number=? and dep_Name=? order by dep_number", new Object[] {deptNum,deptName});
		}else {
			list = bs.getList("select * from department where dep_Type=? and dep_Number=? and dep_Name=? order by dep_number", new Object[] {deptType,deptNum,deptName});
		} 
		if (list == null || list.size() == 0) {
			return null;
		}
		List<DeptBean> depts = new ArrayList();
		DeptBean dept=new DeptBean();
		for (int i = 0; i < list.size(); i++) {
			Map m = list.get(i);
			dept = new DeptBean(
					(String) m.get("DEP_NUMBER"),(String) m.get("DEP_NAME"), 
					(String) m.get("DEP_TYPE"),(String) m.get("DEP_TEL"), 
					(String) m.get("DEP_SUPER"),(String) m.get("DEP_DESC"),
					(Date) m.get("DEP_SETDATE"));
			depts.add(dept);
		}
		return depts;

	}
	
		
}
