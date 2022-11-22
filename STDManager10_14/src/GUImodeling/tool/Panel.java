package GUImodeling.tool;

import javax.swing.JPanel;

public class Panel {

	JPanel main;
	
	public Panel(){
		main = new JPanel();
		main.setLayout(null);
	}
	
	public JPanel get() {
		return main;
	}
	
}
