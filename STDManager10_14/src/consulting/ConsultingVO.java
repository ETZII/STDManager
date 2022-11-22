package consulting;

import java.sql.Date;

public class ConsultingVO {
	private int consultId;
	private int studentId;
	private Date consultDay;
	private int consultTime;
	private int professorId;
	private String isConsult;
	private String cMemo;
	public int getConsultId() {
		return consultId;
	}
	public void setConsultId(int consultId) {
		this.consultId = consultId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Date getConsultDay() {
		return consultDay;
	}
	public void setConsultDay(Date consultDay) {
		this.consultDay = consultDay;
	}
	public int getConsultTime() {
		return consultTime;
	}
	public void setConsultTime(int consultTime) {
		this.consultTime = consultTime;
	}
	public int getProfessorId() {
		return professorId;
	}
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	public String getIsConsult() {
		return isConsult;
	}
	public void setIsConsult(String isConsult) {
		this.isConsult = isConsult;
	}
	public String getcMemo() {
		return cMemo;
	}
	public void setcMemo(String cMemo) {
		this.cMemo = cMemo;
	}
	
	
}
