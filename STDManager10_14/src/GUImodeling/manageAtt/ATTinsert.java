package GUImodeling.manageAtt;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import GUImodeling.Result;
import GUImodeling.manageAtt.tool.ATTTable;
import GUImodeling.tool.Button;
import GUImodeling.tool.CheckBox;
import GUImodeling.tool.ComboBox;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;
import GUImodeling.tool.TextField;
import Student.StudentDB2;
import Student.StudentVO;
import attendance.AttendanceUtil;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class ATTinsert {
	JFrame jf;
	StudentVO vo;
	private JPanel mainPane,namePhonePanel;
	private JTextField phoneField1,phoneField2,phoneField3;
	private JPanel attChkPanel;
	private JScrollPane scrollpane;
	private JCheckBox periodChkBox1,periodChkBox2,periodChkBox3,periodChkBox4,periodChkBox5,periodChkBox6,periodChkBox7;
	private JComboBox comboBox1,comboBox2,comboBox3,comboBox4,comboBox5,comboBox6,comboBox7;
	private JTable table;
	private Vector<StudentVO> vec;
	private JTextField nameField;
	private String name,phone;
	JLabel label;
	String []reason={"출석","지각","조퇴","외출","출석인정"};

	public ATTinsert()  {
		jf = new Frame(879, 568).getJFrame();
		vec = new StudentDB2().selectStudentAttChk();
		mainPane = new Panel().get();
	}
	
	public void run() {
		jf.setContentPane(mainPane);
		mainPanel();
		jf.setVisible(true);
	}
	
	void mainPanel() {
		title();
		namePhonePanel();
		attChkPanel();
		table();
		failed();
	}
	
	void title() {
		JLabel lblNewLabel = new Label("출결 체크",20).getTitle();
		lblNewLabel.setBounds(389, 16, 94, 41);
		mainPane.add(lblNewLabel);
	}
	
	void namePhonePanel() {
		namePhonePanel = new Panel().get();
		namePhonePanel.setBounds(22, 54, 823, 51);
		mainPane.add(namePhonePanel);
		name(); phone();
		insertBtn();
	}
	
	void name() {
		JLabel lblNewLabel_1 = new Label("이름  : ",15).getPlain();
		lblNewLabel_1.setBounds(23, 10, 72, 31);
		namePhonePanel.add(lblNewLabel_1);
		
		nameField = new TextField(13,10).get();
		nameField.setBounds(94, 10, 142, 31);
		namePhonePanel.add(nameField);
	}
	
	void phone() {
		JLabel lblNewLabel_1_1 = new Label("전화번호  : ",15).getPlain();
		lblNewLabel_1_1.setBounds(248, 10, 88, 31);
		namePhonePanel.add(lblNewLabel_1_1);
		
		JLabel phoneLabel1 = new Label("-",14).getPlain();
		phoneLabel1.setBounds(395, 22, 22, 11);
		namePhonePanel.add(phoneLabel1);
		JLabel phoneLabel1_1 = new Label("-",14).getPlain();
		phoneLabel1_1.setBounds(493, 22, 22, 11);
		namePhonePanel.add(phoneLabel1_1);
		
		phone1(); phone2();	phone3();
	}
	
	void phone1() {
		phoneField1 = new TextField(13,3).get();
		phoneField1.setBounds(336, 10, 59, 31);
		namePhonePanel.add(phoneField1);
	}
	void phone2() {
		phoneField2  = new TextField(13,4).get();
		phoneField2.setBounds(418, 10, 78, 31);
		namePhonePanel.add(phoneField2);
	}
	void phone3() {
		phoneField3 = new TextField(13,4).get();
		phoneField3.setBounds(515, 10, 78, 31);
		namePhonePanel.add(phoneField3);
	}
	

	
	void insertBtn() {
		JButton btnNewButton = new Button("등록",12).getBtn();
		btnNewButton.setBounds(621, 12, 115, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				try {
					new Result(read(),"등록");
					new ATTinsert().run();
					jf.dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (NullPointerException e2) {
					label.setVisible(true);
				}
			}
		});
		namePhonePanel.add(btnNewButton);
	}
	
	void attChkPanel() {
		attChkPanel = new Panel().get();
		attChkPanel.setBounds(22, 115, 823, 114);
		mainPane.add(attChkPanel);
		attChk();
	}
	
	void attChk() {
		JLabel lblNewLabel_2 = new Label("*출석확인(미출석시 체크,사유변경)",12).getPlain();
		lblNewLabel_2.setBounds(0, 0, 308, 20);
		attChkPanel.add(lblNewLabel_2);
		period1(); period2(); period3(); period4();
		 period5(); period6(); period7();
	}
	
	void period1() {
		JPanel periodPanel1 = new Panel().get();
		periodPanel1.setBounds(10, 30, 149, 29);
		attChkPanel.add(periodPanel1);
		
		periodChkBox1 = new CheckBox("1교시",12).get();
		periodChkBox1.setBounds(0, 0, 65, 25);
		periodPanel1.add(periodChkBox1);
		
		comboBox1 = new ComboBox(reason,12).get();
		comboBox1.setBounds(65, 0, 68, 25);
		periodPanel1.add(comboBox1);
	}
	
	void period2() {
		JPanel periodPanel2 = new Panel().get();
		periodPanel2.setBounds(171, 30, 149, 29);
		attChkPanel.add(periodPanel2);
		
		periodChkBox2 = new CheckBox("2교시",12).get();
		periodChkBox2.setBounds(0, 0, 65, 25);
		periodPanel2.add(periodChkBox2);
		
		comboBox2 = new ComboBox(reason,12).get();
		comboBox2.setBounds(65, 0, 68, 25);
		periodPanel2.add(comboBox2);
	}
	
	void period3() {
		JPanel periodPanel3 = new Panel().get();
		periodPanel3.setBounds(332, 30, 149, 29);
		attChkPanel.add(periodPanel3);
		
		periodChkBox3 = new CheckBox("3교시",12).get();
		periodChkBox3.setBounds(0, 0, 65, 25);
		periodPanel3.add(periodChkBox3);
		
		comboBox3 = new ComboBox(reason,12).get();
		comboBox3.setBounds(65, 0, 68, 25);
		periodPanel3.add(comboBox3);
	}
	
	void period4() {
		JPanel periodPanel4 = new Panel().get();
		periodPanel4.setBounds(495, 30, 149, 29);
		attChkPanel.add(periodPanel4);
		
		periodChkBox4 = new CheckBox("4교시",12).get();
		periodChkBox4.setBounds(0, 0, 65, 25);
		periodPanel4.add(periodChkBox4);
		
		comboBox4 = new ComboBox(reason,12).get();
		comboBox4.setBounds(65, 0, 68, 25);
		periodPanel4.add(comboBox4);
	}
	
	void period5() {
		JPanel periodPanel5 = new Panel().get();
		periodPanel5.setBounds(10, 69, 149, 29);
		attChkPanel.add(periodPanel5);
		
		periodChkBox5 = new CheckBox("5교시",12).get();
		periodChkBox5.setBounds(0, 0, 65, 25);
		periodPanel5.add(periodChkBox5);
		
		comboBox5 = new ComboBox(reason,12).get();
		comboBox5.setBounds(65, 0, 68, 25);
		periodPanel5.add(comboBox5);
	}
	
	void period6() {
		JPanel periodPanel6 = new Panel().get();
		periodPanel6.setBounds(171, 69, 149, 29);
		attChkPanel.add(periodPanel6);
		
		periodChkBox6 = new CheckBox("6교시",12).get();
		periodChkBox6.setBounds(0, 0, 65, 25);
		periodPanel6.add(periodChkBox6);
		
		comboBox6 = new ComboBox(reason,12).get();
		comboBox6.setBounds(65, 0, 68, 25);
		periodPanel6.add(comboBox6);
	}
	
	void period7() {
		JPanel periodPanel7 = new Panel().get();
		periodPanel7.setBounds(332, 69, 149, 29);
		attChkPanel.add(periodPanel7);
		
		periodChkBox7 = new CheckBox("7교시",12).get();
		periodChkBox7.setBounds(0, 0, 65, 25);
		periodPanel7.add(periodChkBox7);
		
		comboBox7 = new ComboBox(reason,12).get();
		comboBox7.setBounds(65, 0, 68, 25);
		periodPanel7.add(comboBox7);
	}
	
	public void tableSet() {		
		try {
			table = new ATTTable().STDinfoTableSet(vec);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scrollpane = new JScrollPane(table);
		scrollpane.setViewportView(table);
		scrollpane.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		scrollpane.setBounds(22, 287, 823, 232);
		mainPane.add(scrollpane);
	}
	
	void table() {
		JLabel lblNewLabel_3 = new JLabel("출결체크 안된 명단");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(22, 251, 157, 26);
		mainPane.add(lblNewLabel_3);
		tableSet();
	}
	
	void failed() {
		label = new Label("이름과 번호를 다시 확인해주세요",12).getPlain();
		label.setForeground(new Color(255, 0, 0));
		label.setBounds(590, 35, 240, 15);
		mainPane.add(label).setVisible(false);
	}
	
	//입력한 데이터값 읽기
	public int read() throws SQLException {
		name=nameField.getText().trim();
		phone=phoneField1.getText().trim()+phoneField2.getText().trim()+phoneField3.getText().trim();
		 return insertAtt(readChkBox(getChkBox(),getComboBox()));
	}
	//체크박스번들
	public JCheckBox[] getChkBox() {
		JCheckBox[] chkBoxBundle= new JCheckBox[7];
		chkBoxBundle[0]=periodChkBox1;chkBoxBundle[1]=periodChkBox2;chkBoxBundle[2]=periodChkBox3;chkBoxBundle[3]=periodChkBox4;
		chkBoxBundle[4]=periodChkBox5;chkBoxBundle[5]=periodChkBox6;chkBoxBundle[6]=periodChkBox7;
		return chkBoxBundle;
	}
	//콤보박스번들
	public JComboBox[] getComboBox() {
		JComboBox[] comBoxBundle= new JComboBox[7];
		comBoxBundle[0]=comboBox1;comBoxBundle[1]=comboBox2;comBoxBundle[2]=comboBox3;comBoxBundle[3]=comboBox4;
		comBoxBundle[4]=comboBox5;comBoxBundle[5]=comboBox6;comBoxBundle[6]=comboBox7;
		return comBoxBundle;
	}
	
	//체크된 체크박스 선별해서 벡터에 넣기
	public Vector<String[]> readChkBox(JCheckBox[] chkBoxBundle,JComboBox[] comBoxBundle) {
		Vector<String[]> vec = new Vector<>();		
		for(int i=0;i<7;i++) {
			if(chkBoxBundle[i].isSelected()) {
				String [] comb = {chkBoxBundle[i].getText().substring(0,1) ,comBoxBundle[i].getSelectedItem().toString()};
				vec.add(comb);
			}
		}
		return vec;
	}
	
	//DB에 저장(리턴값 완료된 갯수)
	public int insertAtt(Vector<String[]> vec) throws SQLException {
		return new AttendanceUtil().insertAtt(new StudentDB2().selectStudentNP(name, phone).getStudentId(),vec);
	}
	
}

