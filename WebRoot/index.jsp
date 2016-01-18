<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userName=(String)request.getSession().getAttribute("userName");
String userType=(String)request.getSession().getAttribute("userType");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
  	<link rel="stylesheet" href="css/bootstrap.css" type="text/css"></link>
  	<script src="js/jquery-1.9.1.min.js"></script>
  	<script src="js/bootstrap.min.js"></script>
  	<script src="js/DatePicker.js"></script>
  	
  	<script>
	function selectAdd(type){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","EmployeeAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=selectAdd&type="+type);
    document.getElementById("content").innerHTML=xmlhttp.responseText;
    }
	</script>
  	
	<script type="text/javascript">
	$(document).ready(function(){
	var mydate = new Date();
	var t=mydate.toLocaleDateString();
	$("#time").text(t); 
	
	selectAdd('infoCenter');
	$("#content").load("infocenter.jsp");
	$("#ainfo").attr("class","list-group-item active");
	
	$("#ainfo").click(function(){
	$(".list-group-item").attr("class","list-group-item");
	$("#ainfo").attr("class","list-group-item active");
	$("#content").load("infocenter.jsp");
	});
	
	$("#adept").click(function(){
	$(".list-group-item").attr("class","list-group-item");
	$("#adept").attr("class","list-group-item active")
	$("#content").load("department.jsp");
	});
	
	$("#ajob").click(function(){
	$(".list-group-item").attr("class","list-group-item");
	$("#ajob").attr("class","list-group-item active")
	$("#content").load("job.jsp");
	});
	
	$("#arep").click(function(){
	$(".list-group-item").attr("class","list-group-item");
	$("#arep").attr("class","list-group-item active")
	$("#content").load("report.jsp");
	});

	$("#aadmin").click(function(){
	$(".list-group-item").attr("class","list-group-item");
	$("#aadmin").attr("class","list-group-item active")
	$("#content").load("admincenter.jsp");
	});
	
	});
	
	</script>
	
	<script>
	function select(pageNum){
	var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","EmployeeAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=selectAny&pageNum="+pageNum+"&value="+$("#value").val());
    document.getElementById("content").innerHTML=xmlhttp.responseText;
	}
	</script>
	
  </head>
  <body style="paddng-bottom:40px">
	    <nav class="navbar navbar-default navbar-static-top">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="index.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp&nbsp&nbspEHRSIX-小企业人事管理系统</a>
		    </div>
			<ul class="nav navbar-nav navbar-right">
				<li><a id="time"></a></li>		
		        <li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> <%=userName %></a></li>
		        <li><a style="text-decoration:underline;color:blue" href="LogoutAction">登出</a></li>
		    </ul>
		  </div><!-- /.container-fluid -->
		</nav>
		
		<div class="container-fluid">
		
		<div class="row">
		
  			<div class="col-md-2">
  				
				<form>
				  <div class="form-group">
				    <input type="text" class="form-control" id="value" placeholder="WHATEVER">
				  </div>				
				  <button type="button" class="btn btn-default btn-block" onclick="select(1)">立即查询</button>
				</form>
  				
				<div class="list-group" style="text-align:center">
				  <a id="ainfo" class="list-group-item">信息中心</a>
				  <a id="adept" class="list-group-item">部门管理</a>
				  <a id="ajob" class="list-group-item">岗位管理</a>
				  <a id="arep" class="list-group-item">报表管理</a>
				  <%if(userType.equals("人事总监")){ %>
				  <a id="aadmin" class="list-group-item">管理员中心</a>
				  <%} %>
				</div>
  			</div>
  			
  			<div id="content" class="col-md-10">
  			</div>
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
