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
		JLabel lblNewLabel = new JLabel("?????? ??????");
		lblNewLabel.setFont(new Font("?????? ??????", Font.PLAIN, 20));
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
		
		JButton btnNewButton_1 = new JButton("??????");
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
		String []header = {"??????","??????","??????","??????","????????????","??????","??????","???????????????","?????????","???????????????","???????????????"};
		comboBox = new JComboBox(header);
		comboBox.setFont(new Font("?????? ??????", Font.PLAIN, 12));
		panel_1.add(comboBox);
		comboBox.setBounds(10, 10, 127, 41);
		//contentPane.add(comboBox);
		
		
	}
	
	public void btn() {
		JButton btnNewButton = new JButton("?????? ????????????");
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
		String []TBLheader = {"??????","??????","??????","??????","????????????","??????","??????","???????????????","?????????","???????????????","???????????????"};
		Object [][]contents= contents(vec);
		panel.setLayout(null);
		table = new JTable(contents,TBLheader);
		table.getColumnModel().getColumn(0).setCellRenderer(tc);
		table.getColumnModel().getColumn(0).setCellEditor(tc);
		table.setFont(new Font("?????? ??????", Font.PLAIN, 12));	
		tableColumnSize();
		table.setPreferredScrollableViewportSize(new Dimension(0,0));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(table);
		table.setRowHeight(25);
		table.setFont(new Font("?????? ??????", Font.PLAIN, 12));
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
		table.getColumn("??????").setPreferredWidth(30);
		table.getColumn("??????").setPreferredWidth(60);
		table.getColumn("??????").setPreferredWidth(40);
		table.getColumn("??????").setPreferredWidth(40);
		table.getColumn("????????????").setPreferredWidth(100);
		table.getColumn("??????").setPreferredWidth(180);
		table.getColumn("??????").setPreferredWidth(250);
		table.getColumn("???????????????").setPreferredWidth(90);
		table.getColumn("?????????").setPreferredWidth(50);
		table.getColumn("???????????????").setPreferredWidth(90);
		table.getColumn("???????????????").setPreferredWidth(90);
	}
	public Object[][] contents(Vector<StudentVO> vec) throws SQLException{
		int i = 0, j = 0;
		String phone =null;
		Object[][] oj = new Object[new StudentDB2().cntStd()][11]; //???????????????????????????,????????? 10???
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
		if(filter.equals("??????")) vec = new StudentDB2().selectStudent();
		else if(!(filter.equals("???????????????")||filter.equals("???????????????")||filter.equals("???????????????"))) {
			if(filter.equals("??????")) filter="name";
			else if(filter.equals("??????")) filter="age";
			else if(filter.equals("??????")) filter="sex";
			else if(filter.equals("????????????")) filter="phone";
			else if(filter.equals("??????")) filter="addr";
			else if(filter.equals("??????")) filter="memo";
			else if(filter.equals("?????????")) filter="penalty";
			vec = new StudentDB2().filterSelect(filter, value);
		}else {
			if(filter.equals("???????????????")) filter="restday";
			else if(filter.equals("???????????????")) filter="startCareDay";
			else if(filter.equals("???????????????")) filter="endCareDay";
			vec = new StudentDB2().datefilterSelect(filter, value);
		}
		return vec;
	}
}
