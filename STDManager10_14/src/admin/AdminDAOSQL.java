package admin;

import java.sql.SQLException;

import db.STDManager;

public class AdminDAOSQL {
	STDManager stdM;
	
	public AdminDAOSQL() throws SQLException {
		stdM = STDManager.getInstance();
	}
	
	public int insertAdmin(String id,String pwd) {
		pwd = AdminUtil.pwdEncrypt(pwd);
		return stdM.run("INSERT INTO AdminTBL VALUES('"+id+"','"+pwd+"')");
	}
	
	public int selectAdmin(String id,String pwd) {
		return stdM.selectChkExists("SELECT * FROM AdminTBL WHERE adminId = '"+id+"' and adminPwd= '"+pwd+"'");
	}
	
	public int selectAdmin(String id) {
		return stdM.selectChkExists("SELECT * FROM AdminTBL WHERE adminId = '"+id+"'");
	}
	
	public int deleteAdmin(String id,String pwd) {
		pwd = AdminUtil.pwdEncrypt(pwd);
		return stdM.run("DELETE from AdminTBL where adminId = '"+id+"' and adminPwd = '"+pwd+"'");
	}
}