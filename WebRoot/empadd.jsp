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
    <title>员工个人信息</title>
    <script>
    function infoCenter(){
    	$("#content").load("infocenter.jsp");
    }
	</script>
	<script src="js/validate.js"></script>
  </head>
  
  <body>
		
		<div class="container-fluid">

  			  <ol class="breadcrumb">
  				<li><a onclick="infoCenter()">信息中心</a></li>
  				<li class="active">新员工入职</li>
			  </ol>
			  
			  <form class="form-inline" action="">
			  		<div class="row">
			  			<div class="col-md-2">
							   	<img src="img/1436362650452.jpg" height="200" width="200" class="img-thumbnail"></img>
								<button type="submit" class="btn btn-default btn-block">上传照片+</button>
						</div>
						<div class="col-md-9">
						
						<table class="table table-bordered">
							<tr>
								<td>员工编号</td>
								<td><input type="text" class="form-control required" id="empNum"></td>
								<td>姓名</td>
								<td><input type="text" class="form-control" id="empName"></td>
							</tr>
							<tr>
								<td>性别</td>
								<td><select class="form-control" id="gender">
									  <option id="" value="男">男</option>
									  <option id="" value="女">女</option>
								</select></td>
								<td>出生日期</td>
								<td><input class="form-control" id="empBirth" type="text" onfocus="setday(this,'yyyy-MM-dd','2015-08-01','2015-08-30',0)" readonly="readonly" /></td>
							</tr>
							<tr>
								<td>身份证号</td>
								<td><input type="text" class="form-control" id="empId"></td>
								<td>籍贯</td>
								<td><input type="text" class="form-control" id="empBirthplace"></td>
							</tr>
							<tr>
								<td>民族</td>
								<td><input type="text" class="form-control" id="empFolk"></td>
								<td>政治面貌</td>
								<td><input type="text" class="form-control" id="empPolity"></td>
							</tr>
							<tr>
								<td>部门</td>
								<td><select class="form-control" id="deptName">
								<%for(DeptBean dept : depts){
								 %>
									  <option value="<%=dept.getDeptName() %>"><%=dept.getDeptName() %></option>
								<%} %>
								</select></td>
								<td>岗位</td>
								<td><select class="form-control" id="jobName">
								<%for(JobBean job : jobs){
								 %>
									  <option value="<%=job.getJobName() %>"><%=job.getJobName() %></option>
								<%} %>
								</select></td>
							</tr>
							<tr>
								<td>职业状态</td>
								<td><select class="form-control" id="empSituation">
									  <option id="" value="在职">在职</option>
									  <option id="" value="离职">离职</option>
								</select></td>
								<td>入职时间</td>
								<td><input class="form-control" id="empIndate" type="text" onfocus="setday(this,'yyyy-MM-dd','2015-08-01','2015-08-30',0)" readonly="readonly" /></td>
							</tr>
							<tr>							
								<td>离职时间</td>
								<td><input class="form-control" id="empLeft" type="text" onfocus="setday(this,'yyyy-MM-dd','2015-08-01','2015-08-30',0)" readonly="readonly" value="2100-01-01" /></td>
								<td>最高学历</td>
								<td><select class="form-control" id="empLearn">
									  <option value="研究生">研究生</option>
									  <option value="本科">本科</option>
									  <option value="大专">大专</option>
									  <option value="高中及以下" selected="selected">高中及以下</option>
								</select></td>
							</tr>
							<tr>
								<td>电子邮件</td>
								<td><input type="email" class="form-control" id="empMail"></td>
								<td>联系电话</td>
								<td><input type="text" class="form-control" id="empPhone"></td>
							</tr>
							<tr>
								<td>毕业院校</td>
								<td><input type="text" class="form-control" id="empGraduate"></td>
								<td>毕业时间</td>
								<td><input class="form-control" id="empGradate" type="text" onfocus="setday(this,'yyyy-MM-dd','2015-08-01','2015-08-30',0)" readonly="readonly" /></td>
							</tr>
						</table>
						
						<button type="buttton" class="btn btn-success btn-block" onclick="empCreate()">保存</button>
											
						</div>
					</div>
			  </form>
  			
		
		</div><!-- /.container-fluid -->
		
  </body>
</html>
