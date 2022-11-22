package GUImodeling.manageAtt;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import GUImodeling.Result;
import GUImodeling.careSTD.tool.STDTableCellChkBox;
import GUImodeling.manageAtt.tool.ATTTable;
import GUImodeling.tool.Button;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;
import GUImodeling.tool.TextField;
import Student.StudentDAO;
import Student.StudentDB2;
import Student.StudentSQL;
import Student.StudentUtil;
import schedule.ScheduleDAO;
import schedule.ScheduleSQL;
import schedule.ScheduleUtil;
import schedule.ScheduleVO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JTextField;

import javax.swing.JTable;

import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class manageSchedule {
	JFrame jf;
	Vector<ScheduleVO> SCvec;
	ScheduleVO vo;
	private JPanel mainPane,datePanel,DMLbtn;
	private JPanel namePhonePanel,namePanel,phonePanel,memoPanel;
	private JTextField memoField;
	private JTextField phoneField1;
	private JTextField nameField;
	private JTextField dateField;
	private JScrollPane STDinfoScrollPane,scheduleScrollPane;
	private JTable STDinfoTable;
	private JTable scheduleTable;
	private String name,phone,date,memo;
	private JTextField phoneField3;
	private JTextField phoneField2;
	private Object [][]contents;
	private StudentDAO studentdb;
	private ScheduleDAO scheduledao;
	STDTableCellChkBox tc;
	ATTTable at;
	private JLabel lblNewLabel_3;

	public manageSchedule()  {
		jf = new Frame(850, 660).getJFrame();
		mainPane = new Panel().get();
		studentdb = new StudentDAO();
		scheduledao = new ScheduleDAO();
		at = new ATTTable();
		SCvec = scheduledao.select(new ScheduleSQL().select());
		contents= new StudentUtil().contentsSchedule(studentdb.runVec(new StudentSQL().select()));
	}
	
	public void run() {
		jf.setContentPane(mainPane);
		mainPanel();
		jf.setVisible(true);
	}
	
	void mainPanel() {
		title(); basicSet();
		dataPanel();
		namePhonePanel();
		memoPanel();
		DMLbtnPanel();
		STDtableSet();
		scheduleTableSet();
		failed();
	}
	void title() {
		JLabel title = new Label("스케줄 관리",20).getTitle();
		title.setBackground(Color.PINK);
		title.setBounds(355, 10, 125, 33);
		mainPane.add(title);
		
		JLabel searchLabel = new Label("학생 검색하기",14).getTitle();
		searchLabel.setBounds(35, 46, 98, 22);
		mainPane.add(searchLabel);
	}
	
	void dataPanel() {
		datePanel = new Panel().get();
		datePanel.setBounds(540, 35, 282, 51);
		mainPane.add(datePanel);
		dataLblPanel();
		
		JLabel dateLabel1 = new Label("yy/mm/dd",12).getPlain();
		dateLabel1.setBounds(208, 14, 83, 15);
		datePanel.add(dateLabel1);
	}
	
	void dataLblPanel() {
		JPanel datelblPanel = new Panel().get();
		datelblPanel.setBackground(new Color(210, 189, 172));
		datelblPanel.setBounds(12, 10, 190, 23);
		datePanel.add(datelblPanel);
		
		JLabel dateLabel = new Label("날짜",12).getPlain();
		dateLabel.setBounds(0, 0, 70, 23);
		datelblPanel.add(dateLabel);
		
		dateField = new TextField(10,8).get();
		dateField.setBounds(69, 0, 121, 23);
		datelblPanel.add(dateField);
	}
	
	void DMLbtnPanel(){
		DMLbtn = new Panel().get();
		DMLbtn.setBounds(690, 87, 132, 120);
		mainPane.add(DMLbtn);
		insertBtn(); editBtn();
	}
	
	//등록버튼
	void insertBtn() {
		JButton insertBtn = new Button("등록",15).getBtn();
		insertBtn.setBounds(12, 10, 105, 27);
		DMLbtn.add(insertBtn);
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					read(); 
					new Result(insert(),"등록");
					reset();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		DMLbtn.add(insertBtn);
	}
	//수정버튼
	void editBtn() {
		JButton editBtn = new Button("수정",15).getBtn();
		editBtn.setBounds(12, 47, 105, 27);
		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					read(); 
					new Result(update(),"수정");
					reset();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		DMLbtn.add(editBtn);
	}
	
	//삭제버튼
	void deleteBtn() {
		JButton deleteBtn = new Button("삭제",15).getBtn();
		deleteBtn.setBounds(12, 84, 105, 27);
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					read(); 
					new Result(delete(),"등록");
					reset();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		DMLbtn.add(deleteBtn);
	}
	
	void namePhonePanel() {
		namePhonePanel = new Panel().get();
		namePhonePanel.setBounds(25, 70, 314, 76);
		namePhonePanel.setBackground(new Color(210, 189, 172));
		mainPane.add(namePhonePanel);
		phonePanel(); namePanel(); searchBtn();
	}
	
	void phonePanel() {
		phonePanel = new Panel().get();
		phonePanel.setBackground(new Color(210, 189, 172));
		phonePanel.setBounds(0, 48, 214, 23);
		namePhonePanel.add(phonePanel);
		phone();
	}
	
	void phone() {
		JLabel phoneLabel = new Label("전화번호",12).getPlain();
		phoneLabel.setBounds(0, 0, 70, 23);
		phonePanel.add(phoneLabel);
		
		phoneField1 = new TextField(10,3).get();
		phoneField1.setBounds(68, 0, 36, 23);
		phoneField1.setColumns(10);
		phonePanel.add(phoneField1);
		
		JLabel lblNewLabel = new Label("-",12).getTitle();
		lblNewLabel.setBounds(101, 4, 16, 15);
		phonePanel.add(lblNewLabel);
		
		phoneField2  = new TextField(10,4).get();
		phoneField2.setColumns(10);
		phoneField2.setBounds(116, 1, 43, 23);
		phonePanel.add(phoneField2);
		
		JLabel lblNewLabel_1= new Label("-",12).getTitle();
		lblNewLabel_1.setBounds(157, 4, 16, 15);
		phonePanel.add(lblNewLabel_1);
		
		phoneField3  = new TextField(10,4).get();
		phoneField3.setColumns(10);
		phoneField3.setBounds(171, 0, 43, 23);
		phonePanel.add(phoneField3);
	}
	
	void namePanel() {
		namePanel = new Panel().get();
		namePanel.setBackground(new Color(210, 189, 172));
		namePanel.setBounds(0, 10, 202, 23);
		namePhonePanel.add(namePanel);
		name();
	}
	
	void name() {
		JLabel nameLabel = new Label("이름",12).getPlain();
		nameLabel.setBounds(0, 0, 70, 23);
		namePanel.add(nameLabel);
		
		nameField = new TextField(10,10).get();
		nameField.setBounds(69, 0, 133, 23);
		namePanel.add(nameField);
	}
	
	void searchBtn() {
		JButton searchBtn = new JButton("검색");
		searchBtn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		searchBtn.setBounds(226, 10, 77, 61);
		namePhonePanel.add(searchBtn);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lblNewLabel_3.setVisible(false);
					read(); setContents();		
					STDinfoTable=at.STDinfoTableSet(contents);
					STDinfoTable=at.STDtableColumnSize(STDinfoTable);	
					tc = at.setChkColumn(STDinfoTable);
					SCvec = scheduledao.select(new ScheduleSQL().select(name,phone));
					scheduleTable=at.scheduleTableSet(SCvec);
				} catch (SQLException e1) {				
				} catch (NullPointerException e2) {
					lblNewLabel_3.setVisible(true);
				}
				STDinfoScrollPane.setViewportView(STDinfoTable);
				scheduleScrollPane.setViewportView(scheduleTable);
			}	
		});
	}
	
	void memoPanel() {
		memoPanel = new Panel().get();
		memoPanel.setBounds(340, 53, 335, 154);
		mainPane.add(memoPanel);
		memo();
	}
	
	void memo() {
		JLabel memoLabel = new Label("메모",14).getTitle();
		memoLabel.setBounds(54, 10, 66, 22);
		memoPanel.add(memoLabel);
		
		memoField = new TextField(12,50).get();
		memoField.setHorizontalAlignment(SwingConstants.LEFT);
		memoField.setBounds(54, 42, 269, 102);
		memoPanel.add(memoField);
	}
	
	void basicSet() {
		JLabel lblNewLabel_2 = new Label("학생목록",14).getTitle();
		lblNewLabel_2.setBounds(25, 217, 108, 15);
		mainPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new Label("스케줄목록",14).getTitle();
		lblNewLabel_2_1.setBounds(25, 368, 108, 22);
		mainPane.add(lblNewLabel_2_1);
	}
	
	void STDtableSet() {
		STDinfoTable=at.STDinfoTableSet(contents);
		STDinfoTable=at.STDtableColumnSize(STDinfoTable);	
		tc = at.setChkColumn(STDinfoTable);
		
		STDinfoScrollPane = new JScrollPane(STDinfoTable);
		STDinfoScrollPane.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		STDinfoScrollPane.setBounds(25, 238, 785, 120);
		STDinfoScrollPane.setViewportView(STDinfoTable);
		mainPane.add(STDinfoScrollPane);
	}
	
	void scheduleTableSet() {
		try {
			scheduleTable=new ATTTable().scheduleTableSet(SCvec);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scheduleScrollPane = new JScrollPane(scheduleTable);
		scheduleScrollPane.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		scheduleScrollPane.setBounds(25, 393, 785, 218);
		mainPane.add(scheduleScrollPane);
		scheduleScrollPane.setViewportView(scheduleTable);
	}
	
	void failed() {
		lblNewLabel_3 = new Label("해당하는 학생이 없습니다.",12).getPlain();
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBounds(25, 156, 174, 22);
		mainPane.add(lblNewLabel_3).setVisible(false);
	}
		
	public void read() {
		name=nameField.getText().trim();
		if(name==null||name.length()==0) name=tc.getName();
		phone=phoneField1.getText().trim()+phoneField2.getText().trim()+phoneField3.getText().trim();
		if(phone==null||phone.length()==0) readCheck();
		date=dateField.getText().trim(); memo=memoField.getText().trim();
	}
	public void readCheck() {
		phone = tc.getPhone().substring(0, 3)+tc.getPhone().substring(4, 8)+tc.getPhone().substring(9);
	}
	
	public void setContents() throws SQLException {
		contents = new ScheduleUtil().contents(new StudentDB2().selectStudentNP(name, phone));
	}
	
	public void reset() throws SQLException {
		SCvec = scheduledao.select(new ScheduleSQL().select());
		contents= new StudentUtil().contents(studentdb.runVec(new StudentSQL().select()));
		STDinfoTable=at.STDinfoTableSet(contents);
		STDinfoTable=at.STDtableColumnSize(STDinfoTable);	
		tc = at.setChkColumn(STDinfoTable);
		scheduleTable = at.scheduleTableSet(SCvec);
		scheduleScrollPane.setViewportView(scheduleTable);
		STDinfoScrollPane.setViewportView(STDinfoTable);
	}

	public int insert() {
		read();
		return scheduledao.run(new ScheduleSQL().insert(new StudentUtil().getSTDVO(name, phone).getStudentId(),date, memo));
	}
	public int update() {
		read();
		return scheduledao.run(new ScheduleSQL().update(new StudentUtil().getSTDVO(name, phone).getStudentId(),date, memo));
	}
	public int delete() {
		read();
		return scheduledao.run(new ScheduleSQL().delete(new StudentUtil().getSTDVO(name, phone).getStudentId(),date));
	}
}
