package GUImodeling.consult;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import GUImodeling.Result;
import GUImodeling.careSTD.tool.STDTableCellChkBox;
import GUImodeling.careSTD.tool.STDsearchTBL;
import GUImodeling.consult.tool.ComboBoxUtil;
import GUImodeling.tool.Button;
import GUImodeling.tool.ComboBox;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;
import GUImodeling.tool.TextField;
import Student.StudentDAO;
import Student.StudentDB2;
import Student.StudentSQL;
import Student.StudentVO;
import consulting.ConsultingUtil;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JComboBox;

public class CONSULTinsert {

	JFrame jf;
	private JPanel contentPane,searchPanel,panel;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	JComboBox comboBox,comboBox1,comboBox2;
	Vector<StudentVO> Svec;
	STDTableCellChkBox tc;
	ComboBoxUtil cb;
	JLabel chkText;
	
	public CONSULTinsert() {
		jf = new Frame(900, 520).getJFrame();
		contentPane = new Panel().get();
		cb = new ComboBoxUtil();
		Svec = new StudentDAO().runVec(new StudentSQL().select());
	}
	
	public void run() {
		jf.setContentPane(contentPane);
		mainPanel();
		jf.setVisible(true);
	}
	
	void mainPanel() {
		title(); CPlanBtn();
		searchPanel();
		panel();
		table();
		failed();
	}
	
	void title() {
		JLabel lblNewLabel = new Label("다음주 상담 일정등록",20).getTitle();
		lblNewLabel.setBounds(314, 23, 221, 32);
		contentPane.add(lblNewLabel);
	}
	
	void searchPanel() {
		searchPanel = new Panel().get();
		searchPanel.setBounds(23, 68, 243, 69);
		contentPane.add(searchPanel);
		searchBtn(); label();
		
		textField = new TextField(10,50).get();
		textField.setBounds(51, 41, 116, 21);
		searchPanel.add(textField);
	}
	
	void label() {
		JLabel lblNewLabel_1 = new Label("학생검색",14).getTitle();
		lblNewLabel_1.setBounds(15, 13, 56, 20);
		searchPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new Label("이름 :",12).getPlain();
		lblNewLabel_1_1.setBounds(15, 43, 31, 17);
		searchPanel.add(lblNewLabel_1_1);
	}
	
	void CPlanBtn() {
		JButton btnNewButton = new Button().getCPlanBtn();
		contentPane.add(btnNewButton);
	}
	
	void searchBtn() {
		JButton btnNewButton_1 = new Button("검색",12).getBtn();
		btnNewButton_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		btnNewButton_1.setBounds(176, 39, 57, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Svec = new StudentDB2().selectStudentname(read()); 
				table = new STDsearchTBL().tableSet(Svec);
				table = setChkTable(table);
				scrollPane.setViewportView(table);
			}
		});
		searchPanel.add(btnNewButton_1);
	}
	
	void table() {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 157, 834, 208);
		contentPane.add(scrollPane);
		
		table = new STDsearchTBL().tableSet(Svec);
		table = setChkTable(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);	
	}
	
	void panel() {
		panel = new JPanel();
		panel.setBounds(23, 405, 834, 45);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		professor(); day(); time();
		insertBtn();
	}
	
	void professor() {
		JLabel lblNewLabel_2 = new Label("교수선택",14).getPlain();
		panel.add(lblNewLabel_2);
		
		String[] comboHeader = cb.getHeader();
		comboBox = new ComboBox(comboHeader,14).get();
		panel.add(comboBox);
	}
	
	void day() {
		JLabel lblNewLabel_3 = new Label("상담요일",14).getPlain();
		panel.add(lblNewLabel_3);
		
		String[] dayHeader = {"월","화","수","목","금"};
		comboBox1 = new ComboBox(dayHeader,14).get();
		panel.add(comboBox1);
	}
	
	void time() {
		JLabel lblNewLabel_4 = new Label("상담시간",14).getPlain();
		panel.add(lblNewLabel_4);
		
		String[] timeHeader = cb.getTimeHeader();
		comboBox2 = new ComboBox(timeHeader,14).get();
		panel.add(comboBox2);
	}
	
	void insertBtn() {
		JButton btnNewButton_2 = new Button("등록하기",14).getBtn();
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String time = comboBox2.getSelectedItem().toString();
					time = time.substring(0,time.length()-1);
					int PfId = cb.getPfId(comboBox);
					int day = cb.chkDay(comboBox1);
					if(new ConsultingUtil().chkConsult(day, time, PfId)!=1) {
						new Result(new ConsultingUtil().insertConsult(getSTDId(), day, time, PfId),"등록");	
						 chkText.setVisible(false);
					}
					else chkText.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_2);
	}
	
	void failed() {
		chkText = new Label("해당 시간에는 상담이 불가능합니다!",11).getPlain();
		chkText.setForeground(new Color(255, 0, 0));
		chkText.setBounds(233, 375, 441, 20);
		contentPane.add(chkText).setVisible(false);
	}
	
	public JTable setChkTable(JTable table) {	
		tc = new STDTableCellChkBox(table);
		table.getColumnModel().getColumn(0).setCellRenderer(tc);
		table.getColumnModel().getColumn(0).setCellEditor(tc);
		return table;
	}	
		
	public String read() {
		return textField.getText();
	}
	
	public int getSTDId() {
		String phone = tc.getPhone().substring(0, 3)+tc.getPhone().substring(4, 8)+tc.getPhone().substring(9);
		return new StudentDB2().selectStudentNP(tc.getName(),phone).getStudentId();
	}
}
