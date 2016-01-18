package service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import dao.ReportDao;

public class ReportService {
	public ReportDao rd=new ReportDao();
	
	public List<Map> newEmployeeReport(Date startDate,Date endDate,String deptName){
		return rd.newEmployeeReport(startDate, endDate, deptName);
	}
	
	public List<Map> disEmployeeReport(Date startDate,Date endDate,String deptName){
		return rd.disEmployeeReport(startDate, endDate, deptName);
	}
	
	public List<Map> hrReport(Date startDate,Date endDate){
		return rd.hrReport(startDate, endDate);
	}
}
