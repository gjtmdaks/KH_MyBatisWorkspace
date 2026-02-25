package com.kh.mybatis.student.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.common.SqlSessionTemplate;
import com.kh.mybatis.student.model.dao.StudentDao;
import com.kh.mybatis.student.service.model.vo.Student;

public class StudentService {

	private StudentDao dao = new StudentDao();
	
	public int insertStudent(Student s) {
		SqlSession session = SqlSessionTemplate.getSession();
		int result = 0;
		
		try {
			result = dao.insertStudent(session, s);
			session.commit();
			
		}catch(Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return result;
	}

	public int insertStudentMap(Map<String, Object> param) {
		SqlSession session = SqlSessionTemplate.getSession();
		int result = dao.insertStudentMap(session, param);
		
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int selectStudentCount() {
		SqlSession session = SqlSessionTemplate.getSession();
		int total = dao.selectStudentCount(session);
		session.close();
		
		return total;
	}

	public Student selectOneStudent(int no) {
		SqlSession session = SqlSessionTemplate.getSession();
		Student s = dao.selectStudent(session, no);
		session.close();
		
		return s;
	}

	public int updateStudent(Student s) {
		SqlSession session = SqlSessionTemplate.getSession();
		int result = dao.updateStudent(session, s);
		
		if(result > 0) {
			session.commit();
		}else {
			session.rollback();
		}
		session.close();
		
		return result;
	}

	public List<Student> selectStudentList() {
		SqlSession session = SqlSessionTemplate.getSession();
		List<Student> list = dao.selectStudentList(session);
		session.close();
		
		return list;
	}
}
