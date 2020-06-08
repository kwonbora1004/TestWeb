<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input</title>
</head>
<body>
	<%
		String msg=(String)request.getAttribute("error");
	if(msg==null) msg="";
	%>
	<%=msg %>
	<form action="example10.jsp" method="post">
	ID:<input type="text" name="id"><br>
	비밀번호:<input type ="password" name="Pwd"><br>
	<input type ="submit" value="로그인"> 
	</form>
</body>
</html>