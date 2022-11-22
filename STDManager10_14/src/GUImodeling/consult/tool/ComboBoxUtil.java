package GUImodeling.consult.tool;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JComboBox;

import consulting.ConsultingUtil;
import consulting.ProfessorVO;

public class ComboBoxUtil {

	
	public String [] getTimeHeader() {
		String [] header= new String [9];
		for(int i=0;i<9;i++)
			header[i] = i+9+"시";
		return header;
	}
	
	public String [] getHeader() {
		Vector<ProfessorVO> pfvec = new ConsultingUtil().selectPf();
		String [] header= new String [new ConsultingUtil().selectPfCnt()];
		int i=0;
		for(ProfessorVO pVO : pfvec) {
			header[i] = pVO.getpName();
			i++;
		}
		return header;
	}
	
	public int chkDay(JComboBox jc) {
		int result =7;
		if(jc.getSelectedItem().equals("화")) result =8;
		else if(jc.getSelectedItem().equals("수")) result =9;
		else if(jc.getSelectedItem().equals("목")) result =10;
		else if(jc.getSelectedItem().equals("금")) result =11;
		return result; 
	}
	
	public int getPfId(JComboBox jc) throws SQLException {
		return new ConsultingUtil().selectPf(jc.getSelectedItem()).get(0).getpId();
	}
	
}
