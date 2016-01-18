package bean;

import java.io.Serializable;

public class JobBean implements Serializable{
	//岗位编号
	private String jobNumber;
	//岗位名称
	private String jobName;
	//岗位类型
	private String jobType;
	//岗位下人数
	private String jobMannum;
	//岗位编制
	private String jobMax;
	
	
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getJobMannum() {
		return jobMannum;
	}
	public void setJobMannum(String jobMannum) {
		this.jobMannum = jobMannum;
	}
	public String getJobMax() {
		return jobMax;
	}
	public void setJobMax(String jobMax) {
		this.jobMax = jobMax;
	}
	public JobBean() {
		
	}
	
	public JobBean(String jobNumber,String jobName,String jobType,
			String jobMannum,String jobMax) {
		
		this.jobNumber=jobNumber;
		this.jobName=jobName;
		this.jobType=jobType;
		this.jobMannum=jobMannum;
		this.jobMax=jobMax;
	}
	
}
