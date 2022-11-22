package consulting;

public class ConsultMiniVO {

	private String consultDay;
	private String consultTime;
	private String professorName;
	private String name;
	private String isConsult;
	private String CMemo;
	
	public ConsultMiniVO() {}
	public ConsultMiniVO(String cday,String ctime,String pfName,String name,String isC,String CMemo) {
		consultDay=cday; consultTime=ctime; professorName=pfName; this.name=name;
		isConsult=isC; this.CMemo=CMemo;
	}
	
	public String getConsultDay() {
		return consultDay;
	}
	public String getConsultTime() {
		return consultTime;
	}
	public String getProfessorName() {
		return professorName;
	}
	public String getName() {
		return name;
	}
	public String getIsConsult() {
		return isConsult;
	}
	public String getCMemo() {
		return CMemo;
	}
	

}
