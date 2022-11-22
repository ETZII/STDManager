package GUImodeling.login;


import GUImodeling.admin.AdminChk;
import GUImodeling.main.TodayTask;
import GUImodeling.tool.Button;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Loginpage extends AdminChk{

	public Loginpage() throws SQLException {
		
	}
	public void run() throws SQLException {
		super.run();
		super.title.setText("학생관리시스템");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginBtn();
		jf.setVisible(true);
	}

	void loginBtn() { 
		loginBtn = new Button("로그인",15).getBtn();
		loginBtn.setBounds(138, 194, 160, 38);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(login()==1) {
						jf.dispose();
						new TodayTask().run();
					}else loginFail.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});	
		contentPane.add(loginBtn);
	}
}
