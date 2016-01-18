<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.EmployeeBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>岗位修改</title>
    

  </head>
  
  <body>
		
  			 <table class="table table-hover">
				<tr class="active">
					<th>序号</th>
					<th>部门名称</th>
					<th>岗位名称</th>
					<th>姓名</th>
					<th>性别</th>
					<th>入职时间</th>
					<th>学历</th>
				</tr>
				
  <%
  int i=0;
  List<Map> report=(List<Map>)request.getAttribute("report");
  for(Map m : report){
  %>

				<tr>
					<td><%=i++ %></td>
					<td><%=m.get("DEP_NAME") %></td>
					<td><%=m.get("JOB_NAME") %></td>
					<td><%=m.get("EMP_NAME") %></td>
					<td><%=m.get("GENDER") %></td>
					<td><%=m.get("EMP_INDATE") %></td>
					<td><%=m.get("EMP_LEARN") %></td>
				</tr>

  <%
  }
  %>				

			</table>
		
		
  </body>
</html>
