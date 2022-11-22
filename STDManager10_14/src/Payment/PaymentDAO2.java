package Payment;

import java.util.Vector;

public class PaymentDAO2 {
	PaymentDAOO dao;
	PaymentSQL sql;
	public PaymentDAO2() {
		dao = new PaymentDAOO();
		sql = new PaymentSQL();
	}
	
	//--------이름 번호로 모두 조회
	public Vector<PaymentVO2> selectAllPayment() {
		return dao.runVO2(sql.selectAll());
	}
	
	//--------id조건 max payday 구하기
	public Vector<PaymentVO2> selectAllPaymentThree(int id) {
		return dao.runVO2(sql.selectAllThree(id));
	}
	
	//--------이름 번호로 모두 조회 결제 관리
		public Vector<PaymentVO3> selectAllPaymentSTD() {
			return dao.runVO3(sql.selectAllSTD());
		}
		//--------이름 번호로 모두 조회 결제 관리
		public Vector<PaymentVO3> selectAllPaymentSTD2() {
			return dao.runVO3_1(sql.selectSTD2());
		}
//	--- 학생번호, 조회
	public  Vector<PaymentVO> selectPayment(int id) {
		return dao.runVO(sql.selectPayment(id));
	}
	public  Vector<PaymentVO3> selectPayment2(int id) {
		return dao.runVO3(sql.selectPayment2(id));
	}
//	필터 검색
	public Vector<PaymentVO2> datefilterSelectPay(String key,String value){
		return dao.runVO2(sql.dateFilter(key, value));
	}
	
//	필터 검색 페이먼트 all
	public Vector<PaymentVO3> allfilterSelectday(String key,String value){
		return dao.runVO3(sql.allFilter(key, value));
	}
	public Vector<PaymentVO2> datefilterNameSelectPay(String key,String value){
		return dao.runVO2(sql.dateFilterNameSelect(key, value));
	}
	public Vector<PaymentVO3> allfilterNameSelectPay(String key,String value){
		return dao.runVO3(sql.allFilterName(key, value));
	}
	
//		-----등록
		public int insertPayment(int studentid,int refundAmount,String rdfundDay) {
			return dao.run(sql.insert(studentid, refundAmount, rdfundDay));
		}
//		-----등록 결제 완료일
		public int insertPaymentpayday(int studentid) {
			return dao.run(sql.insertPayday(studentid));
		}
//		---- 삭제 결제번호
		public int deletePayment(int paymentid) {
			return dao.run(sql.delete(paymentid));
		}
//		---- 결제완료일 수정
		public int updatepayDay2() {
			return dao.run(sql.updatePayday2());
		}
//		---- 결제완료일 수정
		public int updatepayDay(String payday, int id,int refundA) {
			return dao.run(sql.updatePayday(payday, id, refundA));
		}
		
//		---- 환불여부 수정
		public int updateisRefund(int isRefund,int no) {
			return dao.run(sql.updateIsRefund(isRefund, no));
		}
		
//		---- 환불금액 수정
		public int updaterefundAmount(int refundAmount,int no) {
			return dao.run(sql.updateRefundAmount(refundAmount, no));
		}
//		---- 수정
		public int updaterdfundDay(int rdfundDay,int no) {
			return dao.run(sql.updateRefundDay(rdfundDay, no));
		}
		
		public int cntStd() {
			return dao.runCnt(sql.paymentCnt());
		}
		
		public int cntStd1() {
			return dao.runCnt(sql.paymentCnt1());
		}
		
		public int cntStd2() {
			return dao.runCnt(sql.paymentCnt2());
		}
		
}
