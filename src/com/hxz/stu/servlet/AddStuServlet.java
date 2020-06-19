package com.hxz.stu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxz.stu.bean.Student;
import com.hxz.stu.dao.StudentDao;

@WebServlet(urlPatterns="/addStu")
public class AddStuServlet extends HttpServlet {
	
	StudentDao dao = new StudentDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/add.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		//1、通过req获取表单数据
		Integer id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Integer age = Integer.parseInt(req.getParameter("age"));
		String gender = req.getParameter("gender");
		Integer score = Integer.parseInt(req.getParameter("score"));
		
		//2、将表单数据封装为Student对象
		Student s = new Student(id,name, gender, age, score);		
		
		//3、调用dao，将student添加到xml文件中
		try {
			dao.save(s);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//4、重定向到list页面	
		resp.sendRedirect("list");
	}
}

