package Payment;

public class PaymentVO3 {
	private int paymentid;
	private int studentId;
	private String name;
	private int age;
	private String phone;
	private String payDay;
	private String restday;
	private String startcareday;
	private String endcareday;
	
	
	public PaymentVO3() {}
	
	public PaymentVO3(String payDay,String restday,String startcareday,String endcareday) {
		this.payDay = payDay; this.startcareday = startcareday; this.endcareday = endcareday ;
	}
	
	public PaymentVO3(String name,int age,String phone,String payDay,String restday,String startcareday,String endcareday) {
		this.name = name; this.age = age; this.phone = phone; this.payDay = payDay;  this.restday = restday;
		this.startcareday = startcareday; this.endcareday = endcareday ;
	}
	public PaymentVO3(int studentId, String name,int age,String phone,String payDay,String restday,String startcareday,String endcareday) {
		this.studentId = studentId;  this.name = name; this.age = age; this.phone = phone; this.payDay = payDay;  this.restday = restday;
		this.startcareday = startcareday; this.endcareday = endcareday ;
	}
	public PaymentVO3(int paymentid, int studentId,String name,int age,String phone,String payDay,String restday,String startcareday,String endcareday) {
		this.paymentid = paymentid; this.studentId = studentId; this.name = name; this.age = age; this.phone = phone; this.payDay = payDay;  this.restday = restday;
		this.startcareday = startcareday; this.endcareday = endcareday ;
	}
	
	

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPayDay() {
		return payDay;
	}

	public void setPayDay(String payDay) {
		this.payDay = payDay;
	}

	public String getRestday() {
		return restday;
	}

	public void setRestday(String restday) {
		this.restday = restday;
	}

	public String getStartcareday() {
		return startcareday;
	}

	public void setStartcareday(String startcareday) {
		this.startcareday = startcareday;
	}

	public String getEndcareday() {
		return endcareday;
	}

	public void setEndcareday(String endcareday) {
		this.endcareday = endcareday;
	}

	
	
}
