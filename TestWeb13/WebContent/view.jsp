<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"%>
	<%
		String dept_id =request.getParameter("dept_id");
	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:company";
		Connection conn = DriverManager.getConnection(url, "scott", "1234");
		String strSql="select * from dept where dept_id=?";
		PreparedStatement stmt = conn.prepareStatement(strSql);
		stmt.setString(1, dept_id);
		ResultSet rs =stmt.executeQuery();
		
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		while(rs.next()){			
	%>	
	<table border ="1">
	<tr>
		<td>부서번호</td><td><%=rs.getString("dept_id")%> </td>
	</tr>
	<tr>
		<td>부서명</td><td><%=rs.getString("dept_name") %> </td>
	</tr>
	<tr>
		<td>위치코드</td><td><%=rs.getString("loc_id") %> </td>
	</tr>
	
	</table>
	<% 	}%>
	<br>
	<a href="">수정</a>&nbsp;<a href="list.jsp">목록</a>&nbsp;<a href="delete.jsp?dept_id=<%=dept_id%>">삭제</a>

</body>
</html>