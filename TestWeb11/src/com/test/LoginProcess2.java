package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginProcess2 extends HttpServlet {
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
//		String userId = req.getParameter("userId");
//		String userPwd = req.getParameter("userPwd");

		String userId=id;
		String userPwd= pwd;
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		// out.print(userId+","+userPwd);
		boolean loginflag = this.validateUser(userId, userPwd);
		if (loginflag) {
			// out.println("Login Sucessful");
			out.print("<script>alert('Login Sucessful');history.back(-1);</script>");
		} else {
			out.print("Login Error");
		}
		out.print("</html></body>");
		out.close();

	}
}
