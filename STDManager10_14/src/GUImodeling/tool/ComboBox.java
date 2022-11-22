package GUImodeling.tool;

import java.awt.Font;

import javax.swing.JComboBox;

public class ComboBox {
	JComboBox combo;
	
	public ComboBox(Object[] oj,int size) {
		combo = new JComboBox(oj);
		combo.setFont(new Font("맑은 고딕", Font.PLAIN, size));
	}
	
	public JComboBox get() {
		return combo;
	}
}
