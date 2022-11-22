package GUImodeling.manageAtt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUImodeling.tool.Button;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;

public class ATTmain  {
	JFrame jf;
	private JPanel contentPane;

	public ATTmain() {
		jf = new Frame(589, 225).getJFrame();
		contentPane = new Panel().get();
	}
	
	public void run() {
		jf.setContentPane(contentPane);
		mainPanel();
		jf.setVisible(true);
	}	
	void mainPanel() {
		title();
		searchBtn(); insertBtn();scheduleBtn();
	}
	void title() {
		JLabel Title = new Label("출결관리",20).getTitle();
		Title.setBounds(225, 28, 147, 27);
		contentPane.add(Title);
	}
	
	//출결조회버튼
	void searchBtn() {
		JButton btnNewButton = new Button("출결조회",17).getBtn();
		btnNewButton.setBounds(50, 88, 137, 47);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new ATTsearch().run();
			}
		});
		contentPane.add(btnNewButton);
	}
	
	//출결확인버튼
	void insertBtn() {
		JButton btnNewButton_1 = new Button("출결확인",17).getBtn();
		btnNewButton_1.setBounds(224, 88, 137, 47);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new ATTinsert().run();
			}
		});
		contentPane.add(btnNewButton_1);
	}
	
	//스케줄관리버튼
	void scheduleBtn() {
		JButton btnNewButton_2 = new Button("스케쥴관리",17).getBtn();
		btnNewButton_2.setBounds(395, 88, 137, 47);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new manageSchedule().run();
			}
		});
		contentPane.add(btnNewButton_2);
	}
}
