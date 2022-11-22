package Payment;

public class PaymentVO2 {
	private int studentId;
	private String payDay;
	private int isRefund;
	private int refundAmount;
	private String refundDay;
	private String name;
	private int age;
	private String sex;
	private String phone;
	
	public PaymentVO2() {}
	
	public PaymentVO2(String payDay) {
		this.payDay = payDay;
	}
	public PaymentVO2(String payDay,String refundDay) {
		this.payDay = payDay;this.refundDay = refundDay;
	}
	
	public int getIsRefund() {
		return isRefund;
	}

	public void setIsRefund(int isRefund) {
		this.isRefund = isRefund;
	}

	public PaymentVO2(String name,int age,String sex,String phone,String payDay,int isRefund,int refundAmount,String refundDay) {
		this.name = name; this.age = age; this.sex = sex; this.phone = phone; this.payDay = payDay; this.isRefund=isRefund;
		this.refundAmount = refundAmount; this.refundDay = refundDay;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getPayDay() {
		return payDay;
	}

	public void setPayDay(String payDay) {
		this.payDay = payDay;
	}

	public int isRefund() {
		return isRefund;
	}

	public void setRefund(int isRefund) {
		this.isRefund = isRefund;
	}

	public int getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(int refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRefundDay() {
		return refundDay;
	}

	public void setRefundDay(String refundDay) {
		this.refundDay = refundDay;
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

	@Override
	public String toString() {
		return "PaymentVO2 [payDay=" + getPayDay() + "]";
	}
	
	
	
}
