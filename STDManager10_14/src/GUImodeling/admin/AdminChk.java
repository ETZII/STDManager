package GUImodeling.admin;

import javax.swing.JFrame;
import javax.swing.JPanel;

import login.LoginVO;
import login.LoginUtil;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import GUImodeling.tool.Frame;
import GUImodeling.tool.Label;
import GUImodeling.tool.Panel;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;

public class AdminChk {
	protected JFrame jf;
	protected JLabel title;
	protected JPanel contentPane;
	protected JTextField textField;
	protected JButton loginBtn;
	protected JPasswordField passwordField;
	protected String id;
	protected String pwd;
	protected JLabel loginFail;
	
	public AdminChk() {
		jf = new Frame(440, 300).getJFrame();
	}

	public void run() throws SQLException {
		mainPanel();
		title();
		id();
		password();	
		loginFail();
	}
	
	public void mainPanel() {
		contentPane = new Panel().get();
		jf.setContentPane(contentPane);	
	}
	
	public void title() {
		title = new Label("",19).getTitle();
		title.setBounds(126, 20, 172, 44);
		contentPane.add(title);
	}
	
	public void id() {
		JLabel lblNewLabel_2 = new JLabel("아이디");
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(119, 93, 71, 31);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(189, 93, 126, 32);
		textField.setColumns(15);
		contentPane.add(textField);
	}
	public void password() {
		JLabel lblNewLabel_2_1 = new JLabel("비밀번호");
		lblNewLabel_2_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(119, 141, 71, 31);
		contentPane.add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(189, 141, 126, 31);
		textField.setColumns(20);
		contentPane.add(passwordField);
	}
	
	//로그인실패
	public void loginFail() {
		loginFail = new Label("아이디 또는 비밀번호가 맞지않습니다.",11).getPlain();
		loginFail.setForeground(new Color(255, 0, 0));
		loginFail.setBounds(110, 179, 240, 15);
		contentPane.add(loginFail).setVisible(false);
	}
	
	public int login() throws SQLException {
		read();
		return new LoginUtil(new LoginVO(id,pwd)).chk();
	}
	
	@SuppressWarnings("deprecation")
	public void read() {
		id = textField.getText();
		pwd = passwordField.getText();
	}
}
