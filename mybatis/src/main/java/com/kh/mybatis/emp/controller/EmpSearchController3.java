package com.kh.mybatis.emp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.emp.model.service.EmpService;

/**
 * Servlet implementation class EmpSearchController1
 */
@WebServlet("/emp/search3")
public class EmpSearchController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpSearchController3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 직급정보 조회 후 request에 저장
		EmpService service = new EmpService();
		List jobList = service.selectJobList();
		request.setAttribute("jobList", jobList);
		
		// 사용자가 선택한 직습정보를 추출하여 service로 전달
		String[] arr = request.getParameterValues("jobCode");
		Map<String, Object> param = new HashMap<>();
		param.put("arr", arr);
		
		List list = service.search3(param);
		
		// 선택한 직급정보에 해당하는 사원목록을 조회 후 request에 저장
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/emp/search3.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
