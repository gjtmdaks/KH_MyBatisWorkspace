package com.kh.mybatis.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.student.model.service.StudentService;
import com.kh.mybatis.student.service.model.vo.Student;

/**
 * Servlet implementation class SelectOneController
 */
@WebServlet("/student/selectOne")
public class SelectOneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("no");
		int no = 0;
		if(param != null) {
			no = Integer.parseInt(param);
		}
		StudentService service = new StudentService();
		
		// 총 학생수 조회
		int total = service.selectStudentCount();
		
		// no값과 일치하는 학생정보 조회
		if(no != 0) {
			Student s = service.selectOneStudent(no);
			request.setAttribute("student", s);
		}
		request.setAttribute("total", total);
		
		request.getRequestDispatcher("/student/selectOne.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
