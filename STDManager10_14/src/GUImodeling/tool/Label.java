package GUImodeling.tool;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Label {
	JLabel title;
	int size;
	
	public Label(String name,int size) {
		this.size = size;
		title = new JLabel(name);
		title.setHorizontalAlignment(SwingConstants.CENTER);
	}

	public JLabel getTitle() {
		title.setFont(new Font("맑은 고딕", Font.BOLD, size));
		return title;
	}
	
	public JLabel getPlain() {
		title.setFont(new Font("맑은 고딕", Font.PLAIN, size));
		return title;
	}
}
