package model.dao;
/**
 * user와 account 테이블을 조인해서 사용하는 DAO클래스입니다.
 * 아이디와 암호를 이욯해서 로그인하면
 * 계좌 목록(계좌유형,계좌번호,잔액)이 나오도록 합니다.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.bean.AccountBean;

public class AccountListDAO {
	private PreparedStatement stmt;
	private Connection conn=ConnectionDAO.getInstance().getConn();
	
	public AccountListDAO() {//디폴트생성자
		
	}
	
	public List<AccountBean> accountList(HttpServletRequest request){
		ResultSet rs=null;
		List<AccountBean> accountInfo=null;
		
		try {
			rs=stmt.executeQuery();
			
			if(rs.next()) {//입력한 id와 pw가 DB의 id, pw와 일치하는게 있다면   
			accountInfo=new ArrayList<AccountBean>();
			while(rs.next()) {//accounts에 가져온 정보를 저장하고
				AccountBean account=new AccountBean(rs.getString("joinType"), rs.getString("dealList"), rs.getInt("money"));
				accountInfo.add(account);
			}//login 값을 true로 저장
			request.setAttribute("login", true);
			} else {//없다면 login 값을 false로 저장
				request.setAttribute("login", false);
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
		return accountInfo;
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
