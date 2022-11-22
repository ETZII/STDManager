package admin;

public class AdminVO {

	private String adminId;
	private String adminPwd;
	
	public AdminVO(){}
	public AdminVO(String id,String pwd){
		adminId=id; adminId=pwd;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
}
