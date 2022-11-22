package Student;

import java.util.Vector;

import db.STDManager;

public class StudentDB2 {

	private STDManager stdManager;
	StudentSQL sql;
	StudentDAO dao;
	
	public StudentDB2() {
		stdManager = STDManager.getInstance();
		dao = new StudentDAO();
		sql= new StudentSQL();
	}
	//--------모두 조회
	public Vector<StudentVO> selectStudent() {
		return dao.runVec(sql.selectAll());
	}
	
	public Vector<StudentVO> selectStudentAttChk() {
		return dao.runVec(sql.studentAttChk());
	}
	
//	--- 이름, 번호로 조회
	public StudentVO selectStudentNP(String Name,String Phone) {
		return dao.runVO(sql.selectStudentNP(Name, Phone));
	}
	
//	--- 이름으로 조회
	public Vector<StudentVO> selectStudentname(String Name) {
		return dao.runVec(sql.selectStudentName(Name));
	}
	
//	--- 등록
	public int insertStudent(String name,int age,String sex,String phone
			,String addr,String memo,String startCareDay) {
		return dao.run(sql.insert(name, age, sex, phone, addr, memo, startCareDay));
	}
	
//		---- 삭제
		public int deleteStudent(String name,String phone) {
			return dao.run(sql.delete(name, phone));
		}
//		---- 번호 로 선택해서 수정/이름, 성별, 전화,주소,메모
		public int updateStudent(String fieldname,String word,int no) {
			return dao.run(sql.update(no, fieldname, word));
		}
		
		//날짜필터 제외 필터검색
		public Vector<StudentVO> filterSelect(String key,String value){
			return dao.runVec(sql.selectFilter(key, value));
		}
		
		//날짜필터검색
		public Vector<StudentVO> datefilterSelect(String key,String value){
			return dao.runVec(sql.selectDateFilter(key, value));
		}
	
		public int cntStd() {
			return dao.runCnt(sql.selectAllCnt());
		}
		public int updateStudentthree(int id) {
			return dao.run(sql.setRestday(id));
		}
}
	


