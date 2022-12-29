package com.kh.jdbc.day01.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.day01.student.model.vo.Student;

public class StudentDAO {
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "STUDENT";
	private final String PASSWORD = "STUDENT";
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	// 전체 조회
	public List<Student> selectAll() {
		String sql = "SELECT * FROM STUDENT_TBL";

		Student student = null;
		List<Student> sList = null;

		try {
			// 1. 드라이버 등록
			Class.forName(DRIVER_NAME);
			// 2. DB 연결 생성
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 3. 쿼리문 실행준비(Statement 객체 생성)
			Statement stmt = conn.createStatement();
			// 4. 쿼리문 실행 및
			// 5. 결과 받기 (SELECT)
			ResultSet rset = stmt.executeQuery(sql);

			sList = new ArrayList<Student>();
			// 6. 후처리
			while (rset.next()) {
				student = new Student(rset.getString("STUDENT_ID"), rset.getString("STUDENT_NAME"),
						rset.getString("STUDENT_PWD"), rset.getString("GENDER"), rset.getInt("AGE"),
						rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLL_DATE"));
				sList.add(student);
			}

			// 6. 자원해제
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList;
	}

	// 이름으로 데이터 조회
	// 이름이 중복 될 수 있어서 List로 받음
	public List<Student> selectAllByName(String studentName) {
		List<Student> sList = null;
		Student student = null;
		String sql = "SELECT * FROM STUDENT_TBL WHERE STUDENT_NAME = '" + studentName + "'";

		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			sList = new ArrayList<Student>();
			while (rset.next()) {
				student = new Student(rset.getString("STUDENT_ID"), rset.getString("STUDENT_NAME"),
						rset.getString("STUDENT_PWD"), rset.getString("GENDER"), rset.getInt("AGE"),
						rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLL_DATE"));
				sList.add(student);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList;
	}

	// 아이디로 데이터 조회
	public Student selectOneById(String studentId) {
		Student student = null;
		String sql = "SELECT * FROM STUDENT_TBL WHERE STUDENT_ID = '" + studentId + "'";

		try {
			// 1. 드라이버 등록
			Class.forName(DRIVER_NAME);
			// 2. DB 연결 생성
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 3. 쿼리문 실행준비(Statement 객체 생성)
			Statement stmt = conn.createStatement();
			// 4. 쿼리문 실행 및
			// 5. 결과 받기 (SELECT)
			ResultSet rset = stmt.executeQuery(sql);
			// 후처리, rset을 그대로 못씀
			while (rset.next()) {
				student = new Student(rset.getString("STUDENT_ID"), rset.getString("STUDENT_NAME"),
						rset.getString("STUDENT_PWD"), rset.getString("GENDER"), rset.getInt("AGE"),
						rset.getString("EMAIL"), rset.getString("PHONE"), rset.getString("ADDRESS"),
						rset.getString("HOBBY"), rset.getDate("ENROLL_DATE"));

			}
			// 6. 자원해제
			rset.close();
			stmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return student;
	}

	// 데이터 추가
	public int insertStudent(Student student) {
		String sql = "INSERT INTO STUDENT_TBL VALUES(" + "'" + student.getStudentId() + "'," + "'"
				+ student.getStudentPwd() + "'," + "'" + student.getStudentName() + "'," + "'" + student.getGender()
				+ "'," + student.getAge() + "," + "'" + student.getEmail() + "'," + "'" + student.getPhone() + "',"
				+ "'" + student.getAddress() + "'," + "'" + student.getHobby() + "'," + "SYSDATE)";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			// 쿼리문 실행 - DML(INSERT, UPDATE, DELETE)
			result = stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 데이터 삭제
	public int deleteStudent(String studentId) {
		String sql = "DELETE FROM STUDENT_TBL WHERE STUDENT_ID = '" + studentId + "'";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			// 쿼리문 실행 - DML(INSERT, UPDATE, DELETE)
			result = stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 데이터 수정
	public int updateStudent(Student student) {
		String sql = "UPDATE STUDENT_TBL SET STUDENT_PWD = '"+student.getStudentPwd()+"', EMAIL = '"+student.getEmail()+"', PHONE = '"+student.getPhone()+"', ADDRESS = '"+student.getAddress()+"', HOBBY = '"+student.getHobby()+"'";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			// 쿼리문 실행 - DML(INSERT, UPDATE, DELETE)
			result = stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
