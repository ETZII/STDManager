package GUImodeling.careSTD;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import GUImodeling.tool.Button;
import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class STDdelete_0  implements ActionListener{
	JFrame jf;
	private JPanel contentPane,NamePanel,PhonePanel,ynChoicePanel;
	private JTextField NameField;
	private JTextField PhoneField;
	private String name,phone,answer;

	public STDdelete_0() {
		jf = new Frame(450, 300).getJFrame();
		contentPane = new Panel().get();
	}
	public void run() {
		jf.setContentPane(contentPane);
		mainPanel();
		jf.setVisible(true);
	}
	public void mainPanel() {
		title();
		namePanel(); phonePanel();
		ynChoicePanel();deleteBtn();
	}
	public void title() {
		JLabel lblNewLabel = new Label("학생정보삭제",20).getTitle();
		lblNewLabel.setBounds(103, 10, 216, 37);
		contentPane.add(lblNewLabel);
	}
	
	public void namePanel() {
		NamePanel = new Panel().get();
		NamePanel.setBounds(90, 67, 244, 37);
		contentPane.add(NamePanel);
		name();	
	}
	
	public void name() {
		NameField = new JTextField();
		NameField.setBounds(96, 0, 148, 37);
		NameField.setColumns(10);
		NamePanel.add(NameField);
		
		JLabel NameLabel = new Label("학생이름",16).getTitle();
		NameLabel.setBounds(0, 0, 98, 37);
		NamePanel.add(NameLabel);
	}
	
	public void phonePanel() {
		PhonePanel = new Panel().get();
		PhonePanel.setBounds(90, 114, 244, 37);
		contentPane.add(PhonePanel);
		phone();
	}
	public void phone() {
		PhoneField = new JTextField();
		PhoneField.setColumns(10);
		PhoneField.setBounds(96, 0, 148, 37);
		PhonePanel.add(PhoneField);
		
		JLabel PhoneLabel = new Label("전화번호",16).getTitle();
		PhoneLabel.setBounds(0, 0, 98, 37);
		PhonePanel.add(PhoneLabel);
	}
	
	public void ynChoicePanel() {
		ynChoicePanel = new Panel().get();
		ynChoicePanel.setBounds(12, 165, 390, 37);
		contentPane.add(ynChoicePanel);
		ynChoice();
	}
	public void ynChoice() {
		JLabel ynChoice = new Label("정말 삭제하시겠습니까?",12).getPlain();
		ynChoice.setBounds(54, 10, 171, 15);
		ynChoicePanel.add(ynChoice);
		
		JRadioButton yButton = new JRadioButton("Y");
		yButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		yButton.setBounds(221, 6, 41, 23);
		ynChoicePanel.add(yButton);
		
		JRadioButton nButton = new JRadioButton("N");
		nButton.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		nButton.setBounds(266, 6, 41, 23);
		ynChoicePanel.add(nButton);

		ButtonGroup group = new ButtonGroup();
		group.add(yButton);
		group.add(nButton);		
		yButton.addActionListener(this);
		nButton.addActionListener(this);
	}
	
	public void deleteBtn() {
		JButton btnNewButton = new Button("삭제하기",17).getBtn();
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		btnNewButton.setBounds(148, 205, 132, 39);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer.equals("Y")) {
					read();
					try {
						new STDdelete_1(name,phone).run();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});	
		contentPane.add(btnNewButton);
	}

	public void read() {
		name = NameField.getText();
		phone = PhoneField.getText();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		answer = e.getActionCommand();
	}
}
