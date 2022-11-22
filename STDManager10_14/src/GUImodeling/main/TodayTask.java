package GUImodeling.main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;

import GUImodeling.main.tool.TodayTaskTBL;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;
import Student.StudentDAO;
import Student.StudentSQL;

import Student.StudentVO;
import calendar.DateTime;
import schedule.ScheduleDAO;
import schedule.ScheduleSQL;
import schedule.ScheduleVO;

import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TodayTask {
	JFrame jf;
	private JPanel mainPanel;
	private JPanel ConsultPanel,ConsultinsidePanel;
	private JTable scheduleTable;
	private JScrollPane AdscrollPane;
	private Vector<StudentVO> Svec;
	private Vector<ScheduleVO> SCvec;
	private JTable AdTable;
	private JTable table;
	
	public TodayTask() {
		Svec = new StudentDAO().runVec(new StudentSQL().selectRestday());
		SCvec = new ScheduleDAO().select(new ScheduleSQL().selectToday());
		jf = new Frame(620, 730).getJFrame();
	}

	public void run() {
		mainPanel();
		jf.setVisible(true);
	}
	
	void mainPanel() {
		mainPanel = new Panel().get();
		jf.setContentPane(mainPanel);
	
		//메인Pane 안에 있는 요소들
		title();
		consultPanel();
		att();
		ad();
		mainbtn();
	}
	
	void title() {
		JLabel titleLabel = new JLabel("오늘의 주요 업무");
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		titleLabel.setBounds(239, 40, 134, 40);
		mainPanel.add(titleLabel);		
		JLabel dateLabel = new JLabel(new DateTime().toString());
		dateLabel.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		dateLabel.setBounds(203, 10, 202, 40);
		mainPanel.add(dateLabel);
	}
	
	void att() {
		//머릿말
		JPanel AttinsidePanel = new JPanel();
		AttinsidePanel.setBackground(new Color(255, 210, 210));
		AttinsidePanel.setBounds(32, 79, 540, 29);
		mainPanel.add(AttinsidePanel);
		JLabel AttLabel = new JLabel("출결 특이사항");
		AttLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		AttinsidePanel.add(AttLabel);
		//출결이슈 테이블
		scheduleTableAdd();
	}
	
	//출결특이사항
	public void scheduleTableAdd() {
		try {
			scheduleTable = new TodayTaskTBL().scheduleTableSet(SCvec);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scheduleTable.setFont(new Font("맑은 고딕", Font.PLAIN, 12));	
		JScrollPane scheduleScrollPane = new JScrollPane(scheduleTable);
		scheduleScrollPane.setViewportView(scheduleTable);
		scheduleScrollPane.setBounds(32, 108, 540, 123);	
		mainPanel.add(scheduleScrollPane);
	}
	
	void consultPanel() {
		ConsultPanel = new Panel().get();
		ConsultPanel.setBounds(32, 257, 540, 152);
		mainPanel.add(ConsultPanel);
		consult();
	}

	//상담
	void consult() {
		//머릿말
		ConsultinsidePanel = new JPanel();
		ConsultinsidePanel.setBackground(new Color(255, 210, 210));
		ConsultinsidePanel.setBounds(0, 0, 540, 29);
		ConsultPanel.add(ConsultinsidePanel);
		JLabel ConsultLabel = new Label("상담일정",13).getTitle();
		ConsultinsidePanel.add(ConsultLabel);
		//테이블
		JScrollPane ConsultPane = new JScrollPane();
		ConsultPane.setBounds(0, 27, 540, 125);
		ConsultPanel.add(ConsultPane);
		try {
			table = new TodayTaskTBL().consultTableSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConsultPane.setViewportView(table);	
	}
	
	
	
	void ad() {
		JPanel AdinsidePanel = new JPanel();
		AdinsidePanel.setBackground(new Color(255, 210, 210));
		AdinsidePanel.setBounds(32, 433, 540, 29);
		mainPanel.add(AdinsidePanel);
		
		JLabel lblNewLabel_3_2 = new JLabel("학습종료임박(재등록유도)");
		lblNewLabel_3_2.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		AdinsidePanel.add(lblNewLabel_3_2);
		//관리6일미만 테이블
		AdTableAdd();
	}
		
	//학습종료만료일
	public void AdTableAdd() {
		try {
			AdTable= new TodayTaskTBL().adTableSet(Svec);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		AdscrollPane = new JScrollPane(AdTable);
		AdscrollPane.setBounds(32, 462, 540, 124);
		AdscrollPane.setViewportView(AdTable);
		mainPanel.add(AdscrollPane);
	}
	
	//메인가는 버튼
	void mainbtn() {
		JButton btnNewButton = new JButton("메인화면");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(255, 128, 128));
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btnNewButton.setBounds(226, 612, 140, 51);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				new Main().run();;
				jf.dispose();
			}
		});	
		mainPanel.add(btnNewButton);
	}
}
