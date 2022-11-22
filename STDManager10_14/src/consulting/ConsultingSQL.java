package consulting;

public class ConsultingSQL {

	public String selectAllCplan() {
		return "select * from view_CPlan";
	}
	
	public String selectConsult() {
		return "select * from view_Consulting";
	}
	
	
	public String selectConsult(String cDay,String cTime, String pName) {
		return "select * from view_Consulting where consultday = '"+cDay+"' and consulttime = "+cTime
				+ " and professorName = '"+pName+"' and isConsult = '상담예정'";
	}
	
	public String selectConsultToday() {
		return "select * from view_Consulting where consultday in to_char(sysdate,'yy/mm/dd')";
	}
	
	public String selectConsultThisWeek() {
		return "select * from view_Consulting where to_date(consultday,'yy/mm/dd') between (SELECT TRUNC(sysdate, 'iw') FROM DUAL) and (SELECT TRUNC(sysdate, 'iw')+6 FROM DUAL)";
	}
	
	public String selectConsultNextWeek() {
		return "select * from view_Consulting where to_date(consultday,'yy/mm/dd') between (SELECT TRUNC(sysdate, 'iw')+7 FROM DUAL) and (SELECT TRUNC(sysdate, 'iw')+13 FROM DUAL)";
	}
	
	public String selectConsultCnt() {
		return "select count(*) from view_Consulting";
	}
	
	public String selectPf() {
		return "select * from ProfessorTBL";
	}
	
	public String selectPf(Object oj) {
		return "select * from ProfessorTBL where professorName in '"+oj+"'";
	}
	
	public String selectPfCnt() {
		return "select count(*) from ProfessorTBL";
	}

	
	//consultDay 7이면 월요일 11면 금요일
	public String insertConsult(int stdId,int consultDay,String consultTime,int professorId) {
		return "insert into ConsultingTBL (consultId,studentId,consultDay,consultTime,professorId)"
				+ " values(consult_seq.NEXTVAL,"+stdId+",(SELECT TRUNC(sysdate, 'iw')+"+consultDay+" MON FROM DUAL),"
						+consultTime+ ","+professorId+")";
	}
	
	public String selectConsultChk(int consultDay,String consultTime,int professorId) {
		return "select * from ConsultingTBL where to_char(consultDay,'yy/mm/dd') in (SELECT TRUNC(sysdate, 'iw')+"+consultDay+" FROM DUAL)"
				+ " and consultTime = "+consultTime+" and professorId ="+professorId
				+ " and isConsult not in '학생취소'";
	}
	
	public String update(String isC, String cMemo, String cDay,String cTime, int pid) {
		return "update consultingtbl set isConsult = '"+isC+"',Cmemo = '"+cMemo+"'"
				+ " where to_date(consultday,'yy/mm/dd') = to_date('"+cDay+"','yy/mm/dd') and consulttime = "+cTime+" and professorid = "+pid+" and isConsult = '상담예정'";
	}
	
	
}
