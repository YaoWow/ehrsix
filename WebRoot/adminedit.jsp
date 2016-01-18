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
    <title>岗位修改</title>
  </head>

  <body>

  <%
  List<UserBean> list = (List<UserBean>)request.getAttribute("list");
  UserBean user = list.get(0);
  %> 

		<div class="container-fluid">
		
  			  <ol class="breadcrumb">
  			    <li><a onclick="admin()">管理员中心</a></li>
  				<li class="active">修改管理员</li>
			  </ol>
  			
  			<form action="" method="post">
				     		  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">管理员类型:</label>
							   	<div class="col-md-8">
							    <select class="form-control" id="adminType" disabled>
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
							    <input type="text" class="form-control" id="adminName" value=<%=user.getUserName() %> disabled>
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">密码:</label>
							   	<div class="col-md-8">
							    <input type="password" class="form-control" id="adminPwd" value=<%=user.getUserPwd() %>>
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>							  
							  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<div class="col-md-10">
							    <button type="button" onclick="editAdmin('<%=user.getUserName() %>')" class="btn btn-success btn-block">保存修改</button>
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  
							</form>
		
		</div><!-- /.container-fluid -->
		
  </body>
</html>
