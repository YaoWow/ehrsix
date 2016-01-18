package service;

import java.util.List;

import bean.EmployeeBean;
import dao.EmployeeDao;

public class EmployeeService {
	public EmployeeDao ed=new EmployeeDao();
	EmployeeBean eb = new EmployeeBean();

	public boolean insertEmployee(EmployeeBean emp){	
		List<EmployeeBean> list = selectEmp("","",emp.getEmpId(),"",0);
		if(list!=null){
			return false;
		}
		ed.insertEmployee(emp);
		return true;
	}
	
	public boolean deleteEmployee(EmployeeBean emp){
		
		List<EmployeeBean> list = selectEmp("","",emp.getEmpId(),"",0);
		eb=list.get(0);
		if(eb!=null){
			ed.deleteEmployee(emp);
			return true;
		}
		return false;
	}
	
	public boolean editEmployee(EmployeeBean emp){
		ed.editEmployee(emp);
		return true;
	}
	
	public List<EmployeeBean> selectEmp(String deptName, String jobName, String empId, String empName ,int curPage){
		return ed.selectEmp(deptName, jobName, empId, empName,curPage);
	}
	
	public int pageRecCount(String deptName, String jobName, String empId, String empName){
		return ed.pageRecNum(deptName, jobName, empId, empName);
		
	}
	
	public List<EmployeeBean> selectAny(String value){
		return ed.selectAny("%"+value+"%");
	}
}
