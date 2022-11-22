package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class STDManager {

	Connection connection = null;
	Statement stmt=null;
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
private static STDManager stdManager= null;
	
	public static STDManager getInstance() {
		if(stdManager==null) stdManager = new STDManager();
		return stdManager;
	}	
	
	public Connection getCon() {
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "STDMANAGER", "1234");
		} catch (SQLException e) {
			e.printStackTrace();System.out.println("DB연결 실패!");
		}
		return connection;
	}
	
	public void close(Connection c, Statement s) {
		try {
			if(s!=null)s.close();
			if(c!=null)c.close();
		} catch (SQLException e) {
			System.out.println("con,stmt close error!");
		}
	}
	public void close(Connection c, Statement s,ResultSet r) {
		try {
			if(r!=null)r.close();
			if(s!=null)s.close();
			if(c!=null)c.close();
		} catch (SQLException e) {
			System.out.println("con,stmt,rs close error!");
		}
	}
	
	public void close(Connection c, PreparedStatement p,ResultSet r) {
		try {
			if(r!=null)r.close();
			if(p!=null)p.close();
			if(c!=null)c.close();
		} catch (SQLException e) {
			System.out.println("con,pstmt,rs close error!");
		}
	}
	
	//sql 실행
	public int run(String sql) {
		int result=0;
		connection = getCon();
		try {
			stmt = connection.createStatement();
			result=stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(connection,stmt);
		return result;
	}
	
	//해당 데이터가 있으면 1 반환
	public int selectChkExists(String sql) {
		int result = 0;
		connection = getCon();
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) result = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//숫자 검색 후 찾아서 해당 value 반환
	public int selectCnt(String sql) {
		int result = 0;
		connection = getCon();
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
