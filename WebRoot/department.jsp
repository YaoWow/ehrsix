<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>部门管理</title>
    <script>
    function showTable(){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","DeptAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=select&deptType="+$("#deptType").val()+"&deptNum="+$("#deptNum").val()+"&deptName="+$("#deptName").val()+"&result=list");
    document.getElementById("deptcontent").innerHTML=xmlhttp.responseText;
    }
    showTable(); 
    </script>
    
    
    <script>
    function showResult(){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","DeptAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=select&deptType=&deptNum=&deptName=&result=list");
    }
    function deptEdit(deptNumber){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","DeptAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=select&deptNum="+deptNumber+"&deptName=&deptType=&result=edit");
    document.getElementById("content").innerHTML=xmlhttp.responseText;
    }
    
 	function deptEditSave(){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","DeptAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=edit&deptNumber="+$("#deptNumber").val()+"&deptName="+$("#deptName").val()
    									  +"&deptType="+$("#deptType").val()+"&deptTel="+$("#deptTel").val()
    									  +"&deptDesc="+$("#deptDesc").val()+"&deptSuper="+$("#deptSuper").val()
    									  +"&deptSetdate="+$("#deptSetdate").val());
    showResult()
    }
    </script>
    <script>
 	function deptCreate(){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","DeptAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=add&deptNumber="+$("#deptNumber").val()+"&deptName="+$("#deptName").val()
    									+"&deptType="+$("#deptType").val()+"&deptTel="+$("#deptTel").val()
    									+"&deptDesc="+$("#deptDesc").val()+"&deptSuper="+$("#deptSuper").val()
    									+"&deptSetdate="+$("#deptSetdate").val());
    }
    </script>
    
    
    <script>
    function deptDelete(deptNumber){
    	if(confirm("确认删除？")){
    		deleteDept(deptNumber);
    	}
    }
    function deleteDept(deptNumber){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","DeptAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=delete&deptNumber="+deptNumber);
    showTable();
    }
  
    function deptAdd(){
	$("#content").load("deptcreate.jsp");
	}
	
	function department(){
	$("#content").load("department.jsp");
	}
	</script>
	
  </head>
  
  <body>
		
		<div id="dept" class="container-fluid">
		
  			  <ol class="breadcrumb">
  				<li class="active">部门管理</li>
			  </ol>
		
			<div class="row">
			  <div class="col-md-2">
			  		<button type="button" onclick="deptAdd()" class="btn btn-success">创建部门 + </button>
			  </div>
			  <div class="col-md-10">
				  <form class="form-inline">
					<div class="form-group">
						<select id="deptType" class="form-control">
								<option value="">全部</option>
								<option value="总公司">总公司</option>
								<option value="分公司">分公司</option>
						</select>
					 </div>
					 <div class="form-group">
						<input type="text" class="form-control" id="deptNum" placeholder="部门编号">
					 </div>
					 <div class="form-group">
			    		<input type="text" class="form-control" id="deptName" placeholder="部门名称">
			  		 </div>	
				  <button type="button" onclick="showTable()" class="btn btn-default">查询</button>
				</form>
			  </div>
			</div>
			<div id="deptcontent">
			
			</div>
		
			
		</div><!-- /.container-fluid -->
		
  </body>
</html>
