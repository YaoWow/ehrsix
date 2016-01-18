package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ReportService;

public class ReportAction extends HttpServlet {
	
	ReportService rs=new ReportService();
	Date startDate=Date.valueOf("1970-01-01");
	Date endDate=Date.valueOf("2100-01-01");
	
	/**
	 * Constructor of the object.
	 */
	public ReportAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
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
		String type=request.getParameter("type");
		try {
			rs.rd.bs.initConnection();
			if(type.equals("newEmpReport")){
				
				newEmpReport(request,response);
			}
			else if(type.equals("disEmpReport")){
				disEmpReport(request,response);
			}
			else if("hrReport".equals(type)){
				hrReport(request,response);
			}
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			rs.rd.bs.closeConnection();
		}
		
		
	}

	private void hrReport(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(!request.getParameter("startDate").equals("")){
			startDate=Date.valueOf(request.getParameter("startDate"));
		}
		if(!request.getParameter("endDate").equals("")){
			endDate=Date.valueOf(request.getParameter("endDate"));
		}
		List<Map> report=rs.hrReport(startDate, endDate);
		if (report==null) {
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		} 
		else{
			request.setAttribute("report", report);
			request.getRequestDispatcher("monthReport.jsp").forward(request, response);
			
		}
		
	}

	private void disEmpReport(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(!request.getParameter("startDate").equals("")){
			startDate=Date.valueOf(request.getParameter("startDate"));
		}
		if(!request.getParameter("endDate").equals("")){
			endDate=Date.valueOf(request.getParameter("endDate"));
		}
		String deptName=request.getParameter("deptName");
		List<Map> report=rs.disEmployeeReport(startDate, endDate, deptName);
		if (report==null) {
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		} 
		else{
			request.setAttribute("report", report);
			request.getRequestDispatcher("leftReport.jsp").forward(request, response);
			
		}
	}

	private void newEmpReport(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(!request.getParameter("startDate").equals("")){
			startDate=Date.valueOf(request.getParameter("startDate"));
		}
		if(!request.getParameter("endDate").equals("")){
			endDate=Date.valueOf(request.getParameter("endDate"));
		}
		
		String deptName=request.getParameter("deptName");
		List<Map> report=rs.newEmployeeReport(startDate, endDate, deptName);
		if (report==null) {
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		} 
		else{
			request.setAttribute("report", report);
			request.getRequestDispatcher("inReport.jsp").forward(request, response);
			
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
