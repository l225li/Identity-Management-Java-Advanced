<%@page import="com.linli.datamodel.Identity"%>
<%@page import="javax.rmi.CORBA.Stub"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modifyOneIdentity.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <%
	Identity identity=(Identity)session.getAttribute("identity");
   %>
   <div class="wrapper">
		<form method="post" action="identity/modifyOneIdentityInfoServlet" class="form-signin">
			<table>
				<tr>
					<td colspan="2">Identity Update</td>
				</tr>
				<tr>
					<td>First Name</td> 
					<td><input type="text" name="firstName" value="<%=identity.getFirstName() %>"/></td>
				</tr>

				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" value="<%=identity.getLastName() %>"/></td>
				</tr>
				<tr>
					<td>Sex</td>
					<td><input type="radio" name="sex" 
					<%if(identity.getSex()==1){%>checked<%} %> value="1"/>M &nbsp;&nbsp;
					<input type="radio" name="sex" <%if(identity.getSex()==0){%>checked<%} %> value="0">F</td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" value="<%=identity.getEmail() %>" /></td>
				</tr>

				<tr>
					<td>Birth Date</td>
					<td><input type="text" name="birthDate" placeholder="YYYY/MM/DD" value="<%=identity.getBirthDate() %>"/></td>
				</tr>
				<tr>
				<td align="center" colspan="2"><input type="hidden" name="UID" value="<%=identity.getUID() %>" ><input type="submit" value="Update">
					<input type="reset" value="Reset"></td>
				</tr>
			</table>
		</form>
		</div>
  </body>
</html>
