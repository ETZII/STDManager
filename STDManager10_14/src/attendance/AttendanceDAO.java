package attendance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import db.STDManager;

public class AttendanceDAO {

	private STDManager stdManager;
	Statement stmt=null;
	
	public AttendanceDAO() throws SQLException {
		stdManager = STDManager.getInstance();
	}
		
	public int run(String sql) {
		return stdManager.run(sql);
	}
	//전체조회
	public Vector<AttendanceVO> selectAttName(String sql){
		Connection connection = stdManager.getCon();
		Vector<AttendanceVO> vec = new Vector<>();
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) vec.add(new AttendanceVO(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stdManager.close(connection,stmt,rs);
		return vec;
	}
	
	// value 받아서 리턴
	public int cntAtt(String sql) {
		int cnt=0;
		Connection connection = stdManager.getCon();
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) cnt = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stdManager.close(connection, stmt);
		return cnt;
	}
}