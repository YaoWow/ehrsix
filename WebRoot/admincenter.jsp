<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>管理员中心</title>
    <script>
    function adminSelect(){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","UserAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");   
    xmlhttp.send("action=listAllUser&type=list");
    document.getElementById("admincontent").innerHTML=xmlhttp.responseText;
    }
    adminSelect(); 
    </script>
    
    <script>
    function editAdmin(){//注意区分adminEdit
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","UserAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");   
    xmlhttp.send("action=editUser&userType="+$("#adminType").val()+"&userName="+$("#adminName").val()+"&userPwd="+$("#adminPwd").val());
    }
    </script>
    
    <script>
    function adminCreate(){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }  
    xmlhttp.open("POST","UserAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=addUser&adminName="+$("#adminName").val()+"&adminType="+$("#adminType").val()+"&adminPwd="+$("#adminPwd").val());
    }
    </script>
    
    <script>
    function adminDelete(str){
    	if(confirm("确认删除？")){
    		deleteAdmin(str);
    	}
    }
    function deleteAdmin(str){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","UserAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=deleteUser&userName="+str);
    adminSelect();
    }
    
	function adminAdd(){
	$("#content").load("admincreate.jsp");
	};
	
	function adminEdit(userName){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","UserAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=listAllUser&type=edit&userType=&userPwd=&userName="+userName);
    document.getElementById("content").innerHTML=xmlhttp.responseText;
	};
	
	function admin(){
	$("#content").load("admincenter.jsp");
	};
	
	</script>
  </head>
  
  <body>
		
		<div class="container-fluid">
			
			
  			<ol class="breadcrumb">
  				<li class="active">管理员中心</li>
			</ol>

			<button type="button" onclick="adminAdd()" class="btn btn-success">创建管理员 + </button>
			<br><br/>

			<div id="admincontent">
			
			</div>
			
	
		</div><!-- /.container-fluid -->
		
  </body>
</html>
