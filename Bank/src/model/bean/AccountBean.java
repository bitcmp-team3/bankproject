package model.bean;
/**
 * DB의 account 테이블의 정보를 가져다쓰기위해 만드는 bean 클래스입니다.
 */
public class AccountBean {
	private String userNo;
	private String accNo;
	private int amount;
	private String type;
	
	public AccountBean() {
		// TODO Auto-generated constructor stub
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public AccountBean(String userNo,String accNo, int amount,String type) {
		super();
		this.userNo= userNo;
		this.accNo = accNo;
		this.amount = amount;
		this.type = type;
	}
	@Override
	public String toString() {
		return "AccountBean [userNo=" + userNo + ", accNo=" + accNo + ", amount=" + amount + ", type=" + type + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accNo == null) ? 0 : accNo.hashCode());
		result = prime * result + amount;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((userNo == null) ? 0 : userNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountBean other = (AccountBean) obj;
		if (accNo == null) {
			if (other.accNo != null)
				return false;
		} else if (!accNo.equals(other.accNo))
			return false;
		if (amount != other.amount)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userNo == null) {
			if (other.userNo != null)
				return false;
		} else if (!userNo.equals(other.userNo))
			return false;
		return true;
	}
		
}
