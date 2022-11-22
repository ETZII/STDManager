package Payment;

import java.sql.SQLException;
import java.util.Vector;

public class PaymentUtil {
	PaymentVO3 vo;
	PaymentDAO2 dao;
	public PaymentUtil() throws SQLException{
		vo = new PaymentVO3();
	}
	
	public String isrefund(int num) {
		if(num==1) {
			return "환불완료";
		}else return "환불안함";
	}
	public Vector<PaymentVO2> yesisrefundView() {
		PaymentVO2 vo;
		Vector<PaymentVO2> vec=null;
		vo = new PaymentVO2();
		if(vo.getIsRefund()==1) {
			vec = dao.selectAllPayment();
		}
		return vec;
	}
	public void yesisrefundV2() {
		dao.updatepayDay2();
	}
}
