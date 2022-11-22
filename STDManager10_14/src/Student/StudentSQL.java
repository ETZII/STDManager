package Student;

public class StudentSQL {

	//학생 전체조회
	public String selectAll() {
		return "select studentid, name, age, sex, phone, addr, memo, to_char(restday,'yy/mm/dd'), penalty, to_char(startcareday,'yy/mm/dd'),to_char(endcareday,'yy/mm/dd')"
				+ " from studenttbl order by studentid";
	}
	
	//학생 전체 숫자
	public String selectAllCnt() {
		return "select count(*) from StudentTBL";
	}
	
	//출결관리중인 학생 전체조회
	public String select() {
		return "SELECT studentid, name, age, sex, phone, addr, memo, to_char(restday,'yy/mm/dd'), penalty, to_char(startcareday,'yy/mm/dd'),to_char(endcareday,'yy/mm/dd')"
				+ " FROM studenttbl where  restday >=to_date(to_char(sysdate,'yy/mm/dd'))"
				+ " ORDER BY studentid";
	}
	
	public String selectRestdayCnt() {
		return "SELECT count(*) FROM studenttbl WHERE restday-6 < sysdate and restday >=sysdate";
	}
	
	//학습잔여일 6일 미만 학생조회
	public String selectRestday() {
		return "SELECT studentid, name, age, sex, phone, addr, memo, to_char(restday,'yy/mm/dd'), penalty,startcareday,endcareday"
				+ " from studenttbl where  restday-6< sysdate and restday >=sysdate order by restday";
	}
	
	public String studentAttChk() {
		return "select studentid, name, age, sex, phone, addr, memo, to_char(restday,'yyyy/mm/dd'), penalty, to_char(startcareday,'yyyy/mm/dd'),to_char(endcareday,'yyyy/mm/dd')"
				+ " from studenttbl"
				+ " WHERE studentid NOT IN (SELECT studentId FROM AttendanceTBL WHERE TO_CHAR(day,'YYMMDD') IN TO_CHAR(SYSDATE,'YYMMDD') GROUP BY studentId)"
				+ " ORDER BY studentid";
	}
	
//	--- 이름, 번호로 조회
	public String selectStudentNP(String Name,String Phone) {
		return "select studentid, name, age, sex, phone, addr, memo, to_char(restday,'yyyy/mm/dd'), penalty, to_char(startcareday,'yyyy/mm/dd'),to_char(endcareday,'yyyy/mm/dd')"
				+ "from studenttbl where name = '"+Name+"' and phone = '"+Phone+"' order by studentid";
	}
	
//	--- 이름으로 조회
	public String selectStudentName(String Name) {
		return "select studentid, name, age, sex, phone, addr, memo, restday, penalty,startcareday,endcareday"
				+ " from studenttbl where name = '"+Name+"'";
	}
	
//	날짜필터 제외 필터검색
	public String selectFilter(String key,String value) {
		return "select studentid, name, age, sex, phone, addr, memo, to_char(restday,'yyyy/mm/dd'), penalty, to_char(startcareday,'yyyy/mm/dd'),to_char(endcareday,'yyyy/mm/dd')"
				+ " FROM StudentTBL WHERE "+key+" like '%"+value+"%' ORDER BY studentid";
	}
	
//	날짜필터검색
	public String selectDateFilter(String key,String value) {
		return "select studentid, name, age, sex, phone, addr, memo, to_char(restday,'yyyy/mm/dd'), penalty, to_char(startcareday,'yyyy/mm/dd'),to_char(endcareday,'yyyy/mm/dd')"
				+ " FROM StudentTBL WHERE TO_CHAR("+key+",'yy/mm/dd') in '"+value+"' ORDER BY studentid";
	}
//		--- 등록
	public String insert(String name,int age,String sex,String phone,String addr,String memo,String startCareDay) {
		return "insert into studentTBL (studentId,name,age,sex,phone,addr,memo,startCareDay,restday) "
				+ "values(STD_SEQ.nextval,'"+name+"',"+age+",'"+sex+"','"+phone+"','"+addr+"','"+memo+"','"+startCareDay+"',to_date('"+startCareDay+"','yy/mm/dd')+30)";
	}
	
//	---- 삭제
	public String delete(String name,String phone) {
		return "delete from studenttbl where name='"+name+"' and phone='"+phone+"'";
	}
	
//	---- 번호 로 선택해서 수정/이름, 성별, 전화,주소,메모
	public String update(int studentid,String key,String value) {
		return "UPDATE studentTBL SET "+key+" = '"+value+"' WHERE studentId ="+studentid;
	}

	public String setRestday(int id) {
		return "update studenttbl set restday = restday+30 where studentId ="+id;
	}

}
