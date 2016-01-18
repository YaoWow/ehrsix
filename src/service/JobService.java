package service;

import java.util.List;
import java.util.Map;

import bean.JobBean;
import dao.JobDao;

public class JobService {
	
	public JobDao jd = new JobDao();
	JobBean jb=new JobBean();
	BaseService bs = new BaseService();

	
	public int addJob(JobBean job) {
		List<JobBean> list = selectJob("", job.getJobNumber(), "" );
		//前端需要判断限定不能为空

		if(list!=null) {
			return -2;  //"-2"表示编号已存在；
		}

		return jd.insertJob(job);
		
	}
	
	public int deleteJob(String jobNumber) {
		
		/*if(Integer.parseInt(jobMannum)!=0) {
			return -1; //"-1"表示岗位人数不为0，不可删除；
		}*/
		
		return jd.deleteJob(jobNumber);
	}
	
	public int editJob(JobBean job) {
		
		return jd.updateJob(job);
	} 
	
	public int autoEditJob(String jobName) {
		
		//List<JobBean> list = selectJob("", "", jobName);
		List<Map> list;
		list = bs.getList("select * from job where job_Name=?", new Object[] {jobName});
		Map m= list.get(0);
		return jd.autoEditJob(jobName, (String) m.get("JOB_MANNUM"));
			
	}
	
	
	public List<JobBean> selectJob(String jobType, String jobNum, String jobName) {
		return jd.selectJob(jobType, jobNum, jobName);

	}
		
}
