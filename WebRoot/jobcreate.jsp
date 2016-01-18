<%@ page language="java" import="java.util.*,bean.JobBean" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>创建岗位</title>
    <script src="js/validate.js"></script>
  </head>
  
  <body>

		<div class="container-fluid">
		
  			  <ol class="breadcrumb">
  			    <li><a onclick="job()">岗位管理</a></li>
  				<li class="active">创建岗位</li>
			  </ol>
  			
  			<form>
				     		  
			  <div class="form-group">
			  <div class="row">
			  	<div class="col-md-1"></div>
			   	<label class="col-md-2 control-label">岗位编号:</label>
			   	<div class="col-md-8">
			    <input type="text" class="form-control" id="jobNum">
			    </div>
			    <div class="col-md-1"></div>
			   </div>
			  </div>
			  			
			  <div class="form-group">
			  <div class="row">
			  	<div class="col-md-1"></div>
			   	<label class="col-md-2 control-label">岗位名称:</label>
			   	<div class="col-md-8">
			    <input type="text" class="form-control" id="jobName">
			    </div>
			    <div class="col-md-1"></div>
			   </div>
			  </div>
			  
			  <div class="form-group">
			  <div class="row">
			  	<div class="col-md-1"></div>
			   	<label class="col-md-2 control-label">岗位类型:</label>
			   	<div class="col-md-8">
					<select id="jobType" class="form-control">
					<option value="技术">技术</option>
					<option value="管理">管理</option>
					<option value="营销">营销</option>
					<option value="市场">市场</option>
					<option value="产品">产品</option>
					<option value="行政">行政</option>
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
			    <input type="text" class="form-control" id="jobMax">
			    </div>
			    <div class="col-md-1"></div>
			   </div>
			  </div>
			  
			  <div class="form-group">
			  <div class="row">
			  	<div class="col-md-1"></div>
			   	<label class="col-md-2 control-label">在岗人员:</label>
			   	<div class="col-md-8">
			    <input type="text" class="form-control" id="jobManNum" value="0" disabled>
			    </div>
			    <div class="col-md-1"></div>
			   </div>
			  </div>
			  
			  
			  <div class="form-group">
			  <div class="row">
			  	<div class="col-md-1"></div>
			   	<div class="col-md-10">
			    <button type="button" onclick="jobCreate()" class="btn btn-success btn-block">创建</button>
			    </div>
			    <div class="col-md-1"></div>
			   </div>
			  </div>
			  
			</form>
		
		</div><!-- /.container-fluid -->
		
  </body>
</html>
