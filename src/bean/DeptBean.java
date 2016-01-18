package bean;

import java.io.Serializable;
import java.sql.Date;

public class DeptBean implements Serializable{
	
	//锟斤拷锟脚憋拷锟�
	private String deptNumber;
	//锟斤拷锟斤拷锟斤拷锟�
	private String deptName;
	//锟斤拷锟斤拷锟斤拷锟斤拷
	private String deptType;
	//锟界话
	private String deptTel;
	//锟较硷拷锟斤拷锟斤拷
	private String deptSuper;
	//锟斤拷锟斤拷
	private String deptDesc;
	//锟斤拷锟斤拷锟斤拷锟斤拷
	private Date deptSetdate;
	public String getDeptNumber() {
		return deptNumber;
	}
	public void setDeptNumber(String deptNumber) {
		this.deptNumber = deptNumber;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptType() {
		return deptType;
	}
	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}
	public String getDeptTel() {
		return deptTel;
	}
	public void setDeptTel(String deptTel) {
		this.deptTel = deptTel;
	}
	public String getDeptSuper() {
		return deptSuper;
	}
	public void setDeptSuper(String deptSuper) {
		this.deptSuper = deptSuper;
	}
	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	public Date getDeptSetdate() {
		return deptSetdate;
	}
	
	public DeptBean() {
		
	}
	
	
	public DeptBean(String deptNumber,String deptName,String deptType, 
			String deptTel,String deptSuper,String deptDesc,Date deptSetdate) {
		
		this.deptNumber=deptNumber;
		this.deptName=deptName;
		this.deptType=deptType;
		this.deptTel=deptTel;
		this.deptSuper=deptSuper;
		this.deptDesc=deptDesc;
		this.deptSetdate=deptSetdate;
	}
	public void setDeptSetdate(String parameter) {
		// TODO Auto-generated method stub
		
	}
	
}
