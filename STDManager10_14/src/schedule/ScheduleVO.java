package schedule;

public class ScheduleVO {
	private int studentId;
	private String name;
	private String phone;
	private String issueDay;
	private String issue;
	
	public ScheduleVO(){}
	
	public ScheduleVO(int studentId,String issueDay,String issue) {
		this.studentId=studentId; this.issueDay=issueDay; this.issue=issue;
	}
	public ScheduleVO(String name,String phone,String issueDay,String issue) {
		this.name=name; this.phone=phone; this.issueDay=issueDay; this.issue=issue;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIssueDay() {
		return issueDay;
	}

	public void setIssueDay(String issueDay) {
		this.issueDay = issueDay;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	
}
