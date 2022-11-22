package GUImodeling.tool;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class TableCell {
	JTable t;
	public TableCell() {}
	public TableCell(JTable t) {
		this.t= t;
	}
	
	
	public JTable tableCellCenter(){
	    // 테이블 내용 가운데 정렬하기
	      DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
	      dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로     
	      TableColumnModel tcm = t.getColumnModel() ; // 정렬할 테이블의 컬럼모델을 가져옴
	     
	      //전체 열에 지정
	      for(int i = 0 ; i < tcm.getColumnCount() ; i++){
	      tcm.getColumn(i).setCellRenderer(dtcr);  
	      }       
	      //특정 열에 지정
//	      tcm.getColumn(0).setCellRenderer(dtcr);  
//	      tcm.getColumn(4).setCellRenderer(dtcr);
	      
	      return t;
	    }
}
