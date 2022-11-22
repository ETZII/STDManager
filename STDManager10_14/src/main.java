import java.sql.SQLException;

import GUImodeling.login.Loginpage;

public class main {

	public static void main(String[] args) {
		/*
		 * 최초 실행시  아이디  admin 비밀번호 1234
		 */
		try {
			new Loginpage().run();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
