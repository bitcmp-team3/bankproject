package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import model.bean.TransactionBean;


public class AccInfoDAO {
	 private PreparedStatement  stmt;
		private static AccInfoDAO instance;
	 private Connection  conn = ConnectionDAO.getInstance().getConn();

	public AccInfoDAO() { 
		
		
	}
	
	public static AccInfoDAO getInstance() {
//		if(instance==null) instance=new MemberDAO();
//		return instance;
		return (instance==null)?instance=new AccInfoDAO():instance;
	}

	public  List<TransactionBean> accList(HttpServletRequest request) {
		String sql="  select  a.type, a.accNo, t.date, t.deposit, t.withdraw, a.amount" + 
				            "  from account a , transaction t   " + 
				            "  where  a.accNo = t.accNo";
		ResultSet  rest=null;
		List<TransactionBean> orders = null;
		try {
			stmt=conn.prepareStatement(sql);
			rest = stmt.executeQuery();
			orders=new ArrayList<TransactionBean>();
			while(rest.next()) {
				TransactionBean order = new TransactionBean(
						rest.getString("type"),
						rest.getString("accNo"),
						rest.getDate("date"),
						rest.getInt("deposit"),
						rest.getInt("amount"),
						rest.getInt("withdraw"));

		
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rest!=null)rest.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return orders;
	}
	
	
}// orderList() end
	