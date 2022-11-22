package schedule;

public class ScheduleSQL {

	//스케줄전체조회
	public String select() {
		return "SELECT name,phone,TO_CHAR(TO_date(issueDay,'YY/MM/DD')),issue FROM VIEW_Schedule";
	}
	
	//당일스케줄전체조회
	public String selectToday() {
		return "SELECT name,phone,TO_CHAR(TO_date(issueDay,'YY/MM/DD')),issue FROM VIEW_Schedule"
				+ " WHERE issueDay like TO_CHAR(sysdate,'YY/MM/DD')";
	}
	
	//이름,전화번호로 모두 조회
	public String select(String name,String phone) {
		return "SELECT name,phone,TO_CHAR(TO_date(issueDay,'YY/MM/DD')),issue FROM VIEW_Schedule"
				+ " WHERE name ='"+name+"' and phone = '"+phone+"'";
	}
	
	//스케줄관리 학생수
	public String selectCnt() {
		return "SELECT count(*) FROM VIEW_Schedule";
	}
	public String selectCntMini() {
		return "SELECT count(*) FROM VIEW_Schedule WHERE issueDay in to_char(sysdate,'yy/mm/dd')";
	}
	
	//스케줄등록
	public String insert(int studentId,String issueDay,String issue) {
		return "INSERT INTO scheduleTBL values("+studentId+",'"+issueDay+"','"+issue+"')";
	}
	//스케줄변경
	public String update(int studentId,String issueDay,String issue) {
		return "UPDATE scheduleTBL SET issue = '"+issue+"' WHERE studentId="+studentId+" and TO_CHAR(issueDay,'YY/MM/DD') IN '"+issueDay+"'";
	}
	//스케줄삭제
	public String delete(int studentId,String issueDay) {
		return "DELETE FROM scheduleTBL WHERE studentId="+studentId+" and TO_CHAR(issueDay,'YY/MM/DD') IN '"+issueDay+"'";
	}
	
}
