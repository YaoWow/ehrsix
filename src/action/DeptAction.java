package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DeptService;

import com.sun.org.apache.bcel.internal.generic.Select;

import bean.DeptBean;

public class DeptAction extends HttpServlet {

	DeptService ds=new DeptService();
	
	/**
	 * Constructor of the object.
	 */
	public DeptAction() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		try {
			ds.dd.bs.initConnection();
			if(action.equals("select")){
				selectDept(request,response);
			}else if("add".equals(action)){
				addDept(request,response);
			}else if(action.equals("delete")){
				deleteDept(request,response);
			}else if("edit".equals(action)){
				editDept(request,response);
			}
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			ds.dd.bs.closeConnection();
		}
		
	}


	private void editDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String deptNumber=request.getParameter("deptNumber");
		String deptName=request.getParameter("deptName");
		String deptType=request.getParameter("deptType");
		String deptTel=request.getParameter("deptTel");
		String deptSuper=request.getParameter("deptSuper");
		String deptDesc=request.getParameter("deptDesc");
		Date deptSetdate=Date.valueOf(request.getParameter("deptSetdate"));
		
		DeptBean dept=new DeptBean(deptNumber,deptName,deptType,deptTel,deptSuper,deptDesc,deptSetdate);
		ds.editDept(dept);
	}

	private void deleteDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String deptNumber=request.getParameter("deptNumber");
		int result=ds.deleteDept(deptNumber);
		if (result==0) {
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		} else{
			request.getRequestDispatcher("deptcontent.jsp").forward(request, response);
		}
	}

	private void addDept(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String deptNumber=request.getParameter("deptNumber");
		String deptName=request.getParameter("deptName");
		String deptType=request.getParameter("deptType");
		String deptDel=request.getParameter("deptTel");
		String deptSuper=request.getParameter("deptSuper");
		String deptDesc=request.getParameter("deptDesc");
		Date deptSetdate=Date.valueOf((request.getParameter("deptSetdate")));
		
		DeptBean dept=new DeptBean(deptNumber,deptName,deptType,deptDel,deptSuper,deptDesc,deptSetdate);
		ds.addDept(dept);
		
	}
	
	public void selectDept(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String deptType = request.getParameter("deptType"); 
		String deptNum = request.getParameter("deptNum");
		String deptName = request.getParameter("deptName");
		String result=request.getParameter("result");
		List<DeptBean> list = ds.selectDept(deptType, deptNum, deptName);
		if (list==null) {
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		} else if(list.size()!=0){
			request.setAttribute("list", list);
			if(result.equals("edit")){
				request.getRequestDispatcher("deptedit.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("deptcontent.jsp").forward(request, response);
			}
		}
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	
	

}
