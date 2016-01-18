<%@ page language="java" import="java.util.*,bean.JobBean" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
					<th>岗位编号</th>
					<th>岗位名称</th>
					<th>岗位类型</th>
					<th>岗位编制</th>
					<th>在岗人员</th>
					<th>操作</th>
				</tr>
  <%
  List<JobBean> list = (List<JobBean>)request.getAttribute("list");
  for(JobBean job : list){
  %>
				<tr>
					<td><%= job.getJobNumber() %></td>
					<td><%= job.getJobName() %></td>
					<td><%= job.getJobType() %></td>
					<td><%= job.getJobMax() %></td>
					<td><%= job.getJobMannum() %></td>
					<td>
						<a style="cursor:pointer" onclick="jobEdit('<%= job.getJobNumber() %>')">编辑</a>
						<%if(userType.equals("人事总监")){ %>
						<a style="cursor:pointer" onclick="isJobDelete('<%= job.getJobNumber()%>','<%= job.getJobMannum() %>')">删除</a>
						<%} %>
					</td>
				</tr>
  <%
  }
  %>
						  
				</table>	
  </body>
</html>