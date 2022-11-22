package Payment;

public class PaymentSQL {

	public String selectAll() {
		return "select s.name,s.age,s.sex,s.phone, "
				+ "to_char(payday,'yy/mm/dd'),isrefund,refundamount,to_char(refundday,'yy/mm/dd')"
				+ " from paymenttbl p inner join studenttbl s on p.studentid = s.studentid"
				+ " where isrefund = 1 "
				+ " ORDER BY paymentid";
	}
	
	public String selectAllThree(int id) {
		return "select max(payday) from paymenttbl where studentid = "+id;
	}
	
	public String selectAllSTD() {
		return "select s.name,s.age,s.phone,payday,s.restday,s.startcareday,s.endcareday"
				+ " from paymenttbl p inner join studenttbl s on p.studentid = s.studentid"
				+ " order by p.studentid";
	}
	
	public String selectSTD2() {
		return "select p.studentid,name,age,phone,"
				+ " payday,to_char(restday,'yy/mm/dd'),to_char(startcareday,'yy/mm/dd'),to_char(endcareday,'yy/mm/dd')"
				+ " from paymenttbl p inner join studenttbl s on p.studentid = s.studentid"
				+ " where isrefund = 0 "
				+ " order by p.studentid";
	}
	
	public String selectPayment(int id) {
		return "select paymentid,studentid,payday,isrefund,refundamount,refundday"
				+ " from paymenttbl where studentid = ? order by paymentid";
	}
	
	public String selectPayment2(int id) {
		return "select paymentid,studentid,payday,isrefund,refundamount,refundday"
				+ " from paymenttbl where studentid = ? order by paymentid";
	}
	
	public String dateFilter(String key,String value) {
		return "select s.name,s.age,s.sex,s.phone, "
				+ "to_char(payday,'yyyy/mm/dd'),isrefund,refundamount,to_char(refundday,'yyyy/mm/dd')"
				+" from paymenttbl p inner join studenttbl s on p.studentid = s.studentid"
				+" where TO_CHAR("+key+",'yy/mm/dd') in '"+value+"' ORDER BY paymentid";
	}
	
	public String dateFilterNameSelect(String key,String value) {
		return "select s.name,s.age,s.phone, "
				+ "to_char(payday,'yyyy/mm/dd'),isrefund,refundamount,to_char(refundday,'yyyy/mm/dd')"
				+" from paymenttbl p inner join studenttbl s on p.studentid = s.studentid"
				+" where "+key+" like '%"+value+"%' ORDER BY paymentid";
	}
	
	
	public String allFilter(String key,String value) {
		return "select s.name,s.age,s.phone,payday,s.restday,s.startcareday,s.endcareday"
				+ " from paymenttbl p inner join studenttbl s on p.studentid = s.studentid"
				+" where TO_CHAR("+key+",'yy/mm/dd') in '"+value+"' ORDER BY paymentid";
	}
	
	public String allFilterName(String key,String value) {
		return "select s.name,s.age,s.phone,payday,s.restday,s.startcareday,s.endcareday"
				+ " from paymenttbl p inner join studenttbl s on p.studentid = s.studentid"
				+" where "+key+" like '%"+value+"%' ORDER BY paymentid";
	}
	
	public String insert(int studentid,int refundAmount,String rdfundDay) {
		return "insert into paymenttbl(paymentid,studentid,refundAmount,refundDay)"
				+ " values(pay_seq.nextval,"+studentid+","+refundAmount+",'"+rdfundDay+"')";
	}
	
	public String insertPayday(int studentid) {
		return "insert into paymenttbl(paymentid,studentid,payday)"
				+ " values(pay_seq.nextval,"+studentid+",sysdate)";
	}
	
	public String delete(int studentid) {
		return "delete from paymenttbl where paymentid="+studentid;
	}
	
	public String updatePayday2() {
		return "update paymenttbl set isrefund = 1 where refundamount is not null and refundday is not null";
	}
	
	public String updatePayday(String payday, int id,int refundA) {
		return "update paymenttbl set  isrefund = 1 , refundAmount = "+refundA+", refundDay = sysdate "
				+ " where payday = to_date('"+payday+"','YYYY-MM-DD HH24:MI:SS') and studentid ="+id;
	}
	
	public String updateIsRefund(int isRefund,int no) {
		return "update paymenttbl set isRefund=? where studentId =? ";
	}
	
	public String updateRefundAmount(int refundAmount,int no) {
		return "update paymenttbl set refundAmount=? where studentId =? ";
	}
	
	public String updateRefundDay(int rdfundDay,int no) {
		return "update paymenttbl set rdfundDay="+rdfundDay+" where studentId ="+no;
	}
	
	public String paymentCnt() {
		return "select count(*) from paymenttbl";
	}
	
	public String paymentCnt1() {
		return "select count(*) from paymenttbl where isrefund = 1";
	}
	
	public String paymentCnt2() {
		return "select count(*) from paymenttbl where payday is not null and isrefund = 0";
	}
	
	
	
}
