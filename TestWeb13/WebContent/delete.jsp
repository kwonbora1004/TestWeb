<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
  <%
    	String dept_id=request.getParameter("dept_id");
    
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:company";
		Connection conn = DriverManager.getConnection(url, "scott", "1234");
		
		String strSql="delete from dept where dept_id =?";
		PreparedStatement stmt = conn.prepareStatement(strSql);
		stmt.setInt(1,Integer.parseInt(dept_id));

		stmt.executeUpdate();
		stmt.close();
		response.sendRedirect("list.jsp");
		%>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>삭제하기</title>
</head>
<body>

</body>
</html>