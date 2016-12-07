<%@page import="com.linli.datamodel.Identity"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'displayidentityinfo.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<jsp:include page="isLogin.jsp"></jsp:include>
<body>
<%
	ArrayList<Identity> identityList = (ArrayList) session.getAttribute("identityList");
 	Iterator iterator = identityList.iterator();
 %>
 <table>
 <tr><td>id</td><td>First Name</td><td>Last Name</td><td>Sex</td><td>Email</td><td>Birthdate</td><td></td></tr>
 <%
 int i=0;
 while(iterator.hasNext()){
 	Identity identity =(Identity)iterator.next();
 	%>
 	<tr <%if(i%2==0){%>bgcolor="#F0F8FF"<%} %>>
 	<td><%=identity.getUID() %></td>
 	<td><%=identity.getFirstName() %></td>
 	<td><%=identity.getLastName() %></td>
 	<td><%if(identity.getSex()==1) out.print("Male");else out.print("Female"); %></td>
 	<td><%=identity.getEmail() %></td>
 	<td><%=identity.getBirthDate() %></td>
 	<td><a href="identity/modifyOneIdentityServlet?id=<%=identity.getUID()%>" >Modify</a></td>
 	</tr>
 	<% 
 	i++;
 }
 %>
 </table>
</body>
</html>
