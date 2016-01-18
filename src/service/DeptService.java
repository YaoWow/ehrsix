package service;

import java.util.List;

import bean.DeptBean;
import bean.JobBean;
import dao.DeptDao;
import dao.JobDao;

public class DeptService {
	
	public DeptDao dd=new DeptDao();

	DeptBean db=new DeptBean();

	public int addDept(DeptBean dept) {
		List<DeptBean> list = selectDept(dept.getDeptType(), dept.getDeptNumber(), dept.getDeptName());
		if(list!=null) {
			return 2;  //"2"表示编号已存在；
		}
		
		return dd.insertDept(dept);
		
	}
	
	public int deleteDept(String deptNumber) {
		return dd.deleteDept(deptNumber);
	}
	
	public int editDept(DeptBean dept) {
		return dd.updateDept(dept);
	} 

	public List<DeptBean> selectDept(String deptType,String deptNum,String deptName){
		return dd.selectDept(deptType, deptNum, deptName);
	}
}
