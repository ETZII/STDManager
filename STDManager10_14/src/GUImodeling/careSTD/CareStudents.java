package GUImodeling.careSTD;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUImodeling.tool.Button;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CareStudents {
	JFrame jf;
	private JPanel contentPane;

	public CareStudents() {
		jf = new Frame(700, 240).getJFrame();
		contentPane = new Panel().get();

	}
	public void run() {
		jf.setContentPane(contentPane);
		mainPanel();
		jf.setVisible(true);
	}
	
	//메인패널
	public void mainPanel() {
		title();
		addSTDbtn(); searchSTDbtn();
		deleteSTDbtn();
	}
	//타이틀
	public void title() {
		JLabel Title = new Label("학생관리",25).getTitle();
		Title.setBounds(250, 25, 150, 27);
		contentPane.add(Title);
	}
	
	//학생등록버튼
	public void addSTDbtn() {
		JButton addBtn = new Button("학생등록",17).getBtn();
		addBtn.setBounds(50, 88, 150, 47);
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new STDinsert().run();
			}
		});
		contentPane.add(addBtn);
	}
	
	//학생조회버튼
	public void searchSTDbtn() {
		JButton searchBtn = new Button("학생조회 및 수정",17).getBtn();
		searchBtn.setBounds(246, 88, 165, 47);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new STDsearch().run();
			}
		});
		contentPane.add(searchBtn);
	}
	
	//학생정보삭제버튼
	public void deleteSTDbtn() {
		JButton deleteBtn = new Button("학생정보삭제",17).getBtn();;
		deleteBtn.setBounds(470, 88, 137, 47);
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new STDdelete_0().run();
			}
		});
		contentPane.add(deleteBtn);
	}

}
