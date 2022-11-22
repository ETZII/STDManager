package Student;

public class StudentVO {
	private int studentId;
	private String name;
	private int age;
	private String sex;
	private String phone;
	private String addr;
	private String memo;
	private String restday;
	private int penalty;
	private String startCareDay;
	private String endCareDay;
	
	public StudentVO() {}
	public StudentVO(String name,int age,String sex,String phone
			,String addr,String memo,String startCareDay) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phone= phone;
		this.addr = addr;
		this.memo = memo;
		this.startCareDay = startCareDay;
	}
	public StudentVO(int studentId,String name,int age,String sex,String phone
			,String addr,String memo,String restday,int penalty,String startCareDay,String endCareDay) {
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.phone= phone;
		this.addr = addr;
		this.memo = memo;
		this.restday = restday;
		this.penalty = penalty;
		this.startCareDay = startCareDay;
		this.endCareDay = endCareDay;
		
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getRestday() {
		return restday;
	}
	public void setRestday(String restday) {
		this.restday = restday;
	}
	public int getPenalty() {
		return penalty;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	
	public String getStartCareDay() {
		return startCareDay;
	}
	public void setStartCareDay(String startCareDay) {
		this.startCareDay = startCareDay;
	}
	public String getEndCareDay() {
		return endCareDay;
	}
	public void setEndCareDay(String endCareDay) {
		this.endCareDay = endCareDay;
	}
	@Override
	public String toString() {
		return "StudentVO [studentId=" + studentId + ", name=" + name + ", age=" + age + ", sex=" + sex + ", phone="
				+ phone + ", addr=" + addr + ", memo=" + memo + ", restday=" + restday + ", penalty=" + penalty
				+ ", startCareDay=" + startCareDay + ", endCareDay=" + endCareDay + "]";
	}
	
	
}
