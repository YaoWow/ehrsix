<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>岗位管理</title>
    

    <script>
    function jobSelect(){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","JobAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");   
    xmlhttp.send("action=select&jobType="+$("#jobType").val()+"&jobNum="+$("#jobNum").val()+
    "&jobName="+$("#jobName").val()+"&result=list");
    document.getElementById("jobcontent").innerHTML=xmlhttp.responseText;
    }
    jobSelect(); 
    </script>
    
    <script>
      
   	function jobAdd(){
    $("#content").load("jobcreate.jsp");
    }    
    function job(){
    $("#content").load("job.jsp");
    }
    
    </script>
    
    <script>
    
    function showResult(){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","JobAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=select&jobType=&jobNum=&jobName=&result=list")
    
    }
    
    </script>
    
    <script>
    
    function jobEdit(jobNumber){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","JobAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=select&jobNum="+jobNumber+"&jobName=&jobType=&result=edit");
    document.getElementById("content").innerHTML=xmlhttp.responseText;
    }
    
    </script>
    
    <script>
    
 	function jobEditSave(){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","JobAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=edit&jobType="+$("#jobType").val()+"&jobNum="+$("#jobNum").val()
    +"&jobName="+$("#jobName").val()+"&jobMax="+$("#jobMax").val()+"&jobManNum="+$("#jobManNum").val());
    showResult();
    }
    
    </script>
    
	<script>
    function jobCreate(){
    var xmlhttp1;
    if(window.XMLHttpRequest){
    	xmlhttp1=new XMLHttpRequest();
    }else{
    	xmlhttp1=new ActiveXObject("Microsoft.XMLHTTP");
    }
    if($("#jobMax").val()<$("#jobManNum").val()) {
    	alert("在岗人数大于岗位编制，添加失败");
    } else {
    	xmlhttp1.open("POST","JobAction",false);
    	xmlhttp1.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    	xmlhttp1.send("action=insert&jobType="+$("#jobType").val()+"&jobNum="+$("#jobNum").val()
    	+"&jobName="+$("#jobName").val()+"&jobMax="+$("#jobMax").val()+"&jobManNum="+$("#jobManNum").val());
    	}
    }
    </script>
    
    <script>
    
    function isJobDelete(jobNumber,jobManNum){
    	if(confirm("确认删除？")) {
    		if(jobManNum!=0) {
    			alert("在岗人数不为0，删除失败");
    		} else {
    		jobDelete(jobNumber);
    		}
    	}
    }
    
    function jobDelete(jobNumber){
    var xmlhttp2;
    if(window.XMLHttpRequest){
    	xmlhttp2=new XMLHttpRequest();
    }else{
    	xmlhttp2=new ActiveXObject("Microsoft.XMLHTTP");
    }
    
    xmlhttp2.open("POST","JobAction",false);
    xmlhttp2.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp2.send("action=delete&jobNum="+jobNumber);
    
    jobSelect();
    }
    </script>
    
  </head>
  
  <body>
		<div class="container-fluid">
  			  <ol class="breadcrumb">
  				<li class="active">岗位管理</li>
			  </ol>
			
			<div class="row">
			  <div class="col-md-2">
			  		<button type="button" onclick="jobAdd()" class="btn btn-success">添加岗位 + </button>
			  </div>
			  <div class="col-md-10">
				  <form class="form-inline">
					<div class="form-group">
						<select id="jobType" name="jobType" class="form-control">
								<option value="">所有岗位</option>
								<option value="技术">技术</option>
								<option value="行政">行政</option>
								<option value="产品">产品</option>
								<option value="市场">市场</option>
						</select>
					 </div>
					 <div class="form-group">
						<input type="text" class="form-control" id="jobNum" name="jobNum" placeholder="岗位编号">
					 </div>
					 <div class="form-group">
			    		<input type="text" class="form-control" id="jobName" name="jobName" placeholder="岗位名称">
			  		 </div>	
				  <button type="button" onclick="jobSelect()" class="btn btn-default">查询</button>
				</form>
			  </div>
			</div>
		
			<div id="jobcontent">
			
			</div>
						  
		
		</div><!-- /.container-fluid -->
		
  </body>
</html>
