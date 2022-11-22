package GUImodeling.manageAtt.tool;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import GUImodeling.careSTD.tool.STDTableCellChkBox;
import GUImodeling.tool.TableCell;
import Student.StudentVO;
import attendance.AttendanceUtil;
import attendance.AttendanceVO;
import schedule.ScheduleUtil;
import schedule.ScheduleVO;

public class ATTTable {

	public JTable scheduleTableSet(Vector<ScheduleVO> SCvec) throws SQLException {
		String []TBLheader = {"이름","전화번호","날짜","특이사항"};
		Object [][]contents= new ScheduleUtil().contents(SCvec);
		JTable scheduleTable = new JTable(contents,TBLheader);
		scheduleTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));	
		scheduleTable=ScheduleTableColumnSize(scheduleTable);	
		scheduleTable.setPreferredScrollableViewportSize(new Dimension(0,0));
		scheduleTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scheduleTable.setRowHeight(40);
		scheduleTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		return scheduleTable;
	}
	
	public JTable STDinfoTableSet(Object [][]contents){
		String []TBLheader = {"선택","이름","나이","성별","전화번호","주소","메모","패널티"};
		JTable STDinfoTable = new JTable(contents,TBLheader);
		STDinfoTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));			
		STDinfoTable.setPreferredScrollableViewportSize(new Dimension(0,0));
		STDinfoTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		STDinfoTable.setRowHeight(25);
		return STDinfoTable;
	}
	
	public JTable ScheduleTableColumnSize(JTable scheduleTable) {
		scheduleTable.getColumn("이름").setPreferredWidth(100);
		scheduleTable.getColumn("전화번호").setPreferredWidth(120);
		scheduleTable.getColumn("날짜").setPreferredWidth(200);
		scheduleTable.getColumn("특이사항").setPreferredWidth(362);	
		return scheduleTable;
	}
	
	public JTable STDtableColumnSize(JTable STDinfoTable) {
		STDinfoTable.getColumn("선택").setPreferredWidth(30);
		STDinfoTable.getColumn("이름").setPreferredWidth(50);
		STDinfoTable.getColumn("나이").setPreferredWidth(30);
		STDinfoTable.getColumn("성별").setPreferredWidth(30);
		STDinfoTable.getColumn("전화번호").setPreferredWidth(100);
		STDinfoTable.getColumn("주소").setPreferredWidth(140);
		STDinfoTable.getColumn("메모").setPreferredWidth(347);
//		STDinfoTable.getColumn("이용종료일").setPreferredWidth(75);
		STDinfoTable.getColumn("패널티").setPreferredWidth(40);
//		STDinfoTable.getColumn("관리시작일").setPreferredWidth(75);
//		STDinfoTable.getColumn("관리종료일").setPreferredWidth(75);
		return STDinfoTable;
	}
	
	public JTable STDinfoTableSet(Vector<StudentVO> vec) throws SQLException {
		String []TBLheader = {"이름","나이","성별","전화번호","주소","메모","이용종료일","패널티","관리시작일","관리종료일"};
		Object [][]contents= new AttendanceUtil().contents(vec);
		JTable table = new JTable(contents,TBLheader);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));	
		table = STDtableColumnSize1(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(25);
		return table;
	}
	public JTable STDtableColumnSize1(JTable STDinfoTable) {
		STDinfoTable.getColumn("이름").setPreferredWidth(60);
		STDinfoTable.getColumn("나이").setPreferredWidth(40);
		STDinfoTable.getColumn("성별").setPreferredWidth(40);
		STDinfoTable.getColumn("전화번호").setPreferredWidth(100);
		STDinfoTable.getColumn("주소").setPreferredWidth(180);
		STDinfoTable.getColumn("메모").setPreferredWidth(250);
		STDinfoTable.getColumn("이용종료일").setPreferredWidth(90);
		STDinfoTable.getColumn("패널티").setPreferredWidth(50);
		STDinfoTable.getColumn("관리시작일").setPreferredWidth(90);
		STDinfoTable.getColumn("관리종료일").setPreferredWidth(90);
		return STDinfoTable;
	}
	public STDTableCellChkBox setChkColumn(JTable table) {
		STDTableCellChkBox tc = new STDTableCellChkBox(table);
		table.getColumnModel().getColumn(0).setCellRenderer(tc);
		table.getColumnModel().getColumn(0).setCellEditor(tc);
		return tc;
	}
	
	//출결조회
	public JTable tableSet(Vector<AttendanceVO> vec) throws SQLException {
		String [] header = {"이름","날짜","1교시","2교시","3교시","4교시","5교시","6교시","7교시","출석률","패널티"};	
		Object[][] contents=null;
			contents = new AttendanceUtil().contentsAtt(vec);
		JTable table = new JTable(contents,header);
		table = tableColumnSize(table);
		table = new TableCell(table).tableCellCenter();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		return table;
	}
	public JTable tableColumnSize(JTable table) {
		table.getColumn("이름").setPreferredWidth(68);
		table.getColumn("날짜").setPreferredWidth(75);
		table.getColumn("1교시").setPreferredWidth(59);
		table.getColumn("2교시").setPreferredWidth(59);
		table.getColumn("3교시").setPreferredWidth(59);
		table.getColumn("4교시").setPreferredWidth(59);
		table.getColumn("5교시").setPreferredWidth(59);
		table.getColumn("6교시").setPreferredWidth(59);
		table.getColumn("7교시").setPreferredWidth(59);
		table.getColumn("출석률").setPreferredWidth(52);
		table.getColumn("패널티").setPreferredWidth(45);
		return table;
	}
}
