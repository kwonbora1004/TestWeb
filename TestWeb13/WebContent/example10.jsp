<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id=request.getParameter("id");
	String Pwd=request.getParameter("Pwd");
	//유효성체크
	if(id.isEmpty() || Pwd.isEmpty()){
		request.setAttribute("error", "아이디 또는 비밀번호를 입력해주세요!");
		RequestDispatcher rd =request.getRequestDispatcher("logOut.jsp");
		rd.forward(request, response);
		return;
	}
	//로그인처리
	if(session.isNew()||session.getAttribute("id")==null){
		session.setAttribute("id", id);
		out.print("로그인작업이 완료되었습니다.");
	}else{
		out.print("이미 로그인 상태입니다.");
	}
	%>
</body>
</html>