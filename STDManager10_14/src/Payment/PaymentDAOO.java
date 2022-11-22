package Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import db.STDManager;

public class PaymentDAOO {
	private STDManager stdManager;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	PaymentVO vo;
	
	public PaymentDAOO() {
		stdManager = STDManager.getInstance();
	}
	
	public int run(String sql) {
		return stdManager.run(sql);
	}
	
	public int runCnt(String sql) {
		return stdManager.selectCnt(sql);
	}
	
	public Vector<PaymentVO> runVO(String sql){
		Vector<PaymentVO> vec = new Vector<PaymentVO>();
		try {
		con = stdManager.getCon();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			vec.add(new PaymentVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getBoolean(5),rs.getInt(6),rs.getString(7)));
		}
		}catch(SQLException e) {
			e.printStackTrace(); 
		}
		return vec;
		}
	
	public Vector<PaymentVO2> runVO2(String sql){
		Vector<PaymentVO2> vec = new Vector<PaymentVO2>();
		try {
		con = stdManager.getCon();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			vec.add(new PaymentVO2(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4), 
					rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8)));
		}
		}catch(SQLException e) {
			e.printStackTrace(); 
		}
		return vec;
		}
	
	public Vector<PaymentVO3> runVO3(String sql){
		Vector<PaymentVO3> vec = new Vector<PaymentVO3>();
		try {
		con = stdManager.getCon();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			vec.add(new PaymentVO3(rs.getString(1),rs.getInt(2),rs.getString(3),rs.getString(4), 
					rs.getString(5),rs.getString(6),rs.getString(7)));
		}
		}catch(SQLException e) {
			e.printStackTrace(); 
		}
		return vec;
	}
	
	public Vector<PaymentVO3> runVO3_1(String sql){
		Vector<PaymentVO3> vec = new Vector<PaymentVO3>();
		try {
		con = stdManager.getCon();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			vec.add(new PaymentVO3(rs.getInt(1) ,rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5), 
                    rs.getString(6),rs.getString(7),rs.getString(8)));
		}
		}catch(SQLException e) {
			e.printStackTrace(); 
		}
		return vec;
	}
}
