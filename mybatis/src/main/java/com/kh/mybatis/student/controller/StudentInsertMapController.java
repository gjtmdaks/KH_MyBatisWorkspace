package com.kh.mybatis.student.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.student.model.service.StudentService;

/**
 * Servlet implementation class StudentInsertMapController
 */
@WebServlet("/student/insertStudentMap")
public class StudentInsertMapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInsertMapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Map<String, Object> param = new HashMap<>();
		param.put("name", name);
		param.put("tel", tel);
		
		int result = new StudentService().insertStudentMap(param);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "map형식 등록 성공");
		}else {
			request.getSession().setAttribute("msg", "map형식 등록 실패");
		}
		response.sendRedirect(request.getContextPath()+"/student/insertStudent");
	}

}
