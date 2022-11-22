package login;

import java.sql.SQLException;

import admin.AdminDAOSQL;

public class LoginUtil {

	LoginVO login;
	
	public LoginUtil(LoginVO login) {
		this.login=login;
	}
	
	public int chk() throws SQLException {
		return new AdminDAOSQL().selectAdmin(login.getId(),login.getPwd());
	}
}
