package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginProcess4")
public class LoginProcess4 extends HttpServlet{
	
	private boolean validateUser(String userId,String userPwd) {
		if(userId.equals("ȫ�浿") && userPwd.equals("1234")) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId =req.getParameter("userId");
		String userPwd=req.getParameter("userPwd");
		String userstate= req.getParameter("state");
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		//out.print(userId+","+userPwd);
		
	
		
		
		boolean loginflag=this.validateUser(userId, userPwd);
		if(loginflag) {
			//out.println("Login Sucessful");
			
			if(userstate!=null) {
				Cookie c = new Cookie("loginCheck","Y");
				c.setPath("/");
				resp.addCookie(c);
				out.print("login successful");
				out.print("<a href ='Login'>go to login</a>");
			}
			
//			Cookie[] cs =req.getCookies();
//			for(int inx =0;inx<cs.length;inx++) {
//				out.print(cs[inx].getName()+","+cs[inx].getValue());
//			}
		//	out.print("<script>alert('Login Sucessful');history.back(-1);</script>");
			
		}else {
			//out.print("Login Error");
			Cookie c = new Cookie("loginCheck","N");
			c.setPath("/");
			resp.addCookie(c);
			out.print("login error:");
			out.print("<a href ='Login'>go to login</a>");
		}
		out.print("</html></body>");
		out.close();
		
		
		
	
	}
}
