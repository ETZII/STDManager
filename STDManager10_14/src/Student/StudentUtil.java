package Student;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;

import Payment.PaymentDAO2;
import Payment.PaymentVO2;

public class StudentUtil {

	StudentDAO dao;
	
	public StudentUtil() {
		dao= new StudentDAO();
	}
	
	public int studentInsert(StudentVO vo) {
		return new StudentDB2().insertStudent(vo.getName(),vo.getAge(),vo.getSex(),
				vo.getPhone(),vo.getAddr(),vo.getMemo(),vo.getStartCareDay());
	}
	
	public Object[][] contents(Vector<StudentVO> vec) {
		int i = 0, j = 1;
		String phone =null;
		Object[][] oj = new Object[new StudentDB2().cntStd()][11]; //출결관리중인학생수,행개수 10개+체크박스1개
		for(StudentVO vo:vec) {
			oj[i][0]="";
			phone=vo.getPhone();
			oj[i][j]=vo.getName(); oj[i][j+1]=vo.getAge(); oj[i][j+2]=vo.getSex(); oj[i][j+3]=phone.substring(0,3)+"-"+phone.substring(3,7)+"-"+phone.substring(7);
			oj[i][j+4]=vo.getAddr(); oj[i][j+5]=vo.getMemo(); oj[i][j+6]=vo.getRestday();oj[i][j+7]=vo.getPenalty();
			oj[i][j+8]=vo.getStartCareDay();  oj[i][j+9]=vo.getEndCareDay();
			i++;
		}
		return oj;
	}
	
	public Object[][] contentsMini(Vector<StudentVO> vec) throws SQLException{
		int i = 0, j = 0;
		String phone =null;
		Object[][] oj = new Object[dao.runCnt(new StudentSQL().selectRestdayCnt())+1][3]; //출결관리중인학생수,행개수 3개
		for(StudentVO vo:vec) {
			phone=vo.getPhone();
			oj[i][j]=vo.getName(); oj[i][j+1]=phone.substring(0,3)+"-"+phone.substring(3,7)+"-"+phone.substring(7);
			oj[i][j+2]=vo.getRestday();
			i++;
		}
		return oj;
	}
	
	public Object[][] contentsSchedule(Vector<StudentVO> vec) { // 스케쥴 관리에서 학생목록 보여주는 오브젝트
		int i = 0, j = 1;
		String phone =null;
		Object[][] oj = new Object[new StudentDB2().cntStd()][8]; //출결관리중인학생수,행개수 7개+체크박스1개
		for(StudentVO vo:vec) {
			oj[i][0]="";
			phone=vo.getPhone();
			oj[i][j]=vo.getName(); oj[i][j+1]=vo.getAge(); oj[i][j+2]=vo.getSex(); oj[i][j+3]=phone.substring(0,3)+"-"+phone.substring(3,7)+"-"+phone.substring(7);
			oj[i][j+4]=vo.getAddr(); oj[i][j+5]=vo.getMemo(); oj[i][j+6]=vo.getPenalty();
			i++;
		}
		return oj;
	}
	
	public int update(int studId,JTextField[] jtflist,String sex) {
		int result = 0;
		for(int i=0;i<5;i++) {
			if(jtflist[i]==null) continue;
			else if(jtflist[i].getText().length()!=0) result+=dao.run(new StudentSQL().update(studId,jtflist[i].getName(),jtflist[i].getText()));
		}
		if(sex!=null) result+=dao.run(new StudentSQL().update(studId,"sex",sex));
		return result;
	}
	
	public Vector<StudentVO> filterChk(String filter,String value) {
		Vector<StudentVO> vec = new Vector<>();
		if(filter.equals("전체")) vec = new StudentDB2().selectStudent();
		else if(!(filter.equals("이용종료일")||filter.equals("관리시작일")||filter.equals("관리종료일"))) {
			if(filter.equals("이름")) filter="name";
			else if(filter.equals("나이")) filter="age";
			else if(filter.equals("성별")) filter="sex";
			else if(filter.equals("전화번호")) filter="phone";
			else if(filter.equals("주소")) filter="addr";
			else if(filter.equals("메모")) filter="memo";
			else if(filter.equals("패널티")) filter="penalty";
			vec = new StudentDB2().filterSelect(filter, value);
		}else {
			if(filter.equals("이용종료일")) filter="restday";
			else if(filter.equals("관리시작일")) filter="startCareDay";
			else if(filter.equals("관리종료일")) filter="endCareDay";
			vec = new StudentDB2().datefilterSelect(filter, value);
		}
		return vec;
	}
	
	public StudentVO getSTDVO(String name,String phone) {
		return new StudentDAO().runVO(new StudentSQL().selectStudentNP(name, phone));
	}
	
	public void endcaredayThree(int id) {
		Vector<PaymentVO2> vo;
		vo = endTHreeselect(id);
		if(vo.get(0).getPayDay()!=null) {
			new StudentDB2().updateStudentthree(id);
		}
	}
	
	public Vector<PaymentVO2> endTHreeselect(int id){
		Vector<PaymentVO2> vec =null;
		vec = new PaymentDAO2().selectAllPaymentThree(id);
		return vec;
	}
	
	public String paymentrefunddayupdate(int id) {
		Vector<PaymentVO2> vo;
		vo = endTHreeselect(id);
		String day = vo.get(0).getPayDay();
		return day;
	}
	
}
