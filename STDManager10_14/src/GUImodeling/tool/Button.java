package GUImodeling.tool;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import GUImodeling.consult.CPlan;

public class Button {

	JButton btn;
	
	public Button() {}
	public Button(String name,int FontSize) {
		btn = new JButton(name);
		btn.setFont(new Font("맑은 고딕", Font.BOLD, FontSize));
	}
	
	public JButton getBtn() {
		return btn;
	}
	
	public JButton getCPlanBtn() {
		btn = new JButton("교수님 상담일정 보기");
		btn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btn.setBounds(703, 10, 169, 45);
		btn.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new CPlan().run();
			}
		});
		return btn;
	}
}
