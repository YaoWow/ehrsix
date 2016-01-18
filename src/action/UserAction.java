package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;

import service.UserService;

public class UserAction extends HttpServlet {
	UserService us=new UserService();
	UserBean ub;
	/**
	 * Constructor of the object.
	 */
	public UserAction() {
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
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		try {
			us.ud.bs.initConnection();
			if(action.equals("addUser")){
				addUser(request,response);
			}
			else if(action.equals("deleteUser")){
				deleteUser(request,response);
			}
			else if(action.equals("editUser")){
				editUser(request,response);
			}
			else if(action.equals("listAllUser")){
				listAllUser(request,response);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			us.ud.bs.closeConnection();
		}
	}

	private void listAllUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		request.setAttribute("list", us.listAllUser());
		if (type.equals("edit")) {
			request.getRequestDispatcher("adminedit.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("admincontent.jsp").forward(request, response);
		}
		
	}

	private void editUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		us.editUser(request.getParameter("userName"), 
					request.getParameter("userType"), 
					request.getParameter("userPwd"));
	}

	private void deleteUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		us.deleteUser(request.getParameter("userName"));
	}

	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		us.addUser(request.getParameter("adminName"), 
					request.getParameter("adminType"),	
					request.getParameter("adminPwd") 
					);
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
