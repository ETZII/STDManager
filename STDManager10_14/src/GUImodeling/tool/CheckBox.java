package GUImodeling.tool;

import java.awt.Font;

import javax.swing.JCheckBox;

public class CheckBox {
	JCheckBox chkB;
	
	public CheckBox(String name,int size) {
		chkB = new JCheckBox(name);
		chkB.setFont(new Font("맑은 고딕", Font.PLAIN, size));
	}
	
	public JCheckBox get() {
		return chkB;
	}
}
