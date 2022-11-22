package GUImodeling.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import GUImodeling.tool.Button;


public class CreateAdminChk extends AdminChk {

	public CreateAdminChk() {
	}

	public void run() throws SQLException {
		super.run();
		super.title.setText("관리자 확인");
		loginBtn();
		jf.setVisible(true);
	}
	
	void loginBtn() { 
		loginBtn = new Button("확인",15).getBtn();
		loginBtn.setBounds(138, 194, 160, 38);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(login()==1) {
						jf.dispose();
						new AdminMain().run();
					}else loginFail.setVisible(true);
				} catch (SQLException e1) {
				}
			}
		});	
		contentPane.add(loginBtn);
	}
}
