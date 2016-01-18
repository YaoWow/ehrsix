<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>岗位修改</title>  
    <script>
    $(document).ready(function(){
	
	$("#admin").click(function(){
	$("#content").load("admincenter.jsp");
	});
	
	});
	</script>
	<script src="js/validate.js"></script>
  </head>
  
  <body>
  
		<div class="container-fluid">
		
  			  <ol class="breadcrumb">
  			    <li><a id="admin">管理员中心</a></li>
  				<li class="active">创建管理员</li>
			  </ol>
  			
  			<form action="" method="post">
				     		  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">管理员类型:</label>
							   	<div class="col-md-8">
							    <select class="form-control" id="adminType">
									<option value="人事总监">人事总监</option>
									<option value="人事专员">人事专员</option>
								</select>
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  			
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">用户名:</label>
							   	<div class="col-md-8">
							    <input type="text" class="form-control" id="adminName" placeholder="用户名一旦创建不可修改！">
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">密码:</label>
							   	<div class="col-md-8">
							    <input type="password" class="form-control" id="adminPwd">
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>							  
							  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<div class="col-md-10">
							    <button type="button" onclick="adminCreate()" class="btn btn-success btn-block">保存</button>
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  
							</form>
		
		</div><!-- /.container-fluid -->
		
  </body>
</html>
