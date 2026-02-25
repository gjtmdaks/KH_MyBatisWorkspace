package com.kh.mybatis.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class EmpDao {

	public List<Map<String, Object>> selectAll(SqlSession session) {
		return session.selectList("emp.selectAll");
	}

	public List<Map<String, Object>> search1(SqlSession session, Map<String, Object> param) {
		return session.selectList("emp.search1", param);
	}

	public List<Map<String, Object>> search2(SqlSession session, Map<String, Object> param) {
		return session.selectList("emp.search2", param);
	}

	public List selectJobList(SqlSession session) {
		return session.selectList("emp.selectJobList");
	}

	public List search3(SqlSession session, Map<String, Object> param) {
		return session.selectList("emp.search3", param);
	}
}
