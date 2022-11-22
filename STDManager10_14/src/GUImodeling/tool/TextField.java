package GUImodeling.tool;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TextField {
	JTextField text;
	
	public TextField(int size,int columns) {
		text= new JTextField();
		text.setFont(new Font("맑은 고딕", Font.PLAIN, size));
		text.setColumns(columns);
		text.setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public JTextField get() {
		return text;
	}
}
