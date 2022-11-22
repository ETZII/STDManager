package GUImodeling.careSTD.tool;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JTable;

import Student.StudentUtil;
import Student.StudentVO;

public class STDsearchTBL {

	public JTable tableSet(Vector<StudentVO> vec) {
		String []TBLheader = {"선택","이름","나이","성별","전화번호","주소","메모","이용종료일","패널티","관리시작일","관리종료일"};
		Object [][]contents= new StudentUtil().contents(vec);
		JTable table = new JTable(contents,TBLheader);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));	
		table = tableColumnSize(table);
		table.setPreferredScrollableViewportSize(new Dimension(0,0));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
		table.setRowHeight(25);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));			
		return table;
	}
	
	public JTable tableColumnSize(JTable table) {
		table.getColumn("선택").setPreferredWidth(30);
		table.getColumn("이름").setPreferredWidth(60);
		table.getColumn("나이").setPreferredWidth(40);
		table.getColumn("성별").setPreferredWidth(40);
		table.getColumn("전화번호").setPreferredWidth(100);
		table.getColumn("주소").setPreferredWidth(180);
		table.getColumn("메모").setPreferredWidth(250);
		table.getColumn("이용종료일").setPreferredWidth(90);
		table.getColumn("패널티").setPreferredWidth(50);
		table.getColumn("관리시작일").setPreferredWidth(90);
		table.getColumn("관리종료일").setPreferredWidth(90);
		return table;
	}
}
