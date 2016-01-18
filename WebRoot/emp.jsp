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
					<th>员工编号</th>
					<th>姓名</th>
					<th>所在部门</th>
					<th>岗位</th>
					<th>联系电话</th>
					<th>入职时间</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				
  <%
  int pageRecNum=0;
  pageRecNum=(Integer)request.getAttribute("pageRecNum");
  List<EmployeeBean> list = (List<EmployeeBean>)request.getAttribute("list");
  for(EmployeeBean emp : list){
  %>

				<tr>
					<td><%=emp.getEmpNum() %></td>
					<td><%=emp.getEmpName() %></td>
					<td><%=emp.getDeptName() %></td>
					<td><%=emp.getJobName() %></td>
					<td><%=emp.getEmpPhone() %></td>
					<td><%=emp.getEmpIndate() %></td>
					<td><%=emp.getEmpSituation() %></td>
					<td><a style="cursor:pointer" onclick="empInfo('<%=emp.getEmpName() %>')">详细信息</a></td>
				</tr>

  <%
  }
  %>				
			</table>
			<center>
			<nav>
			  <ul class="pagination pagination-sm" style="margin-top:-10px;margin-bottom:50px">
			    <li><a onclick="showPage(1)" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
			    <li><a onclick="showPage(1)">1 <span class="sr-only">(current)</span></a></li>
			    <% 
			    int k=1;
			    int j=1;
			    for(int i=1;i<pageRecNum;i++){
			     %>
			    <li ><a onclick="showPage(<%=++k %>)"><%=++j %> <span class="sr-only"></span></a></li>
			    <%}
			     %>
			    <li><a onclick="showPage(<%=pageRecNum %>)" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
			  </ul>
			</nav>
			</center>
		
  </body>
</html>
