package GUImodeling.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUImodeling.tool.Button;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;

public class AdminMain {
	JFrame jf;
	private JPanel contentPane;
	
	public AdminMain() {
		jf = new Frame(400, 250).getJFrame();
		contentPane = new Panel().get();
	}
	
	public void run() {
		jf.setContentPane(contentPane);
		mainPanel();
		jf.setVisible(true);
	}
	
	void mainPanel() {
		title();
		insertBtn();
		deleteBtn();
	}
	
	void title() {
		JLabel Title = new Label("관리자페이지",20).getTitle();
		Title.setBounds(100, 35, 192, 40);
		contentPane.add(Title);
	}
	
	void insertBtn() {
		JButton insertBtn = new Button("등록하기",17).getBtn();
		insertBtn.setBounds(60, 110, 121, 53);
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new CreateAdmin().run();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(insertBtn);
	}
	
	void deleteBtn() {
		JButton deleteBtn = new Button("삭제하기",17).getBtn();
		deleteBtn.setBounds(210, 110, 121, 53);
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new DeleteAdmin().run();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(deleteBtn);
	}
}
