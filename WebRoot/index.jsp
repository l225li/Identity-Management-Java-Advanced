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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel='stylesheet prefetch'
	href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<div class="wrapper">
		<form action="user/loginServlet" name="login" class="form-signin">
			<h2 class="form-signin-heading">IAM System</h2>
			<input type="text" name="username" placeholder="Username" required=""
				autofocus="" class="form-control" /> <input type="password"
				name="password" placeholder="Password" required=""
				class="form-control" />
			<button type="submit" class="btn btn-lg btn-primary btn-block">Login</button>
		</form>
	</div>
</body>
</html>
