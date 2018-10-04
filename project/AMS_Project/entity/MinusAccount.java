package kr.or.kosta.entity;

/**
 * Account를 확장한 마이너스 계좌
 * 
 * @author 조희진
 *
 */
public class MinusAccount extends Account {

	// 대출금액
	private long borrowMoney;

	//생성자
	public MinusAccount() {
		this(null, null, 0, 0, 0);
	}

	public MinusAccount(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney) {
		super(accountNum, accountOwner, passwd, restMoney);
		this.borrowMoney = borrowMoney;
	}

	//setter, getter 메소드
	public long getBorrowMoney() {
		return borrowMoney;
	}

	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}

	@Override
	public long getRestMoney() {
		return super.getRestMoney() - getBorrowMoney();
	}

	@Override
	public String toString() {
		return "\t"+getAccountNum() + "\t " + getAccountOwner()+ "\t " + String.format("%,10d", getRestMoney()) + "          " + String.format("%,10d", getBorrowMoney());
	}



}
