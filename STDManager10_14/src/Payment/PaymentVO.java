package Payment;

public class PaymentVO {
	private int studentId;
	private String payDay;
	private String startCareDay;
	private String endCareDay;
	private boolean isRefund;
	private int refundAmount;
	private String refundDay;
	
	public PaymentVO() {}
	
	
	public PaymentVO(int sid,String pday,String SCD,String ECD,boolean isRefund,int refundA,String refundD) {//전체입력생성
		studentId=sid; payDay=pday; startCareDay=SCD; endCareDay=ECD; 
		this.isRefund=isRefund; refundAmount=refundA; refundDay=refundD;
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


	public boolean isRefund() {
		return isRefund;
	}


	public void setRefund(boolean isRefund) {
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
	
	
	
	
}
