package db;

import java.sql.SQLException;

import calendar.DateTime;

public class DBDAOSQL {
	STDManager stdM;
	
	public DBDAOSQL() throws SQLException {
		stdM=STDManager.getInstance();
	}
	//매달 마지막날 프로그램 완전종료시 출결db 삭제
	public int deleteAtt() {
		return stdM.run( "DELETE FROM AttendanceTBL where TO_CHAR(day,'yyyymm') in '"+new DateTime().format()+"'");
	}
	
}
