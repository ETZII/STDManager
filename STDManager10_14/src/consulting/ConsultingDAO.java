package consulting;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import db.STDManager;

public class ConsultingDAO {
	
	private STDManager stdManager;
	Statement stmt=null;
	
	public ConsultingDAO() {
		stdManager=STDManager.getInstance();
		
	}
	
	public int run(String sql) {
		return stdManager.run(sql);
	}
	
	public int run1(String sql) {
		return stdManager.selectChkExists(sql);
	}
	
	public Vector<CPlanVO> selectCPlan(String sql){
		Vector<CPlanVO> vec = new Vector<CPlanVO>();
		Connection connection = stdManager.getCon();
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) vec.add(new CPlanVO(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stdManager.close(connection,stmt,rs);
		return vec;
	}
	
	public Vector<ConsultMiniVO> selectConsult(String sql){
		 Vector<ConsultMiniVO> vec = new  Vector<ConsultMiniVO>();
		 Connection connection = stdManager.getCon();
		 ResultSet rs = null;
		 try {
				stmt = connection.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) vec.add(new ConsultMiniVO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stdManager.close(connection,stmt,rs);
			return vec;
	}
	
	public Vector<ProfessorVO> selectPf(String sql){
		Vector<ProfessorVO> vec = new Vector<ProfessorVO>();
		Connection connection = stdManager.getCon();
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) vec.add(new ProfessorVO(rs.getInt(1),rs.getString(2),rs.getString(3)));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stdManager.close(connection,stmt,rs);
		return vec;
	}
	
	public int selectCnt(String sql) {
		return stdManager.selectCnt(sql);
	}
}
