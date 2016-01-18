<%@ page language="java" import="java.util.*,bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<DeptBean> depts=(List<DeptBean>)request.getAttribute("depts");
List<JobBean> jobs=(List<JobBean>)request.getAttribute("jobs");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>信息中心</title>
    
    <script>
    
    function showPage(pageNum){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","EmployeeAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=select&type=list&deptName="+$("#deptName").val()+"&jobName="+$("#jobName").val()+"&empId="+$("#empId").val()+"&empName="+$("#empName").val()+"&pageNum="+pageNum);
    document.getElementById("emp").innerHTML=xmlhttp.responseText;
    }
    showPage(1); 
    </script>
    
  	<script type="text/javascript">
    
    function infoCenter(){
    $("#content").load("infocenter.jsp");
    };
	
	</script>
	
	<script>
    function empInfo(empName){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","EmployeeAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=select&type=detail&deptName=&jobName=&empId=&empName="+empName+"&pageNum=1");
    document.getElementById("emp-content").innerHTML=xmlhttp.responseText;
    }
    </script>
    
    <script type="text/javascript">
    function empEdit(){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","EmployeeAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=edit&empNum="+$("#empNum").val()+"&empName="+$("#empName").val()+"&empBirth="+$("#empBirth").val()+"&gender="+$("#gender").val()+
    "&empPolity="+$("#empPolity").val()+"&empFolk="+$("#empFolk").val()+"&empId="+$("#empId").val()+"&empIndate="+$("#empIndate").val()+"&empLeft="+$("#empLeft").val()+
    "&empBirthplace="+$("#empBirthplace").val()+"&empPhone="+$("#empPhone").val()+"&empMail="+$("#empMail").val()+"&deptName="+$("#deptName").val()+"&jobName="+$("#jobName").val()+
    "&empLearn="+$("#empLearn").val()+"&empGraduate="+$("#empGraduate").val()+"&empGradate="+$("#empGradate").val()+"&empSituation="+$("#empSituation").val());
    }
    </script>
    <script type="text/javascript">
    function empCreate(){
    var xmlhttp;
    if(window.XMLHttpRequest){
    	xmlhttp=new XMLHttpRequest();
    }else{
    	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.open("POST","EmployeeAction",false);
    xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xmlhttp.send("action=add&empNum="+$("#empNum").val()+"&empName="+$("#empName").val()+"&empBirth="+$("#empBirth").val()+"&gender="+$("#gender").val()+
    "&empPolity="+$("#empPolity").val()+"&empFolk="+$("#empFolk").val()+"&empId="+$("#empId").val()+"&empIndate="+$("#empIndate").val()+"&empLeft="+$("#empLeft").val()+
    "&empBirthplace="+$("#empBirthplace").val()+"&empPhone="+$("#empPhone").val()+"&empMail="+$("#empMail").val()+"&deptName="+$("#deptName").val()+"&jobName="+$("#jobName").val()+
    "&empLearn="+$("#empLearn").val()+"&empGraduate="+$("#empGraduate").val()+"&empGradate="+$("#empGradate").val()+"&empSituation="+$("#empSituation").val());
    }
    </script>
	
  </head>
  
  <body>
		
		<div class="container-fluid">
			<div id="emp-content">
			<ol class="breadcrumb">
				<li class="active">信息中心</li>
			</ol>
			
					  
			<div class="row">
			  <div class="col-md-2">
			  		<button onclick="selectAdd('addEmp')" type="button" class="btn btn-success">员工入职 + </button>
			  </div>
			  <div class="col-md-10">
				  <form class="form-inline">
					<div class="form-group">
					 <select id="deptName" class="form-control">
						  <option value="">所有部门</option>
						  <option value="产品开发部">产品开发部</option>
						  <option value="市场部">市场部</option>
						  <option value="财务部">财务部</option>
						  <option value="人事部">人事部</option>
						  <option value="行政部">行政部</option>
						  <option value="董事会">董事会</option>
					  </select>
					 </div>
					  
					 <div class="form-group">
						<select id="jobName" name="jobType" class="form-control">
								<option value="">所有岗位</option>
								<option value="技术">技术</option>
								<option value="管理">管理</option>
								<option value="营销">营销</option>
								<option value="市场">市场</option>
								<option value="产品">产品</option>
								<option value="行政">行政</option>
						</select>
					 </div>
					 <div class="form-group">
			    		<input type="text" class="form-control" id="empId" placeholder="员工身份证号码">
			  		 </div>	
			  		 <div class="form-group">
			    		<input type="text" class="form-control" id="empName" placeholder="员工姓名">
			  		 </div>	
				  <button type="button" onclick="showPage(1)" class="btn btn-default">查询</button>
				</form>
			  </div>
			</div>
			
			<div id="emp">

			</div>
			
			</div>
			  	
		</div><!-- /.container-fluid -->
		
  </body>
</html>
