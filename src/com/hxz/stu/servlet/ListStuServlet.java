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

@WebServlet(urlPatterns="/list")
public class ListStuServlet extends HttpServlet {
	
	StudentDao dao = new StudentDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> stus = null;
		try {
			stus = dao.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("stus", stus);
		request.setAttribute("test", "hello");
		
		
		//request.setAttribute("test", "hello");
		//重定向
		//response.sendRedirect("test");
		//转发
		//request.getRequestDispatcher("test").forward(request, response);
		
		
		request.getRequestDispatcher("/WEB-INF/pages/list.jsp").forward(request, response);
	}
}
