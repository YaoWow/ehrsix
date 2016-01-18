<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.UserBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">     
  </head>
  
  <body>
    			<table class="table table-hover">
				<tr class="active">
					<th>用户名</th>
					<th>管理员类型</th>
					<th>操作</th>
				</tr>
  <%
  List<UserBean> list = (List<UserBean>)request.getAttribute("list");
  for(UserBean user : list){
  %>
				<tr>
					<td><%= user.getUserName() %></td>
					<td><%= user.getUserType() %></td>
					<td>
						<a style="cursor:pointer" onclick="adminEdit('<%= user.getUserName() %>')" >编辑</a>
						<a style="cursor:pointer" onclick="adminDelete('<%= user.getUserName() %>')" >删除</a>
					</td>
				</tr>
  <%
  }
  %>
						  
				</table>	
  </body>
</html>