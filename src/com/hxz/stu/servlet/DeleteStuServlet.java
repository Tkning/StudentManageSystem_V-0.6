package com.hxz.stu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hxz.stu.dao.StudentDao;

@WebServlet(urlPatterns="/deleteStu")
public class DeleteStuServlet extends HttpServlet {
	
	StudentDao dao = new StudentDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		try {
			dao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("list");
	}
}
