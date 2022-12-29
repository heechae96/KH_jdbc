package com.kh.jdbc.day01.student.controller;

import java.util.List;

import com.kh.jdbc.day01.student.dao.StudentDAO;
import com.kh.jdbc.day01.student.model.vo.Student;

public class StudentController {

	/**
	 * 학생 전체 목록 조회
	 * @return List<Student>
	 */
	public List<Student> printAll() {
		StudentDAO sDao = new StudentDAO();
		List<Student> sList = sDao.selectAll();
		return sList;
	}
	
	/**
	 * 학생 이름으로 조회
	 * @param studentName
	 * @return List<Student>
	 */
	public List<Student> printAllByName(String studentName){
		StudentDAO sDao = new StudentDAO();
		List<Student> sList = sDao.selectAllByName(studentName);
		return sList;
	}
	
	/**
	 * 학생 아이디로 조회
	 * @param studentId
	 * @return Student
	 */
	public Student printOneById(String studentId) {
		StudentDAO sDao = new StudentDAO();
		Student student = sDao.selectOneById(studentId);
		return student;
	}
	
	/**
	 * 학생 정보 추가
	 * @param student
	 * @return int
	 */
	public int registerStudent(Student student) {
		StudentDAO sDao = new StudentDAO();
		int result = sDao.insertStudent(student);
		return result;
	}
	
	/**
	 * 학생 정보 삭제
	 * @param studentId
	 * @return int
	 */
	public int removeStuent(String studentId) {
		StudentDAO sDao = new StudentDAO();
		int result = sDao.deleteStudent(studentId);
		return result;
	}
	
	/**
	 * 학생 정보 수정
	 * @param studentId
	 * @return int
	 */
	public int modifyStudent(Student student) {
		StudentDAO sDao = new StudentDAO();
		int result = sDao.updateStudent(student);
		return result;
	}
}
