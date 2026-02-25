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
 * Servlet implementation class StudentUpdateController
 */
@WebServlet("/student/updateStudent")
public class StudentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateController() {
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
		// 1. 전달받은 파람값 가공처리
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Student s = new Student(no, name, tel, null);
		
		// 2. 서비스로직 호출
		int result = new StudentService().updateStudent(s);
		
		// 3. 응답결과에 따른 화면처리
		if(result > 0) {
			request.getSession().setAttribute("msg", "수정 성공");
		}else {
			request.getSession().setAttribute("msg", "수정 실패");
		}
		
		response.sendRedirect(request.getContextPath()+"/student/selectOne?no="+no);
	}

}
