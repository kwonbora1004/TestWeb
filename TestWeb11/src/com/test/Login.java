package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		Cookie[] c = req.getCookies();
		if (c != null) {
			//out.print(c[0].getName() + "," + c[0].getValue());
			if (c[0].getValue().equals("Y")) {
				out.print("Logined");
			} else {
				out.print("<html><body>");
				out.print("<form action='LoginProcess4' method='get'>");
				out.print("���̵�:<input type='text' name='userId'><br>");
				out.print("��й�ȣ:<input type='password' name='userPwd'><br>");
				out.print("<input type='checkbox' name='state'>�α��λ�������<br>");
				out.print("<input type='submit' value='�α���'><br>");
				out.print("<form>");
				out.print("</html></body>");
				out.close();
			}
		} else {
			out.print("<html><body>");
			out.print("<form action='LoginProcess4' method='get'>");
			out.print("���̵�:<input type='text' name='userId'><br>");
			out.print("��й�ȣ:<input type='password' name='userPwd'><br>");
			out.print("<input type='checkbox' name='state'>�α��λ�������<br>");
			out.print("<input type='submit' value='�α���'><br>");
			out.print("<form>");
			out.print("</html></body>");
			out.close();

		}
	}
}
