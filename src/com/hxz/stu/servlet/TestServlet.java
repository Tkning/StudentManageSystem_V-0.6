package com.hxz.stu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxz.stu.bean.Student;
import com.hxz.stu.dao.StudentDao;

@WebServlet(urlPatterns="/test")
public class TestServlet extends HttpServlet {
	
	StudentDao dao = new StudentDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String test = (String)request.getAttribute("test");
//		System.out.println(test);
//		Student s = new Student(1, "ttt", "男", 23, 45);
		request.setAttribute("rtest", "request");
		request.getSession().setAttribute("stest", "session");
		request.getServletContext().setAttribute("atest", "application");
//		request.getRequestDispatcher("test.jsp").forward(request, response);
		response.sendRedirect("test.jsp");
	}
}
