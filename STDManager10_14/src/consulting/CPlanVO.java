package consulting;

public class CPlanVO {
	private String professorName;
	private String consultDay;
	private int consultTime;
	private String name;
	
	public CPlanVO() {}
	public CPlanVO(String pName,String cDay,int cTime,String name) {
		professorName=pName; consultDay=cDay; consultTime=cTime; this.name=name;
	}
	
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getConsultDay() {
		return consultDay;
	}
	public void setConsultDay(String consultDay) {
		this.consultDay = consultDay;
	}
	public int getConsultTime() {
		return consultTime;
	}
	public void setConsultTime(int consultTime) {
		this.consultTime = consultTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
