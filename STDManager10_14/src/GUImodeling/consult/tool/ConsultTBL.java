package GUImodeling.consult.tool;

import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;

import GUImodeling.tool.TableCell;
import consulting.CPlanVO;
import consulting.ConsultMiniVO;
import consulting.ConsultingDAO;
import consulting.ConsultingSQL;

public class ConsultTBL {

	
	public JTable tableSet(Vector<ConsultMiniVO> vec) throws SQLException {
		String []TBLheader = {"선택","상담날짜","시작시간","교수이름","학생이름","상담여부","상담메모"};
		Object [][]contents= contents(vec);
		JTable table = new JTable(contents,TBLheader);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));	
		table.setPreferredScrollableViewportSize(new Dimension(0,0));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
		table.setRowHeight(25);
		tableColumnSize(table);
		table=new TableCell(table).tableCellCenter();
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));			
		return table;
	}
	
	public JTable tableSet2(Vector<ConsultMiniVO> vec)  {
		String []TBLheader = {"상담날짜","시작시간","교수이름","학생이름","상담여부","상담메모"};
		Object [][]contents= contents2(vec);
		JTable table = new JTable(contents,TBLheader);
		table.setPreferredScrollableViewportSize(new Dimension(0,0));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
		table.setRowHeight(47);
		tableColumnSize2(table);
		table=new TableCell(table).tableCellCenter();
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));			
		return table;
	}

	public Object[][] contents(Vector<ConsultMiniVO> vec) throws SQLException{
		int i = 0, j = 1;
		Object[][] oj = new Object[new ConsultingDAO().selectCnt(new ConsultingSQL().selectConsultCnt())][7];
		for(ConsultMiniVO vo:vec) {
			oj[i][j]=vo.getConsultDay(); oj[i][j+1]=vo.getConsultTime(); oj[i][j+2]=vo.getProfessorName(); 
			oj[i][j+3]=vo.getName(); oj[i][j+4]=vo.getIsConsult(); oj[i][j+5]=vo.getCMemo();
			i++;
		}
		return oj;
	}
	
	public Object[][] contents2(Vector<ConsultMiniVO> vec) {
		int i = 0, j = 0;
		Object[][] oj = new Object[1][7];
		if(vec!=null) {
			oj  = new Object[vec.size()][7];
			for(ConsultMiniVO vo:vec) {
				oj[i][j]=vo.getConsultDay(); oj[i][j+1]=vo.getConsultTime(); oj[i][j+2]=vo.getProfessorName(); 
				oj[i][j+3]=vo.getName(); oj[i][j+4]=vo.getIsConsult(); oj[i][j+5]=vo.getCMemo();
				i++;
			}
		}
		return oj;
	}
		
	public JTable tableColumnSize(JTable table) {
		table.getColumn("선택").setPreferredWidth(30);
		table.getColumn("상담날짜").setPreferredWidth(100);
		table.getColumn("시작시간").setPreferredWidth(60);
		table.getColumn("교수이름").setPreferredWidth(100);
		table.getColumn("학생이름").setPreferredWidth(100);
		table.getColumn("상담여부").setPreferredWidth(100);
		table.getColumn("상담메모").setPreferredWidth(341); //326
		return table;
	}
	
	public JTable tableColumnSize2(JTable table) {
		table.getColumn("상담날짜").setPreferredWidth(80);
		table.getColumn("시작시간").setPreferredWidth(52); 
		table.getColumn("교수이름").setPreferredWidth(90);
		table.getColumn("학생이름").setPreferredWidth(90);
		table.getColumn("상담여부").setPreferredWidth(90);
		table.getColumn("상담메모").setPreferredWidth(255);
		return table;
	}

	//CPlan table setting
	public Object [][] CPlanContents(Vector<CPlanVO> vec) {
		Object[][] oj = new Object[9][6];
		oj=basic(oj);
		if (vec!=null) {
			for(CPlanVO vo:vec) {
				if(vo.getConsultDay().equals("월")) oj[vo.getConsultTime()-9][1] +=vo.getProfessorName()+"("+vo.getName()+")<br>";
				else if(vo.getConsultDay().equals("화")) oj[vo.getConsultTime()-9][2] +=vo.getProfessorName()+"("+vo.getName()+")<br>";
				else if(vo.getConsultDay().equals("수")) oj[vo.getConsultTime()-9][3] +=vo.getProfessorName()+"("+vo.getName()+")<br>";
				else if(vo.getConsultDay().equals("목")) oj[vo.getConsultTime()-9][4] +=vo.getProfessorName()+"("+vo.getName()+")<br>";
				else if(vo.getConsultDay().equals("금")) oj[vo.getConsultTime()-9][5] +=vo.getProfessorName()+"("+vo.getName()+")<br>";
			}
		}
		oj=basicLast(oj);
		return oj;	
	}
	public Object [][] basic(Object[][] oj){
		for(int i = 0;i<9;i++) {
			oj[i][0] = (i+9) + "시";
			oj[i][1] ="<html>"; oj[i][2] ="<html>"; oj[i][3] ="<html>";
			oj[i][4] ="<html>"; oj[i][5] ="<html>";
		}
		return oj;
	}
	public Object[][] basicLast(Object[][] oj){
		for(int i = 0;i<9;i++) {
			oj[i][1] +="</html>"; oj[i][2] +="</html>"; oj[i][3] +="</html>";
			oj[i][4] +="</html>"; oj[i][5] +="</html>";
		}
		return oj;
	}
	
	public JTable CPlanBasicSet(JTable table) {
		table=CPlanTableColumnSize(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	
		table.setRowHeight(60);
		return table;
	}
	public JTable CPlanTableColumnSize(JTable table) {	
		table.getColumn("상담시작").setPreferredWidth(82);
		table.getColumn("월").setPreferredWidth(115);
		table.getColumn("화").setPreferredWidth(115);
		table.getColumn("수").setPreferredWidth(115);
		table.getColumn("목").setPreferredWidth(115);
		table.getColumn("금").setPreferredWidth(115);
		return table;
	}
	
}
