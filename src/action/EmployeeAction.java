package action;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DeptService;
import service.EmployeeService;
import service.JobService;

import bean.DeptBean;
import bean.EmployeeBean;
import bean.JobBean;

public class EmployeeAction extends HttpServlet {
	EmployeeBean emp=new EmployeeBean();
	EmployeeService es=new EmployeeService();
	DeptService ds=new DeptService();
	JobService js=new JobService();

	public EmployeeAction() {
		super();
	}
	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		
		try {
			es.ed.bs.initConnection();
			if("select".equals(action)){
				selectEmp(request ,response);
			}
			else if(action.equals("delete")){
				deleteEmployee(request ,response);
			}
			else if(action.equals("edit")){
				editEmp(request ,response);
			}
			else if(action.equals("add")){
				addEmployee(request ,response);
			}
			else if("selectAny".equals(action)){
				selectAny(request,response);
			}
			else if(action.equals("selectAdd")){
				selectAdd(request,response);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			es.ed.bs.closeConnection();
		}
	}

	private void selectAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<DeptBean> depts=ds.selectDept("", "", "");
		List<JobBean> jobs=js.selectJob("", "", "");
		request.setAttribute("depts", depts);
		request.setAttribute("jobs", jobs);
			request.getRequestDispatcher("empadd.jsp").forward(request, response);
	}

	private void selectAny(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String value=(String)request.getParameter("value");
		int curPage=Integer.parseInt(request.getParameter("pageNum"));
		List<EmployeeBean> list = es.selectAny(value);
		int pageRecNum=1;
		if (list==null) {
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		} else if(list.size()!=0){
			request.setAttribute("list", list);
			request.setAttribute("pageRecNum", pageRecNum);
			request.getRequestDispatcher("emp.jsp").forward(request, response);
		}
	}

	private void selectEmp(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		String jobName = request.getParameter("jobName"); 
		String deptName = request.getParameter("deptName");
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		String type = request.getParameter("type");
		int pageNum=Integer.parseInt(request.getParameter("pageNum"));
		List<EmployeeBean> list = es.selectEmp(deptName, jobName, empId, empName,pageNum);
		int pageRecNum=es.pageRecCount(deptName, jobName, empId, empName);
		
		if (type.equals("list")) {
			if (list==null) {
				response.sendRedirect(request.getContextPath()+"/error.jsp");
			} else if(list.size()!=0){
				request.setAttribute("list", list);
				request.setAttribute("pageRecNum", pageRecNum);
				request.getRequestDispatcher("emp.jsp").forward(request, response);
			}
		}
		if(type.equals("detail")){
			if (list==null) {
				response.sendRedirect(request.getContextPath()+"/error.jsp");
			} else if(list.size()!=0){
				request.setAttribute("list", list);
				request.getRequestDispatcher("empinfo.jsp").forward(request, response);
			}
		}
		

	}

	private void editEmp(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		emp.setEmpNum(request.getParameter("empNum"));
		emp.setEmpBirth(Date.valueOf(request.getParameter("empBirth")));
		emp.setEmpBirthplace(request.getParameter("empBirthplace"));
		emp.setEmpFolk(request.getParameter("empFolk"));
		emp.setEmpGradate(Date.valueOf(request.getParameter("empGradate")));
		emp.setEmpGraduate(request.getParameter("empGraduate"));
		emp.setEmpId(request.getParameter("empId"));
		emp.setEmpIndate(Date.valueOf(request.getParameter("empIndate")));
		emp.setEmpLearn(request.getParameter("empLearn"));
		emp.setEmpLeft(Date.valueOf(request.getParameter("empLeft")));
		emp.setEmpMail(request.getParameter("empMail"));
		emp.setEmpName(request.getParameter("empName"));
		emp.setEmpPhone(request.getParameter("empPhone"));
		emp.setEmpPolity(request.getParameter("empPolity"));
		emp.setEmpSituation(request.getParameter("empSituation"));
		emp.setDeptName(request.getParameter("deptName"));
		emp.setGender(request.getParameter("gender"));
		emp.setJobName(request.getParameter("jobName"));
		es.editEmployee(emp);
		
	}

	private void deleteEmployee(HttpServletRequest request,
			HttpServletResponse response) {

	}

	private void addEmployee(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		emp.setEmpNum(request.getParameter("empNum"));
		emp.setEmpBirth(Date.valueOf(request.getParameter("empBirth")));
		emp.setEmpBirthplace(request.getParameter("empBirthplace"));
		emp.setEmpFolk(request.getParameter("empFolk"));
		emp.setEmpGradate(Date.valueOf(request.getParameter("empGradate")));
		emp.setEmpGraduate(request.getParameter("empGraduate"));
		emp.setEmpId(request.getParameter("empId"));
		emp.setEmpIndate(Date.valueOf(request.getParameter("empIndate")));
		emp.setEmpLearn(request.getParameter("empLearn"));
		emp.setEmpLeft(Date.valueOf(request.getParameter("empLeft")));
		emp.setEmpMail(request.getParameter("empMail"));
		emp.setEmpName(request.getParameter("empName"));
		emp.setEmpNum(request.getParameter("empNum"));
		emp.setEmpPhone(request.getParameter("empPhone"));
		emp.setEmpPolity(request.getParameter("empPolity"));
		emp.setEmpSituation(request.getParameter("empSituation"));
		emp.setDeptName(request.getParameter("deptName"));
		emp.setGender(request.getParameter("gender"));
		emp.setJobName(request.getParameter("jobName"));
	
		es.insertEmployee(emp);
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
