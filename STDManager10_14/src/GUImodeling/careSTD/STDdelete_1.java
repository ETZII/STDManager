package GUImodeling.careSTD;

import GUImodeling.Result;
import GUImodeling.admin.AdminChk;
import GUImodeling.tool.Button;
import Student.StudentDB2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class STDdelete_1 extends AdminChk {
	String name;
	String phone;

	public STDdelete_1(String name,String phone) throws SQLException {
		this.name = name; this.phone=phone;
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
							new Result(new StudentDB2().deleteStudent(name,phone),"삭제");
					}else loginFail.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});	
		contentPane.add(loginBtn);
	}
	
}
