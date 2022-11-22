package GUImodeling.admin;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import GUImodeling.Result;
import GUImodeling.tool.Button;
import admin.AdminDAOSQL;

public class DeleteAdmin extends AdminChk {

	public DeleteAdmin() {	}
	
	public void run() throws SQLException {
		super.run();
		super.title.setText("삭제하실 아이디와 비밀번호를 입력하세요");
		title.setFont(new Font("맑은 고딕", Font.BOLD, 13));	
		title.setBounds(90, 20, 250, 44);
		loginBtn();
		jf.setVisible(true);
	}
	
	void loginBtn() { 
		loginBtn = new Button("등록하기",15).getBtn();
		loginBtn.setBounds(138, 194, 160, 38);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(login()!=1) {
						loginFail.setVisible(true);
					}else {
						new Result(new AdminDAOSQL().deleteAdmin(id, pwd),"삭제");
						jf.dispose();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});	
		contentPane.add(loginBtn);
	}
}
