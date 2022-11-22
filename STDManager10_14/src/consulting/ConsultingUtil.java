package consulting;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JComboBox;

public class ConsultingUtil {
	
	ConsultingDAO dao;
	ConsultingSQL sql;
	
	public ConsultingUtil() {
		dao = new ConsultingDAO();
		sql = new ConsultingSQL();
	}
	
	
	//CPlan(다음주상담계획) 전체조회
	public Vector<CPlanVO> selectCPlan() {		
		return dao.selectCPlan(sql.selectAllCplan());
	}
	
	public Vector<ProfessorVO> selectPf(){
		return dao.selectPf(sql.selectPf());
	}
	
	public Vector<ProfessorVO> selectPf(Object oj){
		return dao.selectPf(sql.selectPf(oj));
	}
	
	public Vector<ConsultMiniVO> selectAConsMini() {
		return dao.selectConsult(sql.selectConsult());
	}
	
	public int selectPfCnt(){
		return dao.selectCnt(sql.selectPfCnt());
	}
	
	public int insertConsult(int stdId,int consultDay,String consultTime,int professorId) {
		return dao.run(sql.insertConsult(stdId, consultDay, consultTime, professorId));
	}
	
	//중복체크
	public int chkConsult(int consultDay,String consultTime,int professorId) {
		return dao.run1(sql.selectConsultChk(consultDay, consultTime, professorId));
	}
	
	public Vector<ConsultMiniVO> search(JComboBox jc) throws SQLException{
		Vector<ConsultMiniVO> vec = new Vector<ConsultMiniVO>();
		String str = jc.getSelectedItem().toString();
		if(str.equals("전체")) vec = new ConsultingUtil().selectAConsMini();
		else if(str.equals("오늘")) vec=new ConsultingDAO().selectConsult(new ConsultingSQL().selectConsultToday());
		else if(str.equals("이번주")) vec=new ConsultingDAO().selectConsult(new ConsultingSQL().selectConsultThisWeek());
		else if(str.equals("다음주"))	vec=new ConsultingDAO().selectConsult(new ConsultingSQL().selectConsultNextWeek());
		return vec;
	}
	
}
