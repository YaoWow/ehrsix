package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.JobBean;

import service.JobService;

public class JobAction extends HttpServlet {
	
	JobService js=new JobService();

	public JobAction() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		
		try {
			js.jd.bs.initConnection();
			if (action.equals("select")) {
				selectJob(request, response);
			} else if(action.equals("insert")) {
				addJob(request, response);
			} else if(action.equals("delete")) {
				delJob(request,response);
			} else if(action.equals("edit")) {
				editJob(request,response);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			js.jd.bs.closeConnection();
		}

	}
	
	public void delJob(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		String deljobnumber=request.getParameter("jobNum");
		
		js.deleteJob(deljobnumber);
		request.getRequestDispatcher("jobcontent.jsp").forward(request, response);
		
	}
	
	public void editJob(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		
		String editjobnumber=request.getParameter("jobNum");
		String editjobname=request.getParameter("jobName");
		String editjobmax=request.getParameter("jobMax");
		String editjobtype=request.getParameter("jobType");
		String editjobmannum=request.getParameter("jobManNum");
		
		JobBean job=new JobBean(editjobnumber,editjobname,editjobtype,
				editjobmannum,editjobmax);
		
		js.editJob(job);
		
	}
	
	public void addJob(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String addjobnumber=request.getParameter("jobNum");
		String addjobname=request.getParameter("jobName");
		String addjobmax=request.getParameter("jobMax");
		String addjobtype=request.getParameter("jobType");
		String addjobmannum=request.getParameter("jobManNum");
		JobBean job=new JobBean(addjobnumber,addjobname,addjobtype,
				addjobmannum,addjobmax);
		int rv=js.addJob(job);
		if(rv==-2) {
		}
		
	}
	
	public void selectJob(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String jobType = request.getParameter("jobType"); 
		String jobNum = request.getParameter("jobNum");
		String jobName = request.getParameter("jobName");
		String result = request.getParameter("result");
		List<JobBean> list = js.selectJob(jobType, jobNum, jobName);
		
		if (list == null) {
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		} else if (list.size() != 0) {
			request.setAttribute("list", list);
			if (result.equals("edit")) {
				request.getRequestDispatcher("jobedit.jsp").forward(request,response);
			} else if(result.equals("add")){
				request.getRequestDispatcher("jobcreate.jsp").forward(request,response);
			} else {
				request.getRequestDispatcher("jobcontent.jsp").forward(request,response);
			}
		}
		
	}
	

	public void init() throws ServletException {

	}

}
