package GUImodeling.consult;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import GUImodeling.consult.tool.ConsultTBL;
import GUImodeling.consult.tool.ConsultTableCellChkBox;
import GUImodeling.tool.Button;
import GUImodeling.tool.ComboBox;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;
import consulting.ConsultMiniVO;
import consulting.ConsultingDAO;
import consulting.ConsultingSQL;
import consulting.ConsultingUtil;
import javax.swing.JComboBox;

public class CONSULTmain {
	JFrame jf;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private Vector<ConsultMiniVO> vec;
	private ConsultTableCellChkBox tc;
	private JComboBox comboBox;
	
	public CONSULTmain() {
		jf = new Frame(900, 500).getJFrame();
		vec = new ConsultingUtil().selectAConsMini();
		contentPane = new Panel().get();
	}
	
	public void run() {
		jf.setContentPane(contentPane);
		mainPanel();
		jf.setVisible(true);
	}
	
	void mainPanel() {
		title(); CPlanBtn();
		table(); comboBox();
		searchBtn(); editBtn(); insertBtn();
	}
	
	void title() {
		JLabel lblNewLabel = new Label("상담 관리",20).getTitle();
		lblNewLabel.setBounds(368, 16, 87, 27);
		contentPane.add(lblNewLabel);
	}
	
	void CPlanBtn() {
		JButton btnNewButton = new Button().getCPlanBtn();
		contentPane.add(btnNewButton);
	}
	
	void table() {
		try {
			table = new ConsultTBL().tableSet(vec);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		table = setChkTable(table);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(23, 127, 834, 208);
		contentPane.add(scrollPane);
	}
	
	void comboBox() {
		String[] header= {"전체","오늘","이번주","다음주"};
		comboBox = new ComboBox(header,12).get();
		comboBox.setBounds(23, 78, 95, 27);
		contentPane.add(comboBox);
	}
	
	void searchBtn() {
		JButton btnNewButton_1 = new Button("검색",12).getBtn();
		btnNewButton_1.setBounds(130, 78, 64, 27);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vec= new ConsultingUtil().search(comboBox);
					table = new ConsultTBL().tableSet(vec);
					table = setChkTable(table);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}		
				scrollPane.setViewportView(table);
			}
		});	
		contentPane.add(btnNewButton_1);
	}
	
	void editBtn() {
		JButton btnNewButton_2 = new Button("상담기록 및 상태변경",15).getBtn();
		btnNewButton_2.setBounds(105, 368, 181, 54);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new CONSULTedit(new ConsultingDAO().selectConsult(
							new ConsultingSQL().selectConsult(tc.getConsultDay(), tc.getConsultTime(), tc.getProfessorName()))).run();
			}
		});
		contentPane.add(btnNewButton_2);
	}
	
	void insertBtn() {
		JButton btnNewButton_3 = new Button("상담 신규등록",15).getBtn();
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new CONSULTinsert().run();
			}
		});
		btnNewButton_3.setBounds(510, 368, 187, 54);
		contentPane.add(btnNewButton_3);
		
	}

	public JTable setChkTable(JTable table) {	
		tc = new ConsultTableCellChkBox(table);
		table.getColumnModel().getColumn(0).setCellRenderer(tc);
		table.getColumnModel().getColumn(0).setCellEditor(tc);
		return table;
	}
}
