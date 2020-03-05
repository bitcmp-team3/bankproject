package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.AccountBean;
import model.bean.TransactionBean;

public class TransactionDAO {
	private PreparedStatement stmt;
	private Connection conn = ConnectionDAO.getInstance().getConn();
	ResultSet rest;
	public TransactionDAO() {

	}
	public AccountBean accountInfo(String accNo) {
		String sql = "  select * from account where accNo=? ";
		AccountBean accInfos=null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, accNo);
			rest = stmt.executeQuery();
			accInfos = new AccountBean();
			
			if (rest.next()) {
				accInfos.setType(rest.getString("type"));
				accInfos.setAccNo(rest.getString("accNo"));
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
		
		return accInfos;
	}
	public List<TransactionBean> transaction(String accNo) {
		String sql = "  select  a.type, a.accNo, t.date, t.deposit, t.withdraw, t.amount  "
				+ "  from account a , transaction t  where a.accNo=? and a.accNo = t.accNo order by date ";
		List<TransactionBean> transactions = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, accNo);
			rest = stmt.executeQuery();
			transactions = new ArrayList<TransactionBean>();
			
			while (rest.next()) {
				TransactionBean transaction = new TransactionBean(rest.getString("type"), rest.getString("accNo"),
						rest.getDate("date"), rest.getInt("deposit"), rest.getInt("amount"), rest.getInt("withdraw"));

				transactions.add(transaction);
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
		return transactions;
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
