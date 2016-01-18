package dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.BaseService;

public class ReportDao {
	public BaseService bs=new BaseService();
	
	public List<Map> newEmployeeReport(Date startDate,Date endDate,String deptName){
		String sql;
		if(deptName.equals("") || deptName==null){
			sql="select dep_name,job_name,emp_name,gender,emp_indate,emp_learn"+
					" from employee where emp_indate between ? and ? order by dep_name,job_name";
			return bs.getList(sql, new Object[] {startDate,endDate});
		}
		else{
			sql="select dep_name,job_name,emp_name,gender,emp_indate,emp_learn"+
			" from employee where dep_name=? and (emp_indate between ? and ?) order by job_name";
			return bs.getList(sql, new Object[] {deptName,startDate,endDate});
		}
	
	}
	
	public List<Map> disEmployeeReport(Date startDate,Date endDate,String deptName){
		String sql;
		if(deptName.equals("") || deptName==null){
			sql="select dep_name,job_name,emp_name,gender,emp_left"+
			" from employee where emp_left between ? and ? order by dep_name,job_name";
			return bs.getList(sql, new Object[] {startDate,endDate});
		}
		else{
			sql="select dep_name,job_name,emp_name,gender,emp_left"+
			" from employee where dep_name=? and (emp_left between ? and ?) order by job_name";
			return bs.getList(sql, new Object[] {deptName,startDate,endDate});
		}
	}
	
	public List<Map> hrReport(Date startDate,Date endDate){
		
		List<Map> hrReport=new ArrayList();
		

		List<Map> dept=bs.getList("select dep_name from department");
		for (Map m : dept){
			Map deptHrReport=new HashMap();

			deptHrReport.put("depName",m.get("DEP_NAME"));

			String startMonthNum="select count(1) startNum from employee where dep_name=? and emp_indate<=? and emp_left>?";
			String endMonthNum="select count(1) endNum from employee where dep_name=? and emp_indate<=? and emp_left>?";
			String leftMonthNum="select count(1) leftNum from employee where dep_name=? and (emp_left between ? and ?)";
			String inMonthNum="select count(1) inNum from employee where dep_name=? and (emp_indate between ? and ?) and emp_left>?";
			String postGraduate="select count(1) postGraduate from employee where dep_name=? and emp_learn='研究生'";
			String graduate="select count(1) graduate from employee where dep_name=? and emp_learn='本科'";
			String juniorGraduate="select count(1) juniorGraduate from employee where dep_name=? and emp_learn='大专'";
			String other="select count(1) other from employee where dep_name=? and emp_learn='高中及以下'";
			
			
//			String learnSql="select emp_learn,count(emp_learn) num from employee where dep_name=? group by emp_learn";
			deptHrReport.put("startMonthNum",bs.getSingleRow(startMonthNum, new Object[]{m.get("DEP_NAME"),startDate,startDate}).get("STARTNUM"));
			deptHrReport.put("endMonthNum",bs.getSingleRow(endMonthNum, new Object[]{m.get("DEP_NAME"),endDate,endDate}).get("ENDNUM"));
			deptHrReport.put("leftMonthNum",bs.getSingleRow(leftMonthNum, new Object[]{m.get("DEP_NAME"),startDate,endDate}).get("LEFTNUM"));
			deptHrReport.put("inMonthNum",bs.getSingleRow(inMonthNum, new Object[]{m.get("DEP_NAME"),startDate,endDate,endDate}).get("INNUM"));
			deptHrReport.put("postGraduate",bs.getSingleRow(postGraduate, new Object[]{m.get("DEP_NAME")}).get("POSTGRADUATE"));
			deptHrReport.put("graduate",bs.getSingleRow(graduate, new Object[]{m.get("DEP_NAME")}).get("GRADUATE"));
			deptHrReport.put("juniorGraduate",bs.getSingleRow(juniorGraduate, new Object[]{m.get("DEP_NAME")}).get("JUNIORGRADUATE"));
			deptHrReport.put("other",bs.getSingleRow(other, new Object[]{m.get("DEP_NAME")}).get("OTHER"));
			

			hrReport.add(deptHrReport);
		}
		return hrReport;
	}
}
