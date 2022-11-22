package schedule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import db.STDManager;

public class ScheduleDAO {
	private STDManager stdManager;
	Statement stmt=null;
	
	public ScheduleDAO() {
		stdManager = STDManager.getInstance();
	}
	public int run(String sql) {
		return stdManager.run(sql);
	}
	//전체조회
	public Vector<ScheduleVO> select(String sql){
		Connection connection = stdManager.getCon();
		Vector<ScheduleVO> vec = new Vector<>();
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) vec.add(new ScheduleVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stdManager.close(connection,stmt,rs);
		return vec;
	}
	
}
