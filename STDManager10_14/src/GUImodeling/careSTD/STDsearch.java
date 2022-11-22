package GUImodeling.careSTD;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUImodeling.careSTD.tool.STDTableCellChkBox;
import GUImodeling.careSTD.tool.STDsearchTBL;
import GUImodeling.tool.Button;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;
import Student.StudentDB2;
import Student.StudentUtil;
import Student.StudentVO;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class STDsearch {

	JFrame jf;
	private JPanel contentPane;
	private JPanel filterPanel,tablePanel;
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	private JTextField textField;
	private JTable table;
	private String filter,value;
	private Vector<StudentVO> vec;
	private STDTableCellChkBox tc;

	public STDsearch()  {
		vec = new StudentDB2().selectStudent();
		jf = new Frame(1075, 634).getJFrame();
		contentPane = new Panel().get();
	}
	
	public void run() {
		jf.setContentPane(contentPane);
		mainPanel();
		jf.setVisible(true);
	}
	
	public void mainPanel()  {
		title();updateBtn();
		filterPanel(); tablePanel();
	}
	
	public void title() {
		JLabel lblNewLabel = new Label("학생 조회",25).getTitle();
		lblNewLabel.setBounds(450, 15, 120, 37);
		contentPane.add(lblNewLabel);
	}
	
	public void filterPanel() {
		filterPanel = new Panel().get();
		filterPanel.setBounds(23, 80, 646, 26);
		contentPane.add(filterPanel);
		filter(); searchBtn();
		searchWord();
	}
	public void filter() {
		JLabel filterLabel = new Label("필터",12).getPlain();
		filterLabel.setBounds(0, 4, 31, 15);
		filterPanel.add(filterLabel);
		filterComboBox();
	}
	@SuppressWarnings("unchecked")
	public void filterComboBox() {
		String []header = {"전체","이름","나이","성별","전화번호","주소","메모","이용종료일","패널티","관리시작일","관리종료일"};
		comboBox = new JComboBox(header);
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		comboBox.setBounds(43, 2, 119, 23);
		filterPanel.add(comboBox);
	}

	public void searchBtn() {
		JButton searchBtn = new Button("조회하기",12).getBtn();
		searchBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		searchBtn.setBounds(536, 2, 97, 23);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				read();
					table = new STDsearchTBL().tableSet(new StudentUtil().filterChk(filter,value));
					table = setChkTable(table);
				scrollPane.setViewportView(table);
			}
		});	
		filterPanel.add(searchBtn);
	}
	
	public void updateBtn() {
		JButton updateBtn = new Button("수정하기",15).getBtn();
		updateBtn.setBounds(900, 60, 100, 40);
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new STDedit(tc.getName(),tc.getPhone()).run();
				jf.dispose();
			}
		});	
		contentPane.add(updateBtn);
	}
	
	public void searchWord() {
		JLabel lblNewLabel_2 = new Label("검색어",12).getPlain();
		lblNewLabel_2.setBounds(323, 6, 45, 15);
		filterPanel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(380, 4, 154, 21);
		filterPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new Label("*날짜는 yy/mm/dd 형식으로",12).getPlain();
		lblNewLabel_3.setBounds(670, 85, 166, 15);
		contentPane.add(lblNewLabel_3);
	}
	
	public void tablePanel()  {
		tablePanel = new Panel().get();
		tablePanel.setBounds(12, 121, 1023, 460);
		contentPane.add(tablePanel);
		table();
	}
	public void table() {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1023, 460);
		table = new STDsearchTBL().tableSet(vec);
		table = setChkTable(table);
		scrollPane.setViewportView(table);
		tablePanel.add(scrollPane);
	}
	
	public JTable setChkTable(JTable table)  {	
		tc = new STDTableCellChkBox(table);
		table.getColumnModel().getColumn(0).setCellRenderer(tc);
		table.getColumnModel().getColumn(0).setCellEditor(tc);
		return table;
	}
	
	public void read() {
		filter=comboBox.getSelectedItem().toString();
		value=textField.getText();
	}
	
}
