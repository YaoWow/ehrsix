<%@ page language="java" import="java.util.*,bean.JobBean" pageEncoding="UTF-8"%>
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
  <%
  List<JobBean> joblist = (List<JobBean>)request.getAttribute("list");
  JobBean job=joblist.get(0);
  %>
 
 
		<div class="container-fluid">
		
  			  <ol class="breadcrumb">
  			    <li><a onclick="job()">岗位管理</a></li>
  				<li class="active">岗位修改</li>
			  </ol>
  			
  			<form action="" method="post">
				     		  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">岗位编号:</label>
							   	<div class="col-md-8">
							    <input type="text" class="form-control" id="jobNum" value="<%= job.getJobNumber() %>" disabled>
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  			
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">岗位名称:</label>
							   	<div class="col-md-8">
							    <input type="text" class="form-control" id="jobName" value="<%= job.getJobName() %>">
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">岗位类型:</label>
							   	<div class="col-md-8">
									<select id="jobType" class="form-control" value="<%= job.getJobType() %>" disabled>
									<option value="技术">技术</option>
									<option value="管理">管理</option>
									<option value="营销">营销</option>
									<option value="市场">市场</option>
									</select>
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">岗位编制:</label>
							   	<div class="col-md-8">
							    <input type="text" class="form-control" id="jobMax" value="<%= job.getJobMax() %>">
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">在岗人员:</label>
							   	<div class="col-md-8">
							    <input type="text" class="form-control" id="jobManNum" value="<%= job.getJobMannum() %>" disabled>
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<div class="col-md-10">
							    <button type="button" onclick="jobEditSave()" class="btn btn-success btn-block">保存</button>
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  
							</form>
		
		</div><!-- /.container-fluid -->
		
  </body>
</html>
