package schedule;

import java.sql.SQLException;
import java.util.Vector;

import Student.StudentVO;
import attendance.AttendanceDAO;

public class ScheduleUtil {
	
	public ScheduleUtil() throws SQLException {

	}

	public Object[][] contents(StudentVO vo){
		Object[][] oj = new Object[1][11];
		String phone=vo.getPhone();
		int i = 0; int j = 1;
		oj[i][j]=vo.getName(); oj[i][j+1]=vo.getAge(); oj[i][j+2]=vo.getSex(); oj[i][j+3]=phone.substring(0,3)+"-"+phone.substring(3,7)+"-"+phone.substring(7);
		oj[i][j+4]=vo.getAddr(); oj[i][j+5]=vo.getMemo(); oj[i][j+6]=vo.getRestday();oj[i][j+7]=vo.getPenalty();
		oj[i][j+8]=vo.getStartCareDay();  oj[i][j+9]=vo.getEndCareDay();
		return oj;
	}
	
	public Object[][] contents(Vector<ScheduleVO> vec) throws SQLException{
		int i = 0, j = 0;
		String phone =null;
		Object[][] oj = new Object[new AttendanceDAO().cntAtt(new ScheduleSQL().selectCnt())+1][4]; 
		for(ScheduleVO vo:vec) {
			phone=vo.getPhone();
			oj[i][j]=vo.getName(); oj[i][j+1]=phone.substring(0,3)+"-"+phone.substring(3,7)+"-"+phone.substring(7);	
			oj[i][j+2]=vo.getIssueDay(); oj[i][j+3]=vo.getIssue();
			i++;
		}
		return oj;
	}
	
	public Object[][] contents(int cnt,Vector<ScheduleVO> vec) throws SQLException{
		int i = 0, j = 0;
		String phone =null;
		Object[][] oj = new Object[cnt+1][4]; 
		for(ScheduleVO vo:vec) {
			phone=vo.getPhone();
			oj[i][j]=vo.getName(); oj[i][j+1]=phone.substring(0,3)+"-"+phone.substring(3,7)+"-"+phone.substring(7);	
			oj[i][j+2]=vo.getIssueDay(); oj[i][j+3]=vo.getIssue();
			i++;
		}
		return oj;
	}

}
