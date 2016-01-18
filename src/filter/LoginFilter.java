package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		req.getServletPath();//login.jsp
		req.getContextPath();//ehrsix
		String actionUrl = req.getServletPath();
		HttpSession session = req.getSession();
		if ("/login.jsp".equals(actionUrl)
				|| "/LoginAction".equals(actionUrl)
				|| "/test.jsp".equals(actionUrl)
				|| "/error.jsp".equals(actionUrl)
				|| actionUrl.endsWith("css")
				|| actionUrl.endsWith("js")
				)
				{
		}else {
			String userName = (String) session.getAttribute("userName");
			if (userName==null||userName.equals("")) {
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
		}
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
