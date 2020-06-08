<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:company";
		Connection conn = DriverManager.getConnection(url, "scott", "1234");
		Statement stmt = conn.createStatement();
		/* String strSql="create table test10(id varchar2(5))";
		stmt.executeUpdate(strSql);
		stmt.close();*/
		String strSql2 = "select * from dept";
		ResultSet rs = stmt.executeQuery(strSql2);
	%>
	<table border="1">

		<%
			while (rs.next()) {
		%>
		<tr>
			<td>
				<%
					out.print(rs.getInt("DEPT_ID") + "," + rs.getString("DEPT_NAME") + "<br>");
				%>
			</td>
		</tr>
		<%
			}
		%>

		<%
			conn.close();
			//out.print("Create tabletest10");
		%>
</body>
</html>