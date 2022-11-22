package GUImodeling.main.tool;

import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;

import GUImodeling.consult.tool.ConsultTBL;
import GUImodeling.tool.TableCell;
import Student.StudentUtil;
import Student.StudentVO;
import attendance.AttendanceDAO;
import consulting.ConsultingDAO;
import consulting.ConsultingSQL;
import schedule.ScheduleSQL;
import schedule.ScheduleUtil;
import schedule.ScheduleVO;

public class TodayTaskTBL {
	
	//출결특이사항 스케쥴테이블
	public JTable scheduleTableSet(Vector<ScheduleVO> SCvec) throws SQLException {
		String []TBLheader = {"이름","전화번호","날짜","특이사항"};
		Object [][]contents= new ScheduleUtil().contents(new AttendanceDAO().cntAtt(new ScheduleSQL().selectCntMini()),SCvec);
		JTable scheduleTable = new JTable(contents,TBLheader);
		scheduleTable=ScheduleTableColumnSize(scheduleTable);
		scheduleTable=new TableCell(scheduleTable).tableCellCenter();
		scheduleTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scheduleTable.setRowHeight(35);
		scheduleTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		return scheduleTable;
	}
	
	//상담예정 테이블
	public JTable consultTableSet() throws SQLException {
		JTable consultTable = new ConsultTBL().tableSet2(new ConsultingDAO().selectConsult(new ConsultingSQL().selectConsultToday()));	
		consultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		consultTable=ConsultTableColumnSize(consultTable);
		return consultTable;
	}
		
	//학습종료일 6일미만 학생테이블
	public JTable adTableSet(Vector<StudentVO> Svec) throws SQLException {
		String []TBLheader = {"이름","전화번호","학습종료 만료일"};
		Object [][]contents= new StudentUtil().contentsMini(Svec);
		JTable AdTable = new JTable(contents,TBLheader);
		AdTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		AdTable=AdTableColumnSize(AdTable);
		AdTable.setRowHeight(35);
		AdTable.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		AdTable = new TableCell(AdTable).tableCellCenter();
		return AdTable;
	}
	
	public JTable ScheduleTableColumnSize(JTable scheduleTable) {
		scheduleTable.getColumn("이름").setPreferredWidth(90);
		scheduleTable.getColumn("전화번호").setPreferredWidth(110);
		scheduleTable.getColumn("날짜").setPreferredWidth(109);
		scheduleTable.getColumn("특이사항").setPreferredWidth(228);
		return scheduleTable;
	}
	
	public JTable ConsultTableColumnSize(JTable AdTable) {
		AdTable.getColumn("상담날짜").setPreferredWidth(90);
		AdTable.getColumn("시작시간").setPreferredWidth(67);
		AdTable.getColumn("교수이름").setPreferredWidth(90);
		AdTable.getColumn("학생이름").setPreferredWidth(90);
		AdTable.getColumn("상담여부").setPreferredWidth(90);
		AdTable.getColumn("상담메모").setPreferredWidth(110);	
		return AdTable;
	}
	public JTable AdTableColumnSize(JTable AdTable) {
		AdTable.getColumn("이름").setPreferredWidth(179); //179
		AdTable.getColumn("전화번호").setPreferredWidth(179);
		AdTable.getColumn("학습종료 만료일").setPreferredWidth(179);	
		return AdTable;
	}
}
