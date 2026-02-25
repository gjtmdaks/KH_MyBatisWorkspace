package com.kh.mybatis.student.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.student.service.model.vo.Student;

public class StudentDao {

	public int insertStudent(SqlSession session, Student s) {
		// insert("mapper의 namespace.queryTagId", 바인딩에 필요한 값(파라미터))
		return session.insert("student.insertStudent", s);
	}

	public int insertStudentMap(SqlSession session, Map<String, Object> param) {
		return session.insert("student.insertStudentMap", param);
	}

	public int selectStudentCount(SqlSession session) {
		return session.selectOne("student.selectStudentCount");
	}

	public Student selectStudent(SqlSession session, int no) {
		return session.selectOne("student.selectStudent", no);
	}

	public int updateStudent(SqlSession session, Student s) {
		return session.update("student.updateStudent", s);
	}

	public List<Student> selectStudentList(SqlSession session) {
		return session.selectList("student.selectStudentList");
	}
}
