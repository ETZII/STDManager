package GUImodeling.consult;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUImodeling.Result;
import GUImodeling.consult.tool.ConsultTBL;
import GUImodeling.tool.Button;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;
import consulting.ConsultMiniVO;
import consulting.ConsultingDAO;
import consulting.ConsultingSQL;
import consulting.ConsultingUtil;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class CONSULTedit implements ActionListener {
	JFrame jf;
	private Vector<ConsultMiniVO> vec;
	private JPanel contentPane;
	private JTable table;
	private	JTextPane textPane;
	private String isC;

	public CONSULTedit(Vector<ConsultMiniVO> vec) {
		this.vec=vec;
		jf = new Frame(700, 450).getJFrame();
		contentPane = new Panel().get();	
	}
	
	public void run() {
		jf.setContentPane(contentPane);
		mainPanel();
		jf.setVisible(true);
	}
	
	public void mainPanel() {
		title(); table();
		label(); textPanel(); 
		insertBtn(); radioBtn();
	}

	void title() {
		JLabel lblNewLabel = new Label("상담기록",14).getTitle();
		lblNewLabel.setBounds(304, 10, 113, 30);
		contentPane.add(lblNewLabel);
	}
	
	void table() {
		table = new ConsultTBL().tableSet2(vec);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 61, 660, 70);
		contentPane.add(scrollPane);
	}
	
	void textPanel() {
		textPane = new JTextPane();
		textPane.setBounds(12, 213, 491, 169);
		contentPane.add(textPane);
	}
	void label() {
		JLabel lblNewLabel_1 = new Label("상담메모",14).getTitle();
		lblNewLabel_1.setBounds(26, 178, 107, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new Label("상담여부",14).getTitle();
		lblNewLabel_2.setBounds(551, 178, 107, 25);
		contentPane.add(lblNewLabel_2);
	}
	
	void insertBtn() {
		JButton btnNewButton = new Button("등록하기",16).getBtn();
		btnNewButton.setBounds(543, 329, 129, 53);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new Result(update(),"등록");
					jf.dispose();
			}
		});
		contentPane.add(btnNewButton);
	}
	
	void radioBtn() {
		JRadioButton rdBtn1 = new JRadioButton("상담완료");
		rdBtn1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		rdBtn1.setBounds(543, 213, 121, 23);
		contentPane.add(rdBtn1);
		
		JRadioButton rdBtn2 = new JRadioButton("학생취소");
		rdBtn2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		rdBtn2.setBounds(543, 238, 121, 23);
		contentPane.add(rdBtn2);
		
		JRadioButton rdBtn3 = new JRadioButton("교수취소");
		rdBtn3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		rdBtn3.setBounds(543, 263, 121, 23);
		contentPane.add(rdBtn3);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdBtn1); rdBtn1.addActionListener(this);
		group.add(rdBtn2); rdBtn2.addActionListener(this);
		group.add(rdBtn3); rdBtn3.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		isC =  e.getActionCommand();
	}
	
	public int update(){
		return new ConsultingDAO().run(new ConsultingSQL().update(isC,textPane.getText(),vec.get(0).getConsultDay(),vec.get(0).getConsultTime(),new ConsultingUtil().selectPf(vec.get(0).getProfessorName()).get(0).getpId()));
	}
}
