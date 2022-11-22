package GUImodeling.payment;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import Payment.PaymentDAO2;
import Payment.PaymentDAOO;
import Payment.PaymentSQL;
import Payment.PaymentVO2;
import Student.StudentDAO;
//import PaymentGui.STDsearchPay.TableCell;
import Student.StudentDB2;
import Student.StudentSQL;
import Student.StudentUtil;
import Student.StudentVO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class PayGuipayday extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private TableCell tc;
	private JScrollPane scrollPane;
	private JPanel panel,panel_1;
	private String filter,value;
	private JComboBox comboBox;
	private JTextField textField;
	private Vector <StudentVO> vec;
	private PaymentVO2 pvo = new PaymentVO2();
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PayGuipayday frame = new PayGuipayday().run();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 * @throws SQLException 
//	 */
	
	
	public PayGuipayday() throws SQLException {
		vec = new StudentDB2().selectStudent();
//		run();
//		tableSet(vec);
		
	}
	
	public void run() throws SQLException {
		mainPanel();
		setVisible(true);
	}
	public void mainPanel() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 779, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		title(); btn(); tablePanel(); filterPanel();
	}
	public void title() {
		JLabel lblNewLabel = new JLabel("결제 등록");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lblNewLabel.setBounds(334, 37, 127, 33);
		contentPane.add(lblNewLabel);
		
	}
	public void filterPanel() {
		panel_1 = new JPanel();
		panel_1.setBounds(0, 81, 431, 61);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		filter();search();
	}
	public void search() {
		textField = new JTextField();
		textField.setBounds(156, 11, 141, 40);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("검색");
		btnNewButton_1.setBounds(309, 10, 95, 41);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				t2.run();
				read();
				try {
					setVisible(true);
					tableSet(filterChk());
//					new Payokeypop();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//					new PaychkGui();
			}
		});	
		

	}
	public void filter() {
		filterComboBox();
	}
	public void filterComboBox() {
		String []header = {"전체","이름","나이","성별","전화번호","주소","메모","이용종료일","패널티","관리시작일","관리종료일"};
		comboBox = new JComboBox(header);
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		panel_1.add(comboBox);
		comboBox.setBounds(10, 10, 127, 41);
		//contentPane.add(comboBox);
		
		
	}
	
	public void btn() {
		JButton btnNewButton = new JButton("결제 등록하기");
		btnNewButton.setBounds(587, 102, 152, 40);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				read();
				setVisible(true);
				t2.run();
				new Payokeypop();
			}
		});	
		
	}
	
	Thread t2 = new Thread(new Runnable() {
		@Override
		public void run() {
			int id = tc.getId();
			new StudentDAO().run(new StudentSQL().setRestday(id));
			new PaymentDAOO().run(new PaymentSQL().insertPayday(id));
		}
	});
	
	public void tablePanel() throws SQLException {
		panel = new JPanel();
		panel.setBounds(10, 152, 741, 300);
		contentPane.add(panel);
		panel.setLayout(null);
		table();
	}
	public void table() throws SQLException {
		scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setOpaque(false);
		scrollPane.setRequestFocusEnabled(false);
		scrollPane.setVerifyInputWhenFocusTarget(false);
		scrollPane.setBounds(0, 0, 741, 300);
		panel.add(scrollPane);
		tableSet(vec);
	}
		
	public void tableSet(Vector<StudentVO> vec) throws SQLException {
		tc = new TableCell();
		String []TBLheader = {"선택","이름","나이","성별","전화번호","주소","메모","이용종료일","패널티","관리시작일","관리종료일"};
		Object [][]contents= contents(vec);
		panel.setLayout(null);
		table = new JTable(contents,TBLheader);
		table.getColumnModel().getColumn(0).setCellRenderer(tc);
		table.getColumnModel().getColumn(0).setCellEditor(tc);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));	
		tableColumnSize();
		table.setPreferredScrollableViewportSize(new Dimension(0,0));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		table.setRowHeight(25);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
	}	
		
	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
		JRadioButton jc;
		int id;
		public TableCell() {
			jc = new JRadioButton();
			jc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rows = "";
						Object val = table.getValueAt(table.getSelectedRow(), 0);
						rows = rows + " " + val;
						id =(int) val;
				}
			});

			}
		

		public int getId() {
			return id;
		}
		@Override
		public Object getCellEditorValue() {
			return null;
		}
		@Override
		public Component getTableCellRendererComponent(JTable table_1, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			return jc;
		}
		@Override
		public Component getTableCellEditorComponent(JTable table_1, Object value, boolean isSelected, int row,
				int column) {
			return jc;
		}
	}
	public void tableColumnSize() {
		table.getColumn("선택").setPreferredWidth(30);
		table.getColumn("이름").setPreferredWidth(60);
		table.getColumn("나이").setPreferredWidth(40);
		table.getColumn("성별").setPreferredWidth(40);
		table.getColumn("전화번호").setPreferredWidth(100);
		table.getColumn("주소").setPreferredWidth(180);
		table.getColumn("메모").setPreferredWidth(250);
		table.getColumn("이용종료일").setPreferredWidth(90);
		table.getColumn("패널티").setPreferredWidth(50);
		table.getColumn("관리시작일").setPreferredWidth(90);
		table.getColumn("관리종료일").setPreferredWidth(90);
	}
	public Object[][] contents(Vector<StudentVO> vec) throws SQLException{
		int i = 0, j = 0;
		String phone =null;
		Object[][] oj = new Object[new StudentDB2().cntStd()][11]; //출결관리중인학생수,행개수 10개
		for(StudentVO vo:vec) {
			phone=vo.getPhone();
			oj[i][j]=vo.getStudentId(); oj[i][j+1]=vo.getName(); oj[i][j+2]=vo.getAge(); oj[i][j+3]=vo.getSex(); 
			oj[i][j+4]=phone.substring(0,3)+"-"+phone.substring(3,7)+"-"+phone.substring(7);
			oj[i][j+5]=vo.getAddr(); oj[i][j+6]=vo.getMemo(); oj[i][j+7]=vo.getRestday();oj[i][j+8]=vo.getPenalty();
			oj[i][j+9]=vo.getStartCareDay();  oj[i][j+10]=vo.getEndCareDay();
			i++;
		}
		return oj;
	}
	
	public void read() {
		filter=comboBox.getSelectedItem().toString();
		value=textField.getText();
	}
	
	public Vector<StudentVO> filterChk() {
		Vector<StudentVO> vec = new Vector<>();
		if(filter.equals("전체")) vec = new StudentDB2().selectStudent();
		else if(!(filter.equals("이용종료일")||filter.equals("관리시작일")||filter.equals("관리종료일"))) {
			if(filter.equals("이름")) filter="name";
			else if(filter.equals("나이")) filter="age";
			else if(filter.equals("성별")) filter="sex";
			else if(filter.equals("전화번호")) filter="phone";
			else if(filter.equals("주소")) filter="addr";
			else if(filter.equals("메모")) filter="memo";
			else if(filter.equals("패널티")) filter="penalty";
			vec = new StudentDB2().filterSelect(filter, value);
		}else {
			if(filter.equals("이용종료일")) filter="restday";
			else if(filter.equals("관리시작일")) filter="startCareDay";
			else if(filter.equals("관리종료일")) filter="endCareDay";
			vec = new StudentDB2().datefilterSelect(filter, value);
		}
		return vec;
	}
}
