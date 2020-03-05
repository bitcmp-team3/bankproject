package model.dao;
/**
 * mypage에서 해당 id의 계좌목록을 보여주기 위해 연결하는 dao입니다.
 * 해당 아이디의 계좌 목록(계좌번호,계좌유형,잔액)이 나오도록 합니다.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.bean.AccountBean;

public class AccountListDAO {
	private PreparedStatement stmt;
	private Connection conn=ConnectionDAO.getInstance().getConn();
	ResultSet rs;
	
	public AccountListDAO() {
		
	}
	public List<AccountBean> accountList(HttpServletRequest request){
		String sql=" select u.userNo, a.type, a.accNo, a.amount "
				+ "from user u, account a where u.id=? and u.userNo=a.userNo  ";
		List<AccountBean> accounts=null;
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("id"); //session에서 가져온 id값을 id로 저장.
		try {
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			
			accounts=new ArrayList<AccountBean>();
			while(rs.next()) {
				AccountBean account=new AccountBean(rs.getString("userNo"), 
				rs.getString("accNo"), rs.getInt("amount"), rs.getString("type"));
				accounts.add(account);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return accounts;
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
