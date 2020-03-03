package model.bean;

import java.sql.Date;

public class TransactionBean {
	private String transNo;
	private String userNo;
	private String accNo;
	private int amount;
	private Date date;
	private int deposit;
	private int withdraw;
	private String type;

	@Override
	public String toString() {
		return "TransactionBean [transNo=" + transNo + ", userNo=" + userNo + ", accNo=" + accNo + ", amount=" + amount
				+ ", date=" + date + ", deposit=" + deposit + ", withdraw=" + withdraw + ", type=" + type + "]";
	}
    public TransactionBean() {
		// TODO Auto-generated constructor stub
	}
	public TransactionBean(String type, String accNo, Date date, int deposit, int amount, int withdraw) {
		super();
		this.type = type;
		this.accNo = accNo;
		this.date = date;
		this.deposit = deposit;
		this.amount = amount;
		this.withdraw = withdraw;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accNo == null) ? 0 : accNo.hashCode());
		result = prime * result + amount;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + deposit;
		result = prime * result + ((transNo == null) ? 0 : transNo.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((userNo == null) ? 0 : userNo.hashCode());
		result = prime * result + withdraw;
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
		TransactionBean other = (TransactionBean) obj;
		if (accNo == null) {
			if (other.accNo != null)
				return false;
		} else if (!accNo.equals(other.accNo))
			return false;
		if (amount != other.amount)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (deposit != other.deposit)
			return false;
		if (transNo == null) {
			if (other.transNo != null)
				return false;
		} else if (!transNo.equals(other.transNo))
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
		if (withdraw != other.withdraw)
			return false;
		return true;
	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
