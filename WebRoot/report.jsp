<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>报表管理</title>
  	<script type="text/javascript">
	</script>
	<script>
	function showTable(){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","ReportAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("type="+$("#type").val()+"&startDate="+$("#startDate").val()+"&endDate="+$("#endDate").val()+"&deptName="+$("#deptName").val());
    document.getElementById("reportcontent").innerHTML=xmlhttp.responseText;
    }
	</script>
  </head>
  
  <body>

		
		<div class="container-fluid">
		
  			  <ol class="breadcrumb">
  				<li class="active">报表管理</li>
			  </ol>

			<div class="row">
			  <div class="col-md-12">
				  <form class="form-inline">
					<div class="form-group">
					 <select class="form-control" id="type">
						  <option value="newEmpReport">新聘员工报表</option>
						  <option value="disEmpReport">离职员工报表</option>
						  <option value="hrReport">人事月报</option>
					  </select>
					 </div>
					 
					 <div class="form-group">
					  	<input class="form-control" id="startDate" type="text" onfocus="setday(this,'yyyy-MM-dd','2015-08-01','2015-08-30',0)" readonly="readonly" />
					 </div>
					 <div class="form-group">
						<input class="form-control" id="endDate" type="text" onfocus="setday(this,'yyyy-MM-dd','2015-08-01','2015-08-30',0)" readonly="readonly" />
					 </div>
					  
					 <div class="form-group">
					  <select class="form-control" id="deptName">
						  <option value="">所有部门</option>
						  <option value="产品开发部">产品开发部</option>
						  <option value="市场部">市场部</option>
						  <option value="财务部">财务部</option>
						  <option value="人事部">人事部</option>
						  <option value="行政部">行政部</option>
						  <option value="董事会">董事会</option>
					  </select>
					 </div>
				  <button type="button" class="btn btn-default" onclick="showTable()">生成报表</button>
				</form>
			  </div>
			</div>
			
			<div id="reportcontent">

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
