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
 * Servlet implementation class StudentInsertController
 */
@WebServlet("/student/insertStudent")
public class StudentInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 학생 입력페이지로 이동.
		request.getRequestDispatcher("/student/insertStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자가 입력한 값들을 파라미터로 추출하여,
		// vo클래스로 가공처리
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		Student s = new Student();
		s.setName(name);
		s.setTel(tel);

		// 가공처리된 vo클래스를 service넘겨서 insert작업수행
		int result = new StudentService().insertStudent(s);

		// 전달받은 처리결과에 따라 응답처리
		if(result > 0) {
			// 데이터 추가 성공
			// 서비스 처리결과 메세지 추가.
			request.getSession().setAttribute("msg", "학생 등록 성공");
			
		}else {
			request.getSession().setAttribute("msg", "학생 등록 실패");
		}
		// DML처리 완료 후 request스코프에 저장된 데이터를 초기화 하려면?
		// 재요청(redirect)을 보내면 된다.
		response.sendRedirect(request.getContextPath() +"/student/insertStudent");
	}
}
