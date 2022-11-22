package GUImodeling.careSTD;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import GUImodeling.Result;
import GUImodeling.tool.Button;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;
import Student.StudentDB2;
import Student.StudentUtil;

public class STDedit implements ActionListener{
	JFrame jf;
	private JPanel contentPane;
	private JPanel panel,namePanel,agePanel,addrPanel;
	private	JPanel phonePanel,sexPanel,SCDPanel,memoPanel;
	private JTextField name,age,addr;
	private JTextField phone,phone2,phone3;
	private JTextField startCareDay,memo;
	private JTextField[] jtflist;
	private String originName,originPhone,sex,phoneFull;
	private int stdId;

	public STDedit(String name, String phone) {
		jf = new Frame(480, 647).getJFrame(); //450,300
		contentPane = new Panel().get();
		originName=name; originPhone=phone;
		this.phoneFull = originPhone.substring(0, 3)+originPhone.substring(4, 8)+originPhone.substring(9);
		originPhone = phoneFull;
		stdId = new StudentDB2().selectStudentNP(originName,this.phoneFull).getStudentId();
		jtflist = new JTextField[6];
	}

public void run() {
	jf.setContentPane(contentPane);
	basicSet(); mainPanel();
	jf.setVisible(true);
}
public void basicSet() {
	JLabel lblNewLabel_3 = new Label("YY/MM/DD",12).getPlain();
	lblNewLabel_3.setBounds(225, 264, 106, 15);
	contentPane.add(lblNewLabel_3);
}

//main Panel
	public void mainPanel() {	
		panel = new Panel().get();
		panel.setBounds(35, 94, 394, 407);
		contentPane.add(panel);
		title();
		namePanel(); agePanel(); addrPanel();
		phonePanel(); sexPanel(); SCDPanel();
		memoPanel(); updateBtn();
	}
	
	public void title() {
		JLabel lblNewLabel = new Label("학생수정",20).getTitle();
		lblNewLabel.setBounds(163, 10, 150, 45);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new Label("* 수정할 정보만 입력하세요.",12).getTitle();
		lblNewLabel_1.setBounds(15, 75, 200, 15);
		contentPane.add(lblNewLabel_1);
	}
	
	//이름
	public void namePanel() {
		namePanel = new Panel().get();
		namePanel.setBackground(new Color(255, 204, 204));
		namePanel.setBounds(0, 0, 196, 32);
		name();
		panel.add(namePanel);
	}

	public void name() {
		JLabel nameLabel = new Label("이름",12).getPlain();
		nameLabel.setBounds(0, 0, 49, 32);
		namePanel.add(nameLabel);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(255, 204, 204));
		layeredPane.setBounds(0, 0, 49, 32);
		namePanel.add(layeredPane);
		
		name = new JTextField();
		name.setName("name");
		name.setText(originName);
		name.setColumns(15);
		name.setBorder(new EmptyBorder(0, 0, 0, 0));
		name.setBounds(48, 0, 148, 32);
		namePanel.add(name);
	}
	
	//나이
	public void agePanel() {
		agePanel = new Panel().get();
		agePanel.setBackground(new Color(255, 204, 204));
		agePanel.setBounds(248, 0, 146, 32);
		age();
		panel.add(agePanel);
	}
	public void age() {
		JLabel ageLabel = new Label("나이",12).getPlain();
		ageLabel.setBounds(0, 0, 49, 32);
		agePanel.add(ageLabel);
		
		age = new JTextField();
		age.setName("age");
		jtflist[0]=age;
		age.setColumns(15);
		age.setBorder(new EmptyBorder(0, 0, 0, 0));
		age.setBounds(48, 0, 98, 32);
		agePanel.add(age);
	}
	
	//주소
	public void addrPanel() {
		addrPanel = new Panel().get();
		addrPanel.setBackground(new Color(255, 204, 204));
		addrPanel.setBounds(0, 108, 394, 32);
		addr();
		panel.add(addrPanel);
	}
	public void addr() {
		JLabel addrNameLabel = new Label("주소",12).getPlain();
		addrNameLabel.setBounds(0, 0, 49, 32);
		addrPanel.add(addrNameLabel);
		
		addr = new JTextField();
		addr.setName("addr");
		jtflist[1]=addr;
		addr.setColumns(15);
		addr.setBorder(new EmptyBorder(0, 0, 0, 0));
		addr.setBounds(48, 0, 346, 32);
		addrPanel.add(addr);
	}
	
	//전화번호
	public void phonePanel() {
		phonePanel = new Panel().get();
		phonePanel.setBackground(new Color(255, 204, 204));
		phonePanel.setBounds(0, 54, 219, 32);
		phone();
		panel.add(phonePanel);
	}
	public void phone() {
		JLabel phoneLabel = new Label("전화번호",11).getPlain();
		phoneLabel.setBounds(0, 0, 49, 32);
		JLabel lblNewLabel_2 = new Label("-",11).getTitle();
		lblNewLabel_2.setBounds(86, 9, 15, 17);
		phonePanel.add(lblNewLabel_2);	
		JLabel lblNewLabel_2_1 = new Label("-",11).getTitle();
		lblNewLabel_2_1.setBounds(148, 9, 15, 17);
		phonePanel.add(lblNewLabel_2_1);
		phone1();phone2();phone3();
		phonePanel.add(phoneLabel);
	}
	public void phone1() {
		phone = new JTextField();
		phone.setName("phone");
		phone.setText(originPhone.substring(0, 3));
		phone.setColumns(3);
		phone.setBorder(new EmptyBorder(0, 0, 0, 0));
		phone.setBounds(48, 0, 39, 32);
		phonePanel.add(phone);	
	}
	public void phone2() {
		phone2 = new JTextField();
		phone2.setText(originPhone.substring(3, 7));
		phone2.setColumns(4);
		phone2.setBorder(new EmptyBorder(0, 0, 0, 0));
		phone2.setBounds(100, 0, 50, 32);
		phonePanel.add(phone2);
	}
	public void phone3() {
		phone3 = new JTextField();
		phone3.setText(originPhone.substring(7));
		phone3.setColumns(4);
		phone3.setBorder(new EmptyBorder(0, 0, 0, 0));
		phone3.setBounds(162, 0, 57, 32);
		phonePanel.add(phone3);
	}
	
	//성별
	public void sexPanel() {
		sexPanel = new Panel().get();
		sexPanel.setBounds(231, 54, 163, 32);
		sexPanel.setBackground(new Color(255, 204, 204));
		sex();
		panel.add(sexPanel);
	}
	public void sex() {
		JLabel sexLabel = new Label("성별",12).getPlain();
		sexLabel.setBounds(0, 0, 49, 32);
		sexPanel.add(sexLabel);
		
		JRadioButton sex1_RadioBtn = new JRadioButton("남");
		sex1_RadioBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		sex1_RadioBtn.setBounds(67, 5, 40, 23);
		sexPanel.add(sex1_RadioBtn);
		
		JRadioButton sex2_RadioBtn = new JRadioButton("여");
		sex2_RadioBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		sex2_RadioBtn.setBounds(112, 5, 49, 23);
		sexPanel.add(sex2_RadioBtn);
		//버튼 그룹으로 묶기
		ButtonGroup group = new ButtonGroup();
		group.add(sex1_RadioBtn);
		group.add(sex2_RadioBtn);
		sex1_RadioBtn.addActionListener(this);
		sex2_RadioBtn.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		sex =  e.getActionCommand();
	}
	
	//관리시작일
	public void SCDPanel() {
		SCDPanel = new Panel().get();
		SCDPanel.setBackground(new Color(255, 204, 204));
		SCDPanel.setBounds(0, 161, 196, 32);
		scd();
		panel.add(SCDPanel);
	}
	public void scd() {
		JLabel SCDLabel = new Label("관리시작일",11).getPlain();
		SCDLabel.setBounds(0, 0, 68, 32);
		SCDPanel.add(SCDLabel);
		
		startCareDay = new JTextField();
		startCareDay.setName("startCareDay");
		jtflist[2]=startCareDay;
		startCareDay.setColumns(15);
		startCareDay.setBorder(new EmptyBorder(0, 0, 0, 0));
		startCareDay.setBounds(68, 0, 128, 32);
		SCDPanel.add(startCareDay);
	}
	
	//메모
	public void memoPanel() {
		memoPanel = new JPanel();
		memoPanel.setLayout(null);
		memoPanel.setBounds(0, 214, 394, 191);
		memo();
		panel.add(memoPanel);
	}
	public void memo() {
		JLabel memoLabel = new Label("메모",12).getPlain();
		memoLabel.setBounds(0, 0, 49, 32);
		memoPanel.add(memoLabel);
		
		memo = new JTextField();
		memo.setName("memo");
		jtflist[3]=memo;
		memo.setColumns(15);
		memo.setBorder(new EmptyBorder(0, 0, 0, 0));
		memo.setBounds(0, 33, 394, 158);
		memoPanel.add(memo);	
	}
	//등록버튼
	public void updateBtn() {
		JButton insertBtn = new Button("수정하기",15).getBtn();
		insertBtn.setBounds(163, 536, 150, 45);
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					setData();
					new Result(new StudentUtil().update(stdId,jtflist,sex),"수정");
					new STDsearch().run();
				jf.dispose();
			}
		});	
		contentPane.add(insertBtn);
	}

	void setData() {
		jtflist[4] = name;
		phoneFull =phone.getText()+phone2.getText()+phone3.getText();
		phone.setText(phoneFull);
		jtflist[5] = phone;
	}
}
