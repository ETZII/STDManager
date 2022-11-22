package GUImodeling.tool;

import javax.swing.JFrame;

public class Frame {
	JFrame jf;
	
	public Frame(int width,int length) {
		jf = new JFrame("관리의정석");
		jf.setBounds(100,100,width,length);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public JFrame getJFrame() {		
		return jf;
	}
	
}
