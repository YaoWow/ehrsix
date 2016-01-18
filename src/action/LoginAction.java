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

public class LoginAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginAction() {
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

		doPost(request, response);
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
		
		
		String adminId = request.getParameter("adminId");
		String adminPwd = request.getParameter("adminPwd");
		String adminType = request.getParameter("adminType");
		
		UserService us = new UserService();
		try {
			us.ud.bs.initConnection();
			int rv = us.login(adminId, adminType, adminPwd);	
			switch (rv){
				case 1:{
					request.getSession().setAttribute("userName", adminId);
					request.getSession().setAttribute("userType", adminType);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					break;
				}
				case 2:{
					request.getSession().setAttribute("userName", adminId);
					request.getSession().setAttribute("userType", adminType);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					break;
				}
				case -1:{
					request.setAttribute("loginInfo", "用户名不存在！");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					break;
				}
				case -2:{
					request.setAttribute("loginInfo", "您不是人事总监！");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					break;
				}
				case -3:{
					request.setAttribute("loginInfo", "密码错误！");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					break;
				}
			}
			
			
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			us.ud.bs.closeConnection();
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
