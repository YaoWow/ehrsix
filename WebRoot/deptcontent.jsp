<%@ page language="java" import="java.util.*,bean.DeptBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<DeptBean> list=(List<DeptBean>)request.getAttribute("listAllDept");
String userType=(String)request.getSession().getAttribute("userType");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
  </head>
  
  <body>
			
			<table class="table table-hover">
				<tr class="active">
					<th>部门编号</th>
					<th>部门名称</th>
					<th>部门类型</th>
					<th>电话</th>
					<th>描述</th>
					<th>上级部门</th>
					<th>成立日期</th>
					<th>操作</th>
				</tr>
  <%
  List<DeptBean> deptlist = (List<DeptBean>)request.getAttribute("list");
  for(DeptBean dept : deptlist){
  %>
				<tr>
					<td><%=dept.getDeptNumber() %></td>
					<td><%=dept.getDeptName() %></td>
					<td><%=dept.getDeptType() %></td>
					<td><%=dept.getDeptTel() %></td>
					<td><%=dept.getDeptDesc() %></td>
					<td><%=dept.getDeptSuper() %></td>
					<td><%=dept.getDeptSetdate() %></td>
					<td>
						<a style="cursor:pointer" onclick="deptEdit('<%=dept.getDeptNumber() %>')">编辑</a>
						<%if(userType.equals("人事总监")){
						 %>
						<a style="cursor:pointer" onclick="deptDelete('<%=dept.getDeptNumber() %>')">删除</a>
						<%} %>
					</td>
				</tr>
				<%
				}
				 %>
			</table>
						  
		
  </body>
</html>