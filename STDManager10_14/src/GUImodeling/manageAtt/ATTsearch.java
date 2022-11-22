package GUImodeling.manageAtt;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import GUImodeling.manageAtt.tool.ATTTable;
import GUImodeling.tool.Button;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;
import attendance.AttendanceSQL;
import attendance.AttendanceUtil;
import attendance.AttendanceVO;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class ATTsearch {
	JFrame jf;
	private JPanel contentPane;
	private String name;
	private String phone;
	private String filter;
	private JPanel panel,panel_2;
	private JPanel namePanel,PhonePanel,filterPanel;
	JTextField nameField;
	JTextField phoneField1,phoneField2,phoneField3;
	JComboBox comboBox;
	private Vector<AttendanceVO> vec;

	public ATTsearch() {
		name = ""; phone = "";
		jf = new Frame(696, 711).getJFrame();
		contentPane = new Panel().get();
		try {
			vec=new AttendanceUtil().selectAll(new AttendanceSQL().todaySearch());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void run() {
		jf.setContentPane(contentPane);
		mainPanel();	
		jf.setVisible(true);
	}
	
	public void mainPanel() {
		title();
		Panel();
	}
		
		
	//타이틀
	public void title() {
		JLabel Title = new JLabel("출석조회");
		Title.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setBounds(297, 10, 80, 27);
		contentPane.add(Title);
	}
	

	public void Panel()  {
		panel = new Panel().get();
		panel.setBounds(12, 56, 656, 115);
		contentPane.add(panel);
		namePanel();
		phonePanel();
		filterPanel();
		tablePanel();
		searchBTN();
	}
	
	//조회버튼
	public void searchBTN() {
		JButton SearchBtn = new Button("조회",14).getBtn();
		SearchBtn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		SearchBtn.setBounds(566, 21, 78, 73);
		SearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {						
				try {
					read();
					getdata(new AttendanceUtil().filterChk(filter));
					tableSet();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				jf.setVisible(true);
			}
		});	
		panel.add(SearchBtn);
	}
	
	//이름패널
	public void namePanel() {
		namePanel = new Panel().get();
		namePanel.setBackground(new Color(255, 193, 193));
		namePanel.setBounds(12, 10, 206, 37);
		panel.add(namePanel);
		name();
	}
	//이름
	public void name() {
		nameField = new JTextField();
		nameField.setBounds(51, 0, 155, 37);
		namePanel.add(nameField);
		nameField.setColumns(15);
		
		JLabel lblNewLabel_1 = new Label("이름",12).getPlain();
		lblNewLabel_1.setBounds(0, 0, 51, 37);
		namePanel.add(lblNewLabel_1);
	}
	
	//전화번호패널
	public void phonePanel() {
		PhonePanel = new Panel().get();
		PhonePanel.setBackground(new Color(255, 193, 193));
		PhonePanel.setBounds(276, 10, 257, 37);
		panel.add(PhonePanel);
		phone();
	}
	//전화번호
	public void phone() {
		JLabel lblNewLabel_1_1 = new Label("전화번호",12).getPlain();
		lblNewLabel_1_1.setBounds(0, 0, 68, 37);
		PhonePanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new Label("-",11).getTitle();
		lblNewLabel.setBounds(102, 11, 38, 15);
		PhonePanel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new Label("-",11).getTitle();
		lblNewLabel_2.setBounds(170, 11, 46, 15);
		PhonePanel.add(lblNewLabel_2);
		phone1();phone2();phone3();
	}
	public void phone1() {//맨앞자리
		phoneField1 = new JTextField(); 
		phoneField1.setColumns(10);
		phoneField1.setBounds(69, 0, 46, 37);
		PhonePanel.add(phoneField1);
	}
	public void phone2() {//중간자리
		phoneField2 = new JTextField(); 
		phoneField2.setColumns(10);
		phoneField2.setBounds(127, 0, 61, 37);
		PhonePanel.add(phoneField2);
	}
	public void phone3() {//마지막자리
		phoneField3 = new JTextField(); 
		phoneField3.setColumns(10);
		phoneField3.setBounds(200, 0, 57, 37);
		PhonePanel.add(phoneField3);
	}
	
	//필터패널
	public void filterPanel() {
		filterPanel = new Panel().get();
		filterPanel.setBounds(12, 73, 224, 32);
		panel.add(filterPanel);
		filter();
	}
	
	public void filter() {
		JLabel lblNewLabel_3 = new Label("조회주차",12).getPlain();
		lblNewLabel_3.setBounds(12, 5, 62, 22);
		filterPanel.add(lblNewLabel_3);
		
		String[] week = {"오늘","이번달","1주차","2주차","3주차","4주차","5주차"};
		comboBox = new JComboBox(week);
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		comboBox.setBounds(74, 0, 62, 32);
		filterPanel.add(comboBox);
	}
	
	//테이블패널
	public void tablePanel() {
		panel_2 = new Panel().get();
		panel_2.setBounds(12, 203, 656, 459);
		contentPane.add(panel_2);
		try {
			tableSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void getdata(int date) {
		AttendanceSQL Asql = new AttendanceSQL();
		String sql = null;
		if(date==100) sql="";
		else if(name.length()==0) {
			if(phone.length()==0) {
				if(date==0) sql=Asql.todaySearch();
				else if(date>31) sql = Asql.monthlySearch();
				else sql=Asql.weeklySearch(date);
			}
			else {
				if(date==0) sql=Asql.todaySearchKV("phone",phone);
				else if(date>31) sql = Asql.monthlySearchKV("phone",phone);
				else sql=Asql.weeklySearch("phone",phone,date);
			}
	}
	else {
		if(phone.length()==0) {
			if(date==0) sql=Asql.todaySearchKV("name",name);
			else if(date>31) sql = Asql.monthlySearchKV("name",name);
			else sql=Asql.weeklySearch("name",name,date);
		}
		else {
			if(date==0) sql=Asql.todaySearch(name,phone);
			else if(date>31) sql = Asql.monthlySearch(name,phone);
			else sql=Asql.weeklySearch(name,phone,date);
		}
	}
		if(sql.length()==0) vec = new Vector<AttendanceVO>();
		else
			try {
				vec = new AttendanceUtil().selectAll(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	}
	
	public void read() {
		name=nameField.getText().trim();
		phone=phoneField1.getText().trim()+phoneField2.getText().trim()+phoneField3.getText().trim();
		filter=comboBox.getSelectedItem().toString();
	}
	
	public void tableSet() throws SQLException {
		JTable table = new ATTTable().tableSet(vec);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		scrollpane.setBackground(new Color(255, 172, 172));
		scrollpane.setBounds(0, 0, 656, 459); //12, 203, 656, 459
		panel_2.add(scrollpane);
	}
	
	
}
