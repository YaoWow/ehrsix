package action;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogoutAction extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{
	request.getSession().invalidate();
	response.getWriter().println("���Ѿ���ȫ�˳���¼��");
	response.sendRedirect("login.jsp");
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{
	doGet(request, response );
}


}
