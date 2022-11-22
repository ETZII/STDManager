package attendance;

import calendar.DateTime;

public class AttendanceSQL {
	
	//출결 insert - 출석부분
	public String insertAtt(int i,int period) {
		return "INSERT INTO AttendanceTBL (studentId,day,period) VALUES("+i+",sysdate,"+period+")";
	}
	//출결 insert - 미출석부분
		public String insertAtt(int i,int period,String reason) {
			return "INSERT INTO AttendanceTBL VALUES("+i+",sysdate,"+period+",0,'"+reason+"')";
		}
	//학생별 월별 출석횟수
	public String cntMonthly(int i) {
		return "SELECT count(period) from view_attendance where studentId = "+i
				+" and day in TO_CHAR(SYSDATE, 'YY/MM/DD')";
	}

	//전체 출석횟수
	public String cntTotalAtt() {
		return "SELECT count (*) from view_attendance where isAttend = 1";
	}
	
	//출결관리하는 학생수(=환불하지않은 학생수)
	public String cntCareStd() {
		return "SELECT count(*) FROM StudentTBL"
				+" WHERE restday>= TO_DATE(TO_CHAR(sysdate,'YYMMDD'))";
	}
	
	//당일 전체조회
	public String todaySearch() {
		return "SELECT studentid,day,period,isattend,reason,name FROM view_attendance"
				+" WHERE day in TO_CHAR(SYSDATE, 'YY/MM/DD') ";
	}
	//필터1개
	public String todaySearchKV(String key,String value) {
		return "SELECT studentid,day,period,isattend,reason,name FROM view_attendance"
				+" WHERE day in TO_CHAR(SYSDATE, 'YY/MM/DD') "
				+ " and "+key+" like '%"+value+"%'";
	}
	//필터2개
		public String todaySearch(String name,String phone) {
			return "SELECT studentid,day,period,isattend,reason,name FROM view_attendance"
					+" WHERE day in TO_CHAR(SYSDATE, 'YY/MM/DD') "
					+  " and name like '%"+name+"%' and phone like '"+phone+"'";
		}
		
	//주별 전체조회
	public String weeklySearch(int date) {
		String today =new DateTime().format();
		if(date<10) today+="0";
		today+=date;
		System.out.println(today);
		return "SELECT studentid,day,period,isattend,reason,name FROM view_attendance"
				+" WHERE day BETWEEN TO_DATE('"+today+"','YYMMDD') and TO_DATE('"+today+"','YYMMDD')+6";
	}
	//필터1개
	public String weeklySearchKV(String key,String value,int date) {
		String today =new DateTime().format();
		if(date<10) today+="0";
		today+=date;
		return "SELECT studentid,day,period,isattend,reason,name FROM view_attendance"
				+" WHERE day BETWEEN TO_DATE('"+today+"','YYMMDD') and TO_DATE('"+today+"','YYMMDD')+6"
						+ " and "+key+" like '%"+value+"%'";
	}
	
	//필터2개
	public String weeklySearch(String name,String phone,int date) {
		String today =new DateTime().format();
		if(date<10) today+="0";
		today+=date;
		return "SELECT studentid,day,period,isattend,reason,name FROM view_attendance"
				+" WHERE day BETWEEN TO_DATE('"+today+"','YYMMDD') and TO_DATE('"+today+"','YYMMDD')+6"
						+ " and name like '%"+name+"%' and phone in '"+phone+"'";
	}
	
	//월별 전체조회
	public String monthlySearch() {
		return "SELECT studentid,day,period,isattend,reason,name FROM view_attendance";
	}
	
	//필터1개
	public String monthlySearchKV(String key,String value) {
		return "SELECT studentid,day,period,isattend,reason,name FROM view_attendance"
				+" WHERE  "+key+" like '%"+value+"%'";
	}
	//필터2개
	public String monthlySearch(String name,String phone) {
		return "SELECT studentid,day,period,isattend,reason,name FROM view_attendance"
				+" WHERE  name like '%"+name+"%' and phone like '"+phone+"'";
	}
	
	//패널티 한번에 주기
	public String givePenalty(int studentId,int penalty) {
			return "UPDATE StudentTBL SET penalty = penalty+"+penalty
					+" WHERE isAttend=0 and reason not in '출석인정' and studentId = "+studentId;
		}
	//isAttend 가 0인 경우중 reason이 출석인정이 아니면 패널티 1증가 (in i 학생번호)
	public String givePenalty(int studentId) {
		return "UPDATE StudentTBL SET penalty = penalty+1 WHERE studentId = "+studentId;
	}
	
	//Sdate와 Edate사이의 패널티 갯수 구하
	public String getPenalty(int i,String Sdate,String Edate) {
		return "SELECT count(isAttend) FROM AttendanceTBL"
				+" WHERE isAttend=0 reason not in '출석인정' studentId = "+i
				+" and day between TO_DATE("+Sdate+",'YYMMDD) and TO_DATE("+Edate+",'YYMMDD')";
	}
	//패널티 0으로 초기화
	public String resetPenalty(int studentId) {
		return "UPDATE StudentTBL SET penalty = 0 WHERE studentId = "+studentId;
	}

	
	 /* 	//학생(번호받아서 int i)별 해당날짜(String day) 출석횟수 
	public String selectCnt(int i,String day) {
		return "SELECT * from view_attendance"
				+" WHERE studentId = "+i+" and TO_CHAR(day,'YYYY/MM/DD') in (SELECT TO_CHAR('"+day+"', 'YYYY/MM/DD') FROM DUAL)";
	}*/
}
