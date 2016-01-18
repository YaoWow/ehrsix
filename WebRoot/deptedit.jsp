<%@ page language="java" import="java.util.*,bean.DeptBean" pageEncoding="UTF-8"%>
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
  List<DeptBean> deptlist = (List<DeptBean>)request.getAttribute("list");
  DeptBean dept=deptlist.get(0);
  %>
  			<div class="container-fluid">
  			  <ol class="breadcrumb">
  			    <li><a onclick="department()">部门管理</a></li>
  				<li class="active">部门修改</li>
			  </ol>
  			
  			<form action="" method="post">
				     		  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">部门编号:</label>
							   	<div class="col-md-8">
							    <input type="text" class="form-control" id="deptNumber" value="<%=dept.getDeptNumber() %>" disabled>
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  			
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">部门名称:</label>
							   	<div class="col-md-8">
							    <input type="text" class="form-control" id="deptName" value="<%=dept.getDeptName() %>">
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">部门类型:</label>
							   	<div class="col-md-8">
									<select class="form-control" id="deptType" value="<%=dept.getDeptType() %>">
									<option value="总公司">总公司</option>
									<option value="分公司">分公司</option>
									</select>
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">电话:</label>
							   	<div class="col-md-8">
							    <input type="text" class="form-control" id="deptTel" value="<%=dept.getDeptTel() %>">
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">描述:</label>
							   	<div class="col-md-8">
							    <input type="text" class="form-control" id="deptDesc" value="<%=dept.getDeptDesc() %>">
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>

							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">上级部门:</label>
							   	<div class="col-md-8">
									<select class="form-control" id="deptSuper">
									<option value="产品开发部">产品开发部</option>
									  <option value="市场部">市场部</option>
									  <option value="财务部">财务部</option>
									  <option value="人事部">人事部</option>
									  <option value="行政部">行政部</option>
									  <option value="董事会">董事会</option>
									</select>
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>

							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<label class="col-md-2 control-label">成立日期:</label>
							   	<div class="col-md-8">
									<input class="form-control" type="text" id="deptSetdate" value="<%=dept.getDeptSetdate() %>" disabled>
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>							  
							  
							  <div class="form-group">
							  <div class="row">
							  	<div class="col-md-1"></div>
							   	<div class="col-md-10">
							    <button type="button" onclick="deptEditSave()" class="btn btn-success btn-block">保存</button>
							    </div>
							    <div class="col-md-1"></div>
							   </div>
							  </div>
							  
							</form>
					</div>
		
		
  </body>
</html>
