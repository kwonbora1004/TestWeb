package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginProcess3")
public class LoginProcess3 extends HttpServlet {
	String id, pwd;

	public void init(ServletConfig config) throws ServletException {
		id = config.getInitParameter("userId");
		pwd = config.getInitParameter("userPwd");
	}

	private boolean validateUser(String userId, String userPwd) {

		if (userId.equals("ȫ�浿") && userPwd.equals("1234")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");

		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		
		Cookie cId=new Cookie("userId",userId);
		cId.setPath("/");
		resp.addCookie(cId);
		
		Cookie cPwd=new Cookie("userPwd",userPwd);
		cId.setPath("/");
		resp.addCookie(cPwd);
		
		out.print("UserId cookie created");
		out.print("</html></body>");
		out.close();

	}
}
