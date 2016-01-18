package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.DeptBean;
import bean.EmployeeBean;
import bean.JobBean;
import service.BaseService;

public class EmployeeDao {
	public BaseService bs=new BaseService();
	
	public int insertEmployee(EmployeeBean emp){
		String sql="insert into employee values( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return bs.update(sql,new Object[]{emp.getEmpNum(),emp.getEmpName(),emp.getEmpBirth(),
										emp.getGender(),emp.getEmpPolity(),emp.getEmpFolk(),
										emp.getEmpId(),emp.getEmpIndate(),emp.getEmpLeft(),
										emp.getEmpBirthplace(),emp.getEmpPhone(),emp.getEmpMail(),
										emp.getDeptName(),emp.getJobName(),emp.getEmpLearn(),
										emp.getEmpGraduate(),emp.getEmpGradate(),emp.getEmpSituation()
										});
	}
	
	public int deleteEmployee(EmployeeBean emp){
		String sql="delete from employee where emp_num=?";
		return bs.update(sql,new Object[] {emp.getEmpNum()});
	}	
	
	public int editEmployee(EmployeeBean emp){
		String sql="update employee set emp_name=?,emp_birth=?,gender=?,emp_polity=?,emp_folk=?,emp_id=?,emp_indate=?,emp_left=?,emp_birthplace=?,emp_phone=?,emp_mail=?,dep_name=?,job_name=?,emp_learn=?,emp_graduate=?,emp_gradate=?,situation=? where emp_num=?";
		return bs.update(sql,new Object[] {
				emp.getEmpName(),emp.getEmpBirth(),
				emp.getGender(),emp.getEmpPolity(),emp.getEmpFolk(),
				emp.getEmpId(),emp.getEmpIndate(),emp.getEmpLeft(),
				emp.getEmpBirthplace(),emp.getEmpPhone(),emp.getEmpMail(),
				emp.getDeptName(),emp.getJobName(),emp.getEmpLearn(),
				emp.getEmpGraduate(),emp.getEmpGradate(),emp.getEmpSituation(),emp.getEmpNum()
		});
	}
	
	public List<EmployeeBean> selectEmp(String deptName, String jobName, String empId, String empName,int curPage){
		List<Map> list;
		
		if (deptName.equals("") && jobName.equals("") && empId.equals("") && empName.equals("")) {
			list = bs.getPage("select * from employee order by emp_num",curPage,9);
		}else if (!deptName.equals("") && jobName.equals("") && empId.equals("") && empName.equals("")) {
			list = bs.getPage("select * from employee where dep_name=? order by emp_num", new Object[] {deptName},curPage,9);
		}else if (deptName.equals("") && !jobName.equals("") && empId.equals("") && empName.equals("")) {
			list = bs.getPage("select * from employee where job_name=? order by emp_num", new Object[] {jobName},curPage,9);
		}else if (deptName.equals("") && jobName.equals("") && !empId.equals("") && empName.equals("")) {
			list = bs.getPage("select * from employee where emp_id=? order by emp_num", new Object[] {empId},curPage,9);
		}else if (deptName.equals("") && jobName.equals("") && empId.equals("") && !empName.equals("")) {
			list = bs.getPage("select * from employee where emp_name=? order by emp_num", new Object[] {empName},curPage,9);
		}else if (!deptName.equals("") && !jobName.equals("") && empId.equals("") && empName.equals("")) {
			list = bs.getPage("select * from employee where dep_name=? and job_name=? order by emp_num", new Object[] {deptName,jobName},curPage,9);
		}else if (!deptName.equals("") && jobName.equals("") && !empId.equals("") && empName.equals("")) {
			list = bs.getPage("select * from employee where dep_name=? and emp_id=? order by emp_num", new Object[] {deptName,empId},curPage,9);
		}else if (!deptName.equals("") && jobName.equals("") && empId.equals("") && !empName.equals("")) {
			list = bs.getPage("select * from employee where dep_name=? and emp_name order by emp_num", new Object[] {deptName,empName},curPage,9);
		}else if (deptName.equals("") && !jobName.equals("") && !empId.equals("") && empName.equals("")) {
			list = bs.getPage("select * from employee where job_name=? and emp_id=? order by emp_num", new Object[] {jobName,empId},curPage,9);
		}else if (deptName.equals("") && !jobName.equals("") && empId.equals("") && !empName.equals("")) {
			list = bs.getPage("select * from employee where job_name=? and emp_name=? order by emp_num", new Object[] {jobName,empName},curPage,9);
		}else if (deptName.equals("") && jobName.equals("") && !empId.equals("") && !empName.equals("")) {
			list = bs.getPage("select * from employee where emp_id=? and emp_name=? order by emp_num", new Object[] {empId,empName},curPage,9);
		}else if (!deptName.equals("") && !jobName.equals("") && !empId.equals("") && empName.equals("")) {
			list = bs.getPage("select * from employee where dep_name=? and job_name=? and emp_id=? order by emp_num", new Object[] {deptName,jobName,empId},curPage,9);
		}else if (!deptName.equals("") && !jobName.equals("") && empId.equals("") && !empName.equals("")) {
			list = bs.getPage("select * from employee where dep_name=? and job_name=? and emp_name=? order by emp_num", new Object[] {deptName,jobName,empName},curPage,9);
		}else if (deptName.equals("") && !jobName.equals("") && !empId.equals("") && !empName.equals("")) {
			list = bs.getPage("select * from employee where job_name=? and emp_id=? and emp_name=? order by emp_num", new Object[] {jobName,empId,empName},curPage,9);
		}else{
			list = bs.getPage("select * from employee where dep_name=? and job_name=? and emp_id=? order by emp_num", new Object[] {deptName,jobName,empId},curPage,9);
		}
		
		if (list == null || list.size() == 0) {
			return null;
		}

		List<EmployeeBean> empList=new ArrayList<EmployeeBean>();
		for(int i=0;i<list.size();i++){
			Map m=list.get(i);
			EmployeeBean emp=new EmployeeBean();
			emp.setEmpBirth((Date)m.get("EMP_BIRTH"));
			emp.setEmpBirthplace((String)m.get("EMP_BIRTHPLACE"));
			emp.setEmpFolk((String)m.get("EMP_FOLK"));
			emp.setEmpGradate((Date)m.get("EMP_GRADATE"));
			emp.setEmpGraduate((String)m.get("EMP_GRADUATE"));
			emp.setEmpId((String)m.get("EMP_ID"));
			emp.setEmpIndate((Date)m.get("EMP_INDATE"));
			emp.setEmpLearn((String)m.get("EMP_LEARN"));
			emp.setEmpLeft((Date)m.get("EMP_LEFT"));
			emp.setEmpMail((String)m.get("EMP_MAIL"));
			emp.setEmpName((String)m.get("EMP_NAME"));
			emp.setEmpNum((String)m.get("EMP_NUM"));
			emp.setEmpPhone((String)m.get("EMP_PHONE"));
			emp.setEmpPolity((String)m.get("EMP_POLITY"));
			emp.setEmpSituation((String)m.get("SITUATION"));
			emp.setDeptName((String)m.get("DEP_NAME"));
			emp.setGender((String)m.get("GENDER"));
			emp.setJobName((String)m.get("JOB_NAME"));
			empList.add(emp);
		}
		return empList;
	}
	
	public int pageRecNum(String deptName, String jobName, String empId, String empName){
		if (deptName.equals("") && jobName.equals("") && empId.equals("") && empName.equals("")) {
			return  bs.getPageCount("select * from employee",9);
		}else if (!deptName.equals("") && jobName.equals("") && empId.equals("") && empName.equals("")) {
			return  bs.getPageCount("select * from employee where dep_name=?", new Object[] {deptName},9);
		}else if (deptName.equals("") && !jobName.equals("") && empId.equals("") && empName.equals("")) {
			return  bs.getPageCount("select * from employee where job_name=?", new Object[] {jobName},9);
		}else if (deptName.equals("") && jobName.equals("") && !empId.equals("") && empName.equals("")) {
			return  bs.getPageCount("select * from employee where emp_id=?", new Object[] {empId},9);
		}else if (deptName.equals("") && jobName.equals("") && empId.equals("") && !empName.equals("")) {
			return  bs.getPageCount("select * from employee where emp_name=?", new Object[] {empName},9);
		}else if (!deptName.equals("") && !jobName.equals("") && empId.equals("") && empName.equals("")) {
			return  bs.getPageCount("select * from employee where dep_name=? and job_name=?", new Object[] {deptName,jobName},9);
		}else if (!deptName.equals("") && jobName.equals("") && !empId.equals("") && empName.equals("")) {
			return  bs.getPageCount("select * from employee where dep_name=? and emp_id=?", new Object[] {deptName,empId},9);
		}else if (!deptName.equals("") && jobName.equals("") && empId.equals("") && !empName.equals("")) {
			return  bs.getPageCount("select * from employee where dep_name=? and emp_name", new Object[] {deptName,empName},9);
		}else if (deptName.equals("") && !jobName.equals("") && !empId.equals("") && empName.equals("")) {
			return  bs.getPageCount("select * from employee where job_name=? and emp_id=?", new Object[] {jobName,empId},9);
		}else if (deptName.equals("") && !jobName.equals("") && empId.equals("") && !empName.equals("")) {
			return  bs.getPageCount("select * from employee where job_name=? and emp_name=?", new Object[] {jobName,empName},9);
		}else if (deptName.equals("") && jobName.equals("") && !empId.equals("") && !empName.equals("")) {
			return  bs.getPageCount("select * from employee where emp_id=? and emp_name=?", new Object[] {empId,empName},9);
		}else if (!deptName.equals("") && !jobName.equals("") && !empId.equals("") && empName.equals("")) {
			return  bs.getPageCount("select * from employee where dep_name=? and job_name=? and emp_id=?", new Object[] {deptName,jobName,empId},9);
		}else if (!deptName.equals("") && !jobName.equals("") && empId.equals("") && !empName.equals("")) {
			return  bs.getPageCount("select * from employee where dep_name=? and job_name=? and emp_name=?", new Object[] {deptName,jobName,empName},9);
		}else if (deptName.equals("") && !jobName.equals("") && !empId.equals("") && !empName.equals("")) {
			return  bs.getPageCount("select * from employee where job_name=? and emp_id=? and emp_name=?", new Object[] {jobName,empId,empName},9);
		}else{
			return  bs.getPageCount("select * from employee where dep_name=? and job_name=? and emp_id=?", new Object[] {deptName,jobName,empId},9);
		}
	}
	
	public List<EmployeeBean> selectAny(String value){
		List<Map> list;
		String sql;
		if(value.equals("")){
			sql="select * from employee";
			list= bs.getList(sql);
		}
		else{
			sql="select * from employee where emp_name like ? or dep_name like ? or job_name like ? or emp_num like ? or emp_phone like ? or situation like ? or emp_indate like ?";
			list= bs.getList(sql, new Object[]{value,value,value,value,value,value,value});
		}
		if (list == null || list.size() == 0) {
			return null;
		}

		List<EmployeeBean> empList=new ArrayList<EmployeeBean>();
		for(int i=0;i<list.size();i++){
			Map m=list.get(i);
			EmployeeBean emp=new EmployeeBean();
			emp.setEmpBirth((Date)m.get("EMP_BIRTH"));
			emp.setEmpBirthplace((String)m.get("EMP_BIRTHPLACE"));
			emp.setEmpFolk((String)m.get("EMP_FOLK"));
			emp.setEmpGradate((Date)m.get("EMP_GRADATE"));
			emp.setEmpGraduate((String)m.get("EMP_GRADUATE"));
			emp.setEmpId((String)m.get("EMP_ID"));
			emp.setEmpIndate((Date)m.get("EMP_INDATE"));
			emp.setEmpLearn((String)m.get("EMP_LEARN"));
			emp.setEmpLeft((Date)m.get("EMP_LEFT"));
			emp.setEmpMail((String)m.get("EMP_MAIL"));
			emp.setEmpName((String)m.get("EMP_NAME"));
			emp.setEmpNum((String)m.get("EMP_NUM"));
			emp.setEmpPhone((String)m.get("EMP_PHONE"));
			emp.setEmpPolity((String)m.get("EMP_POLITY"));
			emp.setEmpSituation((String)m.get("SITUATION"));
			emp.setDeptName((String)m.get("DEP_NAME"));
			emp.setGender((String)m.get("GENDER"));
			emp.setJobName((String)m.get("JOB_NAME"));
			empList.add(emp);
		}
		return empList;
	}
}

