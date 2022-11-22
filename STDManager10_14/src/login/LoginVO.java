package login;

import admin.AdminUtil;

public class LoginVO {
	private String id;
	private String pwd;
	
	public LoginVO(String id,String pwd) {
		this.id=id; this.pwd = AdminUtil.pwdEncrypt(pwd);
	}

	public String getId() {
		return id;
	}

	public String getPwd() {
		return pwd;
	}
	
}
