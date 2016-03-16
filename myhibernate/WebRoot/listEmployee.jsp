<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.jiyoutang.myhibernate.session.StringUtil"%>
<%@page import="com.jiyoutang.myhibernate.bean.Employee" %>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String message = (String)request.getAttribute("message");
	if(!StringUtil.isNull(message)) {
		out.println("<div class=message>" + message + "</div>");
	}
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listEmployee.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <table>
    	<tr>
    		<%
    		if("id".equals(request.getAttribute("sort"))) {
    		 %>
    		 <th class="sortable sorted ${order}">
    		 	<a herf="${ url }action=list&sort=id&order=${order == 'asc'?'desc':'asc' }">
    		 	编号
    		 	</a>
    		 </th>
    		 <%
    		 }else{
    		  %>
    		  <th class="sortable">
    		  	<a href="${ url }action=list&sort=id&order=asc">
    		  	编号
    		  	</a>
    		  </th>
    		  <%
    		  }
    		   %>
    		   <th class="sortable">操作</th>
    	</tr>
    	<%
    		List<Employee> employeeList = (List<Employee>)request
    		.getAttribute("employeeList");
    		NumberFormat salaryFormat = new DecimalFormat("0.00");
    	 	for(int i = 0; employeeList!=null&&i<employeeList.size();i++) {
    	 	Employee e = employeeList.get(i);
    	 	out.println("<tr class='" + (i%2 == 0?"even":"odd") + "'");
    	 	out.println(" <td>" + e.getId() + "</td>");
    	 	out.println(" <td>" + e.getId() + "</td>");
    	 	out.println(" <td>" + e.getName() + "</td>");
    	 	out.println(" <td>" + e.getSex() + "</td>");
    	 	out.println(" <td>" + e.getAge() + "</td>");
    	 	out.println(" <td>" + e.getBirthday() + "</td>");
    	 	out.println(" <td>￥" +salaryFormat.format(e.getSalary())  + "</td>");
    	 	out.println(" <td>" + e.getStartTime() + "</td>");
    	 	out.println(" <td>" + e.getEndTime() + "</td>");
    	 	out.println(" <td>" + (e.isDisabled()?"已阻止":"正常") + "</td>");
    	 	out.println(" <td>&nbsp;</td>");
    	 	}
    	 %>
    </table>
  </body>
</html>
