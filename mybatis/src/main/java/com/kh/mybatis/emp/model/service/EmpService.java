package com.kh.mybatis.emp.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.SqlSessionTemplate;
import com.kh.mybatis.emp.model.dao.EmpDao;

public class EmpService {

	private EmpDao dao = new EmpDao();
	
	public List<Map<String, Object>> selectAll() {
		SqlSession session = SqlSessionTemplate.getSession();
		List<Map<String, Object>> list = dao.selectAll(session);
		session.close();
		
		return list;
	}

	public List<Map<String, Object>> search1(Map<String, Object> param) {
		SqlSession session = SqlSessionTemplate.getSession();
		List<Map<String, Object>> list = dao.search1(session, param);
		session.close();
		
		return list;
	}

	public List<Map<String, Object>> search2(Map<String, Object> param) {
		SqlSession session = SqlSessionTemplate.getSession();
		List<Map<String, Object>> list = dao.search2(session, param);
		session.close();
		
		return list;
	}

	public List selectJobList() {
		SqlSession session = SqlSessionTemplate.getSession();
		List jobList = dao.selectJobList(session);
		session.close();
		
		return jobList;
	}

	public List search3(Map<String, Object> param) {
		SqlSession session = SqlSessionTemplate.getSession();
		List list = dao.search3(session, param);
		session.close();
		
		return list;
	}
}
