package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.AccountBean;

/**
 * Servlet implementation class DeleteDAO
 */
public class DeleteDAO {
	private PreparedStatement stmt;
	private Connection conn = ConnectionDAO.getInstance().getConn();
	ResultSet rest;
	public DeleteDAO() {

	}
	public AccountBean delInfo(String accNo) {
		String sql = "  DELETE FROM bank.account WHERE accNo = ? ";
		AccountBean delInfos=null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, accNo);
			delInfos = new AccountBean();
//			rest = stmt.executeQuery();
			if (rest.next()) {
				delInfos.setType(rest.getString("type"));
				delInfos.setAccNo(rest.getString("accNo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rest != null)
					rest.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return delInfos;
	}

	@Override
	protected void finalize() throws Throwable {
		try {
			if(stmt!=null) stmt.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
		super.finalize();
	}

}