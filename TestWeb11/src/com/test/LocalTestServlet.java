package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LocalTestServlet")
public class LocalTestServlet extends HttpServlet {
	int num=0;
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String  str=req.getParameter("msg");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		while(num++<100) {
			out.print(num+"<br>");
			out.flush();
			System.out.println(str+":"+num);
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				System.out.println(e);
			}
		
		}
		
		out.close();
		
	}
}
