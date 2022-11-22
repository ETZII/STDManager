package consulting;

public class ProfessorVO {
	
	private int pId;
	private String pName;
	private String pPhone;	

	public ProfessorVO(){
		
	}
	public ProfessorVO(int id,String name,String phone){
		pId=id; pName=name; pPhone=phone;
	}
	public int getpId() {
		return pId;
	}
	public String getpName() {
		return pName;
	}
	public String getpPhone() {
		return pPhone;
	}
	
	
}
