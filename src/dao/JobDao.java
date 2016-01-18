package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import bean.JobBean;
import service.BaseService;

public class JobDao {
	
	public BaseService bs=new BaseService();
	
	/**
	 * 插入语句
	 * @param job
	 * @return
	 */
	
	public int insertJob(JobBean job) {
		
		String sql="insert into job (job_number,job_name,job_type,job_mannum,job_max) values (?,?,?,?,?)";
		return bs.update(sql, new Object[] {
				job.getJobNumber(),job.getJobName(),job.getJobType(),
				job.getJobMannum(),job.getJobMax()
				});
	}
	
	/**
	 * 删除语句
	 * @param job
	 * @return
	 */
	
	public int deleteJob(String jobNumber) {
		
		String sql="delete from job where JOB_NUMBER=?";
		return bs.update(sql, new Object[]{jobNumber});
		
	}
	
	/**
	 * 修改语句
	 * @param job
	 * @return
	 */
	
	public int updateJob(JobBean job) {
		
		String sql="update job set job_name=?,job_type=?,job_mannum=?," +
				"job_max=? where job_Number=?";
		return bs.update(sql, new Object[] {
				job.getJobName(),job.getJobType(),
				job.getJobMannum(),job.getJobMax(),job.getJobNumber()
				});
		
	}
	
	/**
	 * 自增修改
	 */
	
	public int autoEditJob(String jobName,String jobMannum) {
		
		int jobMannum1 = Integer.parseInt(jobMannum)+1;
		String jobMannum2 = String.valueOf(jobMannum1);
		String sql="update job set job_mannum=? where job_name=?";
		return bs.update(sql, new Object[]{jobMannum2,jobName});
	}
	
	/**
	 * 查询语句
	 * @param jobNumber
	 * @return
	 */
	
	public List<JobBean> selectJob(String jobType, String jobNum, String jobName) {
		
		List<Map> list;
		if (jobType.equals("") && jobNum.equals("") && jobName.equals("")) {
			list = bs.getList("select * from job  order by job_number");
		}else if (!jobType.equals("") && jobNum.equals("") && jobName.equals("")) {
			list = bs.getList("select * from job where job_Type=?  order by job_number", new Object[] {jobType});
		}else if (jobType.equals("") && !jobNum.equals("") && jobName.equals("")) {
			list = bs.getList("select * from job where job_Number=?  order by job_number", new Object[] {jobNum});
		}else if (jobType.equals("") && jobNum.equals("") && !jobName.equals("")) {
			list = bs.getList("select * from job where job_Name=?  order by job_number", new Object[] {jobName});
		}else if (!jobType.equals("") && !jobNum.equals("") && jobName.equals("")) {
			list = bs.getList("select * from job where job_Type=? and job_Number=?  order by job_number", new Object[] {jobType,jobNum});
		}else if (!jobType.equals("") && jobNum.equals("") && !jobName.equals("")) {
			list = bs.getList("select * from job where job_Type=? and job_Name=?  order by job_number", new Object[] {jobType,jobName});
		}else if (jobType.equals("") && !jobNum.equals("") && !jobName.equals("")) {
			list = bs.getList("select * from job where job_Number=? and job_Name=?  order by job_number", new Object[] {jobNum,jobName});
		}else {
			list = bs.getList("select * from job where job_Type=? and job_Number=? and job_Name=?  order by job_number", new Object[] {jobType,jobNum,jobName});
		} 
		if (list == null || list.size() == 0) {
			return null;
		}
		List<JobBean> jobs = new ArrayList();
		JobBean job=new JobBean();
		for (int i = 0; i < list.size(); i++) {
			Map m = list.get(i);
			job = new JobBean(
					(String) m.get("JOB_NUMBER"), (String) m.get("JOB_NAME"), 
					(String) m.get("JOB_TYPE"), (String) m.get("JOB_MANNUM"), 
					(String) m.get("JOB_MAX"));
			jobs.add(job);
		}
		return jobs;

	}


}
