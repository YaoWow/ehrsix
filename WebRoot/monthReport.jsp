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
    <title>人事月报</title>
    

  </head>
  
  <body>
		
  			 <table class="table table-hover">
				<tr class="active">
					<th rowspan=2 >部门名称</th>
					<th colspan=4>人数统计</th>
					<th colspan=4>学历统计</th>
					</tr>
					<tr>
					<th>月初人数</th>
					<th>月末人数</th>
					<th>本月新入职</th>
					<th>本月离职</th>
					<th>研究生</th>
					<th>本科</th>
					<th>大专</th>
					<th>高中及以下</th>
				</tr>
				
  <%
  int i=0;
  List<Map> report = (List<Map>)request.getAttribute("report");
  for(Map m : report){
  %>

				<tr>
					<td><%=m.get("depName") %></td>
					<td><%=m.get("startMonthNum") %></td>
					<td><%=m.get("endMonthNum") %></td>
					<td><%=m.get("inMonthNum") %></td>
					<td><%=m.get("leftMonthNum") %></td>
					<td><%=m.get("postGraduate") %></td>
					<td><%=m.get("graduate") %></td>
					<td><%=m.get("juniorGraduate") %></td>
					<td><%=m.get("other") %></td>
				</tr>

  <%
  }
  %>				

			</table>
		
		
  </body>
</html>
