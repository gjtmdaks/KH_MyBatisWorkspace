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
@WebServlet("/emp/search1")
public class EmpSearchController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpSearchController1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 검색타입, 검색어를 입력받아 service로 전송
		// ?searchType=emp_name&searchKeyword=경민
		String searchType = request.getParameter("searchType");
		String searchKeyword = request.getParameter("searchKeyword");
		
		Map<String, Object> param = new HashMap<>();
		param.put("searchType", searchType);
		param.put("searchKeyword", searchKeyword);
		
		EmpService service = new EmpService();
		List<Map<String, Object>> list = null;
		if(searchKeyword == null) {
			list = service.selectAll();
		}else {
			list = service.search1(param);
		}
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/emp/search1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
