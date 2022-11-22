package GUImodeling.main;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import GUImodeling.admin.CreateAdminChk;
import GUImodeling.careSTD.CareStudents;
import GUImodeling.consult.CONSULTmain;
import GUImodeling.manageAtt.ATTmain;
import GUImodeling.payment.PaymentMain;
import GUImodeling.tool.Button;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Main {
	JFrame jf;
	private JPanel contentPane;

	public Main() {
		jf = new Frame(620, 283).getJFrame();
		contentPane = new Panel().get();
	}
	
	public void run() {
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setContentPane(contentPane);
		mainPanel();
		jf.setVisible(true);
	}
	
	//메인패널
	void mainPanel() {
		title(); quitBtn(); todayTaskBtn(); 
		consultBtn(); paymentBtn(); AdminBtn();
		careSTDBtn(); attdanceBtn();
	}
	
	//타이틀
	void title() {
		JLabel Title = new Label("학생관리의 정석",20).getTitle();
		Title.setBounds(197, 21, 192, 40);
		contentPane.add(Title);
	}
	
	//오늘주요업무버튼
	void todayTaskBtn() {
		JButton todayTaskBtn = new Button("오늘의 주요업무(창유지)",14).getBtn();
		todayTaskBtn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		todayTaskBtn.setBounds(401, 24, 179, 40);
		todayTaskBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new TodayTask().run();
			}
		});
		contentPane.add(todayTaskBtn);
	}

	//하루종료버튼
	void quitBtn() {
		JButton quit = new Button("하루 종료(마감)",10).getBtn();
		quit.setBounds(10, 15, 107, 35);
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TodayQuit().run();;
			}
		});
		contentPane.add(quit);
	}
	
	//학생관리버튼
	void careSTDBtn() {
		JButton careSTDBtn = new Button("학생관리",17).getBtn();
		careSTDBtn.setBounds(22, 126, 121, 53);
		careSTDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CareStudents().run();
			}
		});
		contentPane.add(careSTDBtn);
	}

	//출결관리버튼
	void attdanceBtn() {
		JButton attdanceBtn = new Button("출결관리",17).getBtn();
		attdanceBtn.setBounds(168, 126, 121, 53);
		attdanceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ATTmain().run();;
			}
		});
		contentPane.add(attdanceBtn);
	}
	
	//상담관리버튼
	void consultBtn() {
		JButton consultBtn = new Button("상담관리",17).getBtn();
		consultBtn.setBounds(313, 126, 121, 53);
		consultBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new CONSULTmain().run();
			}
		});
		contentPane.add(consultBtn);
	}
	
	//결제관리버튼
	void paymentBtn() {
		JButton paymentBtn = new Button("결제관리",17).getBtn();
		paymentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PaymentMain();
			}
		});
		paymentBtn.setBounds(459, 126, 121, 53);
		contentPane.add(paymentBtn);
	}
	
	//관리자
	void AdminBtn() {
		JButton AdminBtn = new Button("관리자등록",11).getBtn();
		AdminBtn.setBounds(511, 221, 96, 23);
		AdminBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new CreateAdminChk().run();
				} catch (SQLException e1) {
				}
			}
		});
		contentPane.add(AdminBtn);
	}
}
