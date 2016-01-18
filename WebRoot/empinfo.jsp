<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.EmployeeBean"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    <title>员工个人信息</title>
    
  </head>
  
  <body>
	
  <%
  List<EmployeeBean> list = (List<EmployeeBean>)request.getAttribute("list");
  EmployeeBean emp = list.get(0);
  %>

  			  <ol class="breadcrumb">
  				<li><a onclick="infoCenter()">信息中心</a></li>
  				<li class="active">员工个人信息</li>
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
								<td><input type="text" class="form-control" id="empNum" value="<%= emp.getEmpNum() %>" disabled></td>
								<td>姓名</td>
								<td><input type="text" class="form-control" id="empName" value="<%= emp.getEmpName() %>" disabled></td>
							</tr>
							<tr>
								<td>性别</td>
								<td><select class="form-control" id="gender" disabled>
									  <option value="男">男</option>
									  <option value="女">女</option>
								</select></td>
								<td>出生日期</td>
								<td><input type="text" class="form-control" id="empBirth" value="<%= emp.getEmpBirth() %>" disabled></td>
							</tr>
							<tr>
								<td>身份证号</td>
								<td><input type="text" class="form-control" id="empId" value="<%= emp.getEmpId() %>" disabled></td>
								<td>籍贯</td>
								<td><input type="text" class="form-control" id="empBirthplace" value="<%= emp.getEmpBirthplace() %>" disabled></td>
							</tr>
							<tr>
								<td>民族</td>
								<td><input type="text" class="form-control" id="empFolk" value="<%= emp.getEmpFolk() %>" disabled></td>
								<td>政治面貌</td>
								<td><input type="text" class="form-control" id="empPolity" value="<%= emp.getEmpPolity() %>"></td>
							</tr>
							<tr>
								<td>部门</td>
								<td><select class="form-control" id="deptName">
									  <option value="产品开发部" selected="selected">产品开发部</option>
									  <option value="市场部">市场部</option>
									  <option value="财务部">财务部</option>
									  <option value="人事部">人事部</option>
									  <option value="行政部">行政部</option>
									  <option value="董事会">董事会</option>
								</select></td>
								<td>岗位</td>
								<td><select class="form-control" id="jobName" >
									  <option value="产品经理">产品经理</option>
									  <option value="程序员" selected="selected">程序员</option>					 
									  <option value="项目经理">项目经理</option>
									  <option value="人事总监">人事总监</option>
									  <option value="人事专员">人事专员</option>
									  <option value="市场总监">市场总监</option>
									   <option value="美工">美工</option>
								</select></td>
							</tr>
							<tr>
								<td>职业状态</td>
								<td><select class="form-control" id="empSituation">
									  <option id="" value="在职">在职</option>
									  <option id="" value="离职">离职</option>
								</select></td>
								<td>入职时间</td>
								<td><input type="text" class="form-control" id="empIndate" value="<%= emp.getEmpIndate() %>" disabled></td>
							</tr>
							<tr>							
								<td>离职时间</td>
								<td><input type="text" class="form-control" id="empLeft" value="<%= emp.getEmpLeft() %>"></td>
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
								<td><input type="text" class="form-control" id="empMail" value="<%= emp.getEmpMail() %>"></td>
								<td>联系电话</td>
								<td><input type="text" class="form-control" id="empPhone" value="<%= emp.getEmpPhone() %>"></td>
							</tr>
							<tr>
								<td>毕业院校</td>
								<td><input type="text" class="form-control" id="empGraduate" value="<%= emp.getEmpGraduate() %>"></td>
								<td>毕业时间</td>
								<td><input type="text" class="form-control" id="empGradate" value="<%= emp.getEmpGradate() %>"></td>
							</tr>
						</table>
						
						<button type="button" onclick="empEdit()" class="btn btn-success btn-block">保存</button>
											
						</div>
					</div>
			  </form>
  			
		
  </body>
</html>
