package GUImodeling.careSTD;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import GUImodeling.Result;
import GUImodeling.tool.Button;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;
import Student.StudentUtil;
import Student.StudentVO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLayeredPane;

public class STDinsert  implements ActionListener {
	JFrame jf;
	private JPanel contentPane;
	private JPanel panel,namePanel,agePanel,addrPanel;
	private	JPanel phonePanel,sexPanel,SCDPanel,memoPanel;
	private JTextField nameTextField,ageTextField,addrTextField;
	private JTextField phoneTextField1,phoneTextField2,phoneTextField3;
	private JTextField SCDtextField,textField;
	private String name,phone,scd,sex;
	private JLabel label;
	
	public STDinsert() {
		jf = new Frame(480, 647).getJFrame();
		contentPane = new Panel().get();
	}
	
	public void run() {
		jf.setContentPane(contentPane);
		basicSet(); mainPanel();
		chkData();
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
			memoPanel(); insertBtn();
		}
		
		public void title() {
			JLabel lblNewLabel = new Label("학생등록",20).getTitle();
			lblNewLabel.setBounds(163, 10, 150, 45);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new Label("* 이름, 전화번호, 관리시작일은 필수사항입니다.",12).getTitle();
			lblNewLabel_1.setBounds(35, 75, 270, 15);
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
			
			nameTextField = new JTextField();
			nameTextField.setColumns(15);
			nameTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
			nameTextField.setBounds(48, 0, 148, 32);
			namePanel.add(nameTextField);
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
			
			ageTextField = new JTextField();
			ageTextField.setColumns(15);
			ageTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
			ageTextField.setBounds(48, 0, 98, 32);
			agePanel.add(ageTextField);
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
			
			addrTextField = new JTextField();
			addrTextField.setColumns(15);
			addrTextField.setBorder(new EmptyBorder(0, 0, 0, 0));
			addrTextField.setBounds(48, 0, 346, 32);
			addrPanel.add(addrTextField);
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
			phoneTextField1 = new JTextField();
			phoneTextField1.setColumns(15);
			phoneTextField1.setBorder(new EmptyBorder(0, 0, 0, 0));
			phoneTextField1.setBounds(48, 0, 39, 32);
			phonePanel.add(phoneTextField1);	
		}
		public void phone2() {
			phoneTextField2 = new JTextField();
			phoneTextField2.setColumns(15);
			phoneTextField2.setBorder(new EmptyBorder(0, 0, 0, 0));
			phoneTextField2.setBounds(100, 0, 50, 32);
			phonePanel.add(phoneTextField2);
		}
		public void phone3() {
			phoneTextField3 = new JTextField();
			phoneTextField3.setColumns(15);
			phoneTextField3.setBorder(new EmptyBorder(0, 0, 0, 0));
			phoneTextField3.setBounds(162, 0, 57, 32);
			phonePanel.add(phoneTextField3);
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
			
			SCDtextField = new JTextField();
			SCDtextField.setColumns(15);
			SCDtextField.setBorder(new EmptyBorder(0, 0, 0, 0));
			SCDtextField.setBounds(68, 0, 128, 32);
			SCDPanel.add(SCDtextField);
		}
		
		//메모
		public void memoPanel() {
			memoPanel = new Panel().get();
			memoPanel.setBounds(0, 214, 394, 191);
			memo();
			panel.add(memoPanel);
		}
		public void memo() {
			JLabel memoLabel = new Label("메모",12).getPlain();
			memoLabel.setBounds(0, 0, 49, 32);
			memoPanel.add(memoLabel);
			
			textField = new JTextField();
			textField.setColumns(15);
			textField.setBorder(new EmptyBorder(0, 0, 0, 0));
			textField.setBounds(0, 33, 394, 158);
			memoPanel.add(textField);	
		}
		//등록버튼
		public void insertBtn() {
			JButton insertBtn = new Button("등록하기",15).getBtn();
			insertBtn.setBounds(163, 536, 150, 45);
			insertBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						read();
						if(name.length()==0||phone.length()==0||scd.length()==0)
							label.setVisible(true);
						else {
							new Result(insert(),"등록");
							jf.dispose();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}			
				}
			});	
			contentPane.add(insertBtn);
		}
		
		void chkData() {
			label = new Label("이름, 전화번호, 관리시작일을 입력하세요!!",11).getPlain();
			label.setForeground(new Color(255, 0, 0));
			label.setBounds(120, 515, 240, 16);
			contentPane.add(label).setVisible(false);
		}
		//db에 저장
		public int insert() throws SQLException {
			int age = 0;
			if(ageTextField.getText().trim().length()!=0) age = Integer.parseInt(ageTextField.getText().trim());
			return new StudentUtil().studentInsert(new StudentVO(name,age,sex,
				phone,addrTextField.getText(),""+textField.getText(),scd));	
		}
		
		void read() {
			if(sex==null) sex="x";
			name = nameTextField.getText();
			phone = phoneTextField1.getText()+phoneTextField2.getText()+phoneTextField3.getText();
			scd = SCDtextField.getText();
		}
}
