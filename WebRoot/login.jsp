<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String loginInfo=(String)request.getAttribute("loginInfo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>管理员登录</title>
	<link rel="stylesheet" type="text/css" href="styles.css">
  	<link rel="stylesheet" href="css/bootstrap.css" type="text/css"></link>
  	<script src="js/jquery.js"></script>
  	<script src="js/bootstrap.js"></script>
  	<%if(loginInfo!=null){ %>
  	<script>
  	alert('<%=loginInfo %>');
  	</script>
  	<%} %>
  </head>
  
  <body>


	    <nav class="navbar navbar-default navbar-static-top">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="info-center.jsp">EHRSIX人事管理系统</a>
		    </div>

		  </div><!-- /.container-fluid -->
		</nav>
		
		<div class="container-fluid">
		
			<div class="row">
		
  				<div class="col-md-5"></div>
  				<div class="col-md-2">
  				<br><br><br><br><br>
  				<form action="LoginAction" method="post">
				<div class="form-group">
				 <select name="adminType" class="form-control">
					  <option value="super">人事总监</option>
					  <option value="common">人事专员</option>
				  </select>
				 </div>
  
				  <div class="form-group">
				    <input type="text" name="adminId" class="form-control" id="adminId" placeholder="请输入账号">
				  </div>			
				  <div class="form-group">
				    <input type="password" name="adminPwd" class="form-control" id="adminPwd" placeholder="请输入密码">
				  </div>		
				  <button type="submit" class="btn btn-success btn-block">进入系统</button>
				</form>
  				</div>
  				<div class="col-md-5"></div>
  				
  			</div>
		
		</div><!-- /.container-fluid -->
		
		<nav class="navbar navbar-default navbar-fixed-bottom">
		  <div style="text-align:center;padding-top:5px" class="container-fluid">
		      Powered by 666<br>
		      @2015 EHRSIX
		  </div><!-- /.container-fluid -->
		</nav>
		
  </body>
</html>
