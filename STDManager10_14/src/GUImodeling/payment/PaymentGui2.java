package GUImodeling.payment;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import Payment.PaymentDAO2;
import Payment.PaymentUtil;
import Payment.PaymentVO2;
import Payment.PaymentVO3;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PaymentGui2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel filterPanel,tablePanel;
	private JScrollPane scrollPane,scrollPane2;
	private JComboBox comboBox;
	private JTextField textField;
	private String filter,value;
	private Vector<PaymentVO2> vec;
	private Vector<PaymentVO3> vecc;
	private DefaultTableCellRenderer celAlignCenter;
	private JLabel lblNewLabel_4;
	private JTable table_1;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_5;
	private JTextField textField_1;
	private TableCell tc;

	
	public PaymentGui2() throws SQLException {
		vec = new PaymentDAO2().selectAllPayment();//환불 전체
		vecc = new PaymentDAO2().selectAllPaymentSTD2();//전체 
		tc = new TableCell();
	}
	
	public void run() throws SQLException {
		mainPanel();
		setVisible(true);
		
	}
	
	public void mainPanel() throws SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 756, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		title(); 
		filterPanel(); tablePanel(); tablePanel2();
		tablePanel3();
	}
	public void title() {
		JLabel lblNewLabel = new JLabel("결제 관리");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
		lblNewLabel.setBounds(311, 13, 143, 65);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
	}
	
	public void tablePanel3 () throws SQLException{
		panel_1 = new JPanel();
		panel_1.setBounds(46, 383, 646, 99);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_5 = new JLabel("환불금액");
		lblNewLabel_5.setBounds(216, 21, 52, 15);
		panel_1.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(266, 18, 106, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("환불하기");
		btnNewButton.setBounds(443, 21, 89, 47);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.run();
				new PaymentIsfCh();
				dispose();
				try {
					new PaymentGui2();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	Thread t = new Thread(new Runnable() {
		
		@Override
		public void run() {
			int id = tc.getId();
			int num = Integer.parseInt(textField_1.getText()); 
			String payday = tc.getStrday();
			System.out.println(new PaymentDAO2().updatepayDay(payday,id, num));
		}
	});
		
	public void filterPanel() {
		filterPanel = new JPanel();
		filterPanel.setBounds(46, 92, 646, 26);
		contentPane.add(filterPanel);
		filterPanel.setLayout(null);
		searchBtn();
		searchWord();
		filterComboBox();
	}
	public void filterComboBox() {
		String []header = {"전체","학생이름","나이","전화번호","결제완료일","이용종료일","관리시작일","관리종료일"};
		comboBox = new JComboBox(header);
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		comboBox.setBounds(43, 2, 119, 23);
		filterPanel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("필터");
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(12, 8, 32, 15);
		filterPanel.add(lblNewLabel_1);
	}

	public void searchBtn() {
		JButton searchBtn = new JButton("조회하기");
		searchBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		searchBtn.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		searchBtn.setBounds(536, 2, 97, 23);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				read();
				try {
					tableSet2(filterChkAll());
					setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});	
		filterPanel.add(searchBtn);
	}
	
	public void searchWord() {
		JLabel lblNewLabel_2 = new JLabel("검색어");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(323, 6, 45, 15);
		filterPanel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(380, 4, 154, 21);
		filterPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("*날짜는 yy/mm/dd 형식으로");
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(421, 67, 166, 15);
		contentPane.add(lblNewLabel_3);
	}
	
	public void tablePanel() throws SQLException {
		tablePanel = new JPanel();
		tablePanel.setBounds(54, 492, 638, 149);
		contentPane.add(tablePanel);
		tablePanel.setLayout(null);
		table();
		
	}
	
	public void tablePanel2 () throws SQLException{
		panel = new JPanel();
		panel.setBounds(46, 128, 646, 245);
		contentPane.add(panel);
		panel.setLayout(null);
		table2();
	}
	
	
	public void table() throws SQLException {
		celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		scrollPane = new JScrollPane();
		String []TBLheader = {"학생이름","나이","전화번호","결제완료일","환불여부","환불금액","환불날짜"};
		Object [][]contents= contents(vec);
		scrollPane.setAutoscrolls(true);
		scrollPane.setOpaque(false);
		scrollPane.setRequestFocusEnabled(false);
		scrollPane.setVerifyInputWhenFocusTarget(false);
		scrollPane.setBounds(36, 41, 563, 105);
		tablePanel.add(scrollPane);
		table = new JTable(contents,TBLheader);
		scrollPane.setViewportView(table);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		table.setPreferredScrollableViewportSize(new Dimension(0,0));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setRowHeight(25);
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tableSet(vec);
		tableColumnSize();
		
	}
	
	public void tableSet(Vector<PaymentVO2> vec) throws SQLException {
		String []TBLheader = {"학생이름","나이","전화번호","결제완료일","환불여부","환불금액","환불날짜"};
		Object [][]contents= contents(vec);
		tc = new TableCell();
		tablePanel.setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 150, 598, -144);
		scrollPane.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		scrollPane.setBackground(new Color(255, 172, 172));
		tablePanel.add(scrollPane);
		{
			lblNewLabel_4 = new JLabel("환불 완료된 학생들");
			lblNewLabel_4.setBounds(36, 16, 127, 15);
			tablePanel.add(lblNewLabel_4);
			lblNewLabel_4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		}
		
	}
	
	public void table2() throws SQLException {
		scrollPane2 = new JScrollPane();
		scrollPane2.setAutoscrolls(true);
		scrollPane2.setOpaque(false);
		scrollPane2.setRequestFocusEnabled(false);
		scrollPane2.setVerifyInputWhenFocusTarget(false);
		scrollPane2.setBounds(36, 41, 563, 197);
		panel.add(scrollPane2);
		tableSet2(vecc);
	}
	class TableCell extends AbstractCellEditor implements TableCellEditor, TableCellRenderer{
		JRadioButton jc;
		
		int id;
		String strday;
		public TableCell() {
			jc = new JRadioButton();
			jc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					id = Integer.parseInt(table_1.getValueAt(table_1.getSelectedRow(), 0).toString());
					strday = table_1.getValueAt(table_1.getSelectedRow(), 4).toString();
				}
			});

			}
		
		public int getId() {
			return id;
		}
		
		public String getStrday() {
			return strday;
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
	public void tableSet2(Vector<PaymentVO3> vecc) throws SQLException {
		String []TBLheader = {"선택","학생이름","나이","전화번호","결제완료일","이용종료일","관리시작일","관리종료일"};
		Object [][]contents= Allcontents(vecc);
		panel.setLayout(null);
		table_1 = new JTable(contents,TBLheader);
		table_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tc = new TableCell();
		table_1.getColumnModel().getColumn(0).setCellRenderer(tc);
		table_1.getColumnModel().getColumn(0).setCellEditor(tc);
		table_1.setPreferredScrollableViewportSize(new Dimension(0,0));
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_1.setRowHeight(25);
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane2.setViewportView(table_1);
		scrollPane1.setBounds(36, 238, 563, -172);
		scrollPane1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		scrollPane1.setBackground(new Color(255, 172, 172));
		tableColumnSize2();
		panel.add(scrollPane1);
		
	}
	
	public void tableColumnSize() {
		table.getColumn("학생이름").setPreferredWidth(60);
		table.getColumn("나이").setPreferredWidth(40);
		table.getColumn("전화번호").setPreferredWidth(100);
		table.getColumn("결제완료일").setPreferredWidth(100);
		table.getColumn("환불여부").setPreferredWidth(60);
		table.getColumn("환불금액").setPreferredWidth(100);
		table.getColumn("환불날짜").setPreferredWidth(100);
	}
	public void tableColumnSize2() {
		table_1.getColumn("선택").setPreferredWidth(30);
		table_1.getColumn("학생이름").setPreferredWidth(60);
		table_1.getColumn("나이").setPreferredWidth(40);
		table_1.getColumn("전화번호").setPreferredWidth(100);
		table_1.getColumn("결제완료일").setPreferredWidth(120);
		table_1.getColumn("이용종료일").setPreferredWidth(120);
		table_1.getColumn("관리시작일").setPreferredWidth(120);
		table_1.getColumn("관리종료일").setPreferredWidth(120);
	}
	
	public Object[][] contents(Vector<PaymentVO2> vec) throws SQLException{
		int i = 0, j = 0;
		String phone =null;
		PaymentUtil util ;
		util = new PaymentUtil();
		Object[][] oj = new Object[new PaymentDAO2().cntStd1()][7]; 
		if (vec!=null) {
			for(PaymentVO2 vo:vec) {
				phone=vo.getPhone();
				oj[i][j]=vo.getName(); oj[i][j+1]=vo.getAge();oj[i][j+2]=phone.substring(0,3)+"-"+phone.substring(3,7)+"-"+phone.substring(7);
				oj[i][j+3]=vo.getPayDay();
				oj[i][j+4]=util.isrefund(vo.getIsRefund());
				oj[i][j+5]=vo.getRefundAmount();oj[i][j+6]=vo.getRefundDay();
				i++;
			}
		}
		return oj;
	}
	////조회
	public Object[][] Allcontents(Vector<PaymentVO3> vec) throws SQLException{
		int i = 0, j = 0;
		String phone =null;
		Object[][] oj = new Object[new PaymentDAO2().cntStd2()][8]; 
		for(PaymentVO3 vo:vec) {
			phone=vo.getPhone();
			oj[i][j]=vo.getStudentId(); oj[i][j+1]=vo.getName(); oj[i][j+2]=vo.getAge();oj[i][j+3]=phone.substring(0,3)+"-"+phone.substring(3,7)+"-"+phone.substring(7);
			oj[i][j+4]=vo.getPayDay(); oj[i][j+5]=vo.getRestday(); oj[i][j+6]=vo.getStartcareday(); oj[i][j+7]=vo.getEndcareday();
			i++;
		}
		return oj;
	}
	
	public void read() {
		filter=comboBox.getSelectedItem().toString();
		value=textField.getText();
	}
	
	
	///조회 테ㅣ블
	public Vector<PaymentVO3> filterChkAll() {
		Vector<PaymentVO3> vec = new Vector<>();
		if(filter.equals("전체")) vec = new PaymentDAO2().selectAllPaymentSTD2();
		else if(!(filter.equals("결제완료일")||filter.equals("이용종료일")||filter.equals("관리시작일")||filter.equals("관리종료일"))) {
			if(filter.equals("학생이름")) filter="name";
			else if(filter.equals("나이")) filter="age";
			else if(filter.equals("전화번호")) filter="phone";
			vec = new PaymentDAO2().allfilterNameSelectPay(filter, value);
		}else {
			if(filter.equals("결제완료일")) filter="payday";
			else if(filter.equals("이용종료일")) filter="restday";
			else if(filter.equals("관리시작일")) filter="startcareday";
			else if(filter.equals("관리종료일")) filter="endcareday";
			vec = new PaymentDAO2().allfilterSelectday(filter, value);
		} 
		return vec;
	}
}
