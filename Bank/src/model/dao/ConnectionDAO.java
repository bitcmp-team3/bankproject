package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DB접속을 위한 DAO 입니다.
 * Connection은 conn으로 줄여쓰도록 하겠습니다.
 * 본인의 mysql 비밀번호를 확인해주세요. 기본은  1234로 설정해놓았습니다.
 */
public class ConnectionDAO {
	private Connection conn; 
	private static ConnectionDAO instance;
	
	public Connection getConn() {
		return conn;
	}
	private ConnectionDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn=DriverManager.getConnection("jdbc:mysql://localhost/bank?useUnicode=true&"
					+ "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "1234");
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ConnectionDAO getInstance() {
	
		return (instance==null)?instance=new ConnectionDAO():instance;
		
	}
	private void close() {
		try {
			if(conn!=null) conn.close(); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	protected void finalize() throws Throwable {
	close();
	super.finalize();
	}

}
