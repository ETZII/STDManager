package Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import db.STDManager;

public class StudentDAO {
	
	private STDManager stdManager;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public StudentDAO() {
		stdManager = STDManager.getInstance();
	}
	
	public int run(String sql) {
		return stdManager.run(sql);
	}
	
	public int runCnt(String sql) {
		return stdManager.selectCnt(sql);
	}
	public Vector<StudentVO> runVec(String sql){
		Vector<StudentVO> vec = new Vector<>();
		try {
			con = stdManager.getCon();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vec.add(new StudentVO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11)));
			}
			stdManager.close(con, pstmt, rs);
		}catch(SQLException e) {
			e.printStackTrace(); 
		}
		return vec;
	}
	
	public StudentVO runVO(String sql){
		StudentVO vo = new StudentVO();
		try {
			con = stdManager.getCon();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo= new StudentVO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),
						rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11));
			}
			stdManager.close(con, pstmt, rs);
		}catch(SQLException e) {
			e.printStackTrace(); 
		}
		return vo;
	}
}
	