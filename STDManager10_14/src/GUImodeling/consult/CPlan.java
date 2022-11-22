package GUImodeling.consult;


import javax.swing.JFrame;
import javax.swing.JPanel;

import GUImodeling.consult.tool.ConsultTBL;
import GUImodeling.tool.Button;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;
import GUImodeling.tool.TableCell;
import consulting.ConsultingUtil;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class CPlan  {
	JFrame jf;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	String []TBLheader;
	Object [][]contents;
	
	public CPlan() {
		jf = new Frame(700, 680).getJFrame();		
		contentPane = new Panel().get();
	}
	
	public void run() {
		jf.setContentPane(contentPane);
		mainPanel();
		jf.setVisible(true);
	}

	void mainPanel() {
		 reset();
		 title();
		 table();
		 refreshBtn();
	}
	
	void title() {
		JLabel lblNewLabel = new Label("다음주 상담일정",20).getTitle();
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblNewLabel.setBounds(248, 10, 150, 38);
		contentPane.add(lblNewLabel);
	}
	
	void reset() {
		TBLheader = header();
			contents =new ConsultTBL().CPlanContents(new ConsultingUtil().selectCPlan());
	}
	
	void table() {
		table = new JTable(contents,TBLheader);
		table = new ConsultTBL().CPlanBasicSet(table);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 60, 660, 563);
		scrollPane.setViewportView(new TableCell(table).tableCellCenter());
		contentPane.add(scrollPane);
	}
	
	void refreshBtn() {
		JButton refreshBtn = new Button("새로고침",14).getBtn();
		refreshBtn.setBounds(549, 10, 123, 36);
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					contents =new ConsultTBL().CPlanContents(new ConsultingUtil().selectCPlan());
					table = new JTable(contents,TBLheader);
					table = new ConsultTBL().CPlanBasicSet(table);
				scrollPane.setViewportView(new TableCell(table).tableCellCenter());
			}
		});
		contentPane.add(refreshBtn);
	}
	
	public String[] header() {
		String [] TBLheader = {"상담시작","월","화","수","목","금"};
		return TBLheader;
	}

}
