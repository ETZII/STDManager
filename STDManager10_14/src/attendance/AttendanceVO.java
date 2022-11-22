package attendance;

public class AttendanceVO {
	private int studentId;
	private String day;
	private int period;
	private int isAttend;
	private String reason;
	private double attP;
	
	private String name;//아이디로 이름 조회하는 메소드 불러서 생성시 name 넣기
	
	public AttendanceVO() {}
	public AttendanceVO(int stuId,String day,int period,int isAtt,String reason) {
		studentId=stuId; this.day=day; this.period=period; isAttend=isAtt; this.reason=reason;
	}
	public AttendanceVO(int stuId,String day,int period,int isAtt,String reason,String name) {
		studentId=stuId; this.day=day; this.period=period; isAttend=isAtt; this.reason=reason;
		this.name=name;
	}
	public AttendanceVO(String name,String day,int period,int isAtt,String reason) {
		this.name=name; this.day=day; this.period=period; isAttend=isAtt; this.reason=reason;
	}
	
	public int getStudendId() {
		return studentId;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getIsAttend() {
		return isAttend;
	}
	public void setIsAttend(int isAttend) {
		this.isAttend = isAttend;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAttP() {
		return attP;
	}
	public void setAttP(double attP) {
		this.attP = attP;
	}
}
