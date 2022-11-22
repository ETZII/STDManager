package attendance;

import java.sql.SQLException;
import java.util.Vector;

import Student.StudentDB2;
import Student.StudentVO;
import calendar.DateTime;
import db.STDManager;

public class AttendanceUtil {
	STDManager stdManager;
	AttendanceDAO dao;
	
	public AttendanceUtil() throws SQLException {
		stdManager = STDManager.getInstance();
		dao = new AttendanceDAO();
	}
	//출결입력+패널티등록
	public int insertAtt(int studentId,Vector<String[]> vec){
		int result=0;
		String [] str= new String[2];
		String [] issue= new String[7];
		int [] period = new int[7];
		if (vec.size()==0) result=insertAtt(studentId);
		else {
			for(int j =0; j<vec.size();j++) {
				str=vec.get(j);
				for(int i =0; i<7;i++) {
					if(Integer.parseInt(str[0])==i+1) {
						period[i] = Integer.parseInt(str[0]);
						issue[i] = str[1];
					}
				}
			}
			for(int i = 0; i<7;i++) {
				if(period[i]==0) result+= stdManager.run(new AttendanceSQL().insertAtt(studentId,i+1));
				else {
					result+= stdManager.run(new AttendanceSQL().insertAtt(studentId,i+1,issue[i]));
					if (!issue[i].equals("출석인정")) dao.run(new AttendanceSQL().givePenalty(studentId));
				}
			}
		}
		return result;
	}	
	public int insertAtt(int studentId) {
		int result=0;
		for(int i =1;i<8;i++) result+=stdManager.run(new AttendanceSQL().insertAtt(studentId,i));
		return result;
	}
	//출결조회
	public Vector<AttendanceVO> selectAll(String sql) throws SQLException {
		return dao.selectAttName(sql);
	}
	
	//출결관리하는 학생수(=환불하지않은 학생수)
	public int stdAttCnt() throws SQLException {
		return dao.cntAtt(new AttendanceSQL().cntCareStd());
	}
	
	//월별 학생전체 출석률
	public double stdCalTotalAtt() throws SQLException {
		return Math.round(dao.cntAtt(new AttendanceSQL().cntTotalAtt()) / (7.0* new DateTime().cntWeekdate())*100);
	}
	
//	new AttendanceSQL().weeklySearch(filterChk());
	//일별 계산
	public double calAttday(int i) {
		return Math.round(i / 7.0 * 100);
	}
	//주차별 계산
	public double calAttWeek(int i) {
		return Math.round(i / (7.0*5) * 100);
	}
	//월별 계산
	public double calAttMonth(int i) {
		return Math.round(i / (7.0*new DateTime().cntWeekdate()) * 100);
	}

	public Object[][] contents(Vector<StudentVO> vec) throws SQLException{
		int i = 0, j = 0;
		String phone =null;
		Object[][] oj = new Object[new StudentDB2().cntStd()][10]; //출결관리중인학생수,행개수 10개
		for(StudentVO vo:vec) {
			phone=vo.getPhone();
			oj[i][j]=vo.getName(); oj[i][j+1]=vo.getAge(); oj[i][j+2]=vo.getSex(); oj[i][j+3]=phone.substring(0,3)+"-"+phone.substring(3,7)+"-"+phone.substring(7);
			oj[i][j+4]=vo.getAddr(); oj[i][j+5]=vo.getMemo(); oj[i][j+6]=vo.getRestday();oj[i][j+7]=vo.getPenalty();
			oj[i][j+8]=vo.getStartCareDay();  oj[i][j+9]=vo.getEndCareDay();
			i++;
		}
		return oj;
	}
	
	//출결전체
		public Object[][] contentsAtt(Vector<AttendanceVO> vec) throws SQLException{
			int i =2,j = 0;
			int isAttend=0,penalty=0;
			Object[][] oj = new Object[new AttendanceUtil().stdAttCnt()][11]; //출결관리중인학생수,행개수 11개
			for(AttendanceVO vo:vec) {
				oj[j][i]=vo.getReason();
				if(vo.getIsAttend()==1) isAttend++;
				else if (!vo.getReason().equals("출석인정")) penalty++;
				i++;
				if(i%9==0) {
					oj[j][0]=vo.getName();
					oj[j][1]=vo.getDay();
					oj[j][9]=Math.round(isAttend/7.0*100) +"%";
					oj[j][10]= penalty; penalty=0;
					j++; i=2; isAttend=0;
				}
			}
			return oj;
		}
		
		public int filterChk(String filter) {
			int date = new DateTime().getStartSundayOfMonth();	
			if(filter.equals("오늘"))  date =0;
			else if (filter.equals("1주차"))  date = date*1;
			else if (filter.equals("2주차")) date = date+7;
			else if (filter.equals("3주차")) date = date+14;
			else if (filter.equals("4주차")) date = date+21;
			else if (filter.equals("5주차")) {
				date = date+28;
				if(date>new DateTime().getNowDateOfMonth()) date=100;
			}
			else date = 32;
			return date;
		}
}
