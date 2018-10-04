package kr.or.kosta.entity;

/**
 * 
 * 일상생활의 객체를 추상화하기 위한 모델링 클래스 정의
 * 
 * 은행계좌 객체
 * 
 */

public class Account {

	// 클래스 변수 선언

	public final static String bankName = "Kosta은행";

	// 인스턴스 변수 선언

	private String accountNum;

	private String accountOwner;

	private int passwd;

	private long restMoney;

	// 생성자

	public Account() {

		this(null, null, 0, 0);

	}

	public Account(String accountNum, String accountOwner) {

		this.accountNum = accountNum;

		this.accountOwner = accountOwner;

	}

	public Account(String accountNum, String accountOwner, int passwd, long restMoney) {

		this.accountNum = accountNum;

		this.accountOwner = accountOwner;

		this.passwd = passwd;

		this.restMoney = restMoney;

	}

	public Account(String accountNum, String accountOwner, long restMoney) {

		this.accountNum = accountNum;

		this.accountOwner = accountOwner;

		this.passwd = 11111;

		this.restMoney = restMoney;

	}

	// setter/getter 메소드

	public void setAccountNum(String accountNum) {

		this.accountNum = accountNum;

	}

	public String getAccountNum() {

		return accountNum;

	}

	public void setAccountOwner(String accountOwner) {

		this.accountOwner = accountOwner;

	}

	public String getAccountOwner() {

		return accountOwner;

	}

	public void setPasswd(int passwd) {

		this.passwd = passwd;

	}

	public int getPasswd() {

		return passwd;

	}

	public void setRestMoney(long restMoney) {

		this.restMoney = restMoney;

	}

	// 인스턴스 메소드

	public long deposit(long money) throws AccountException {

		if (money <= 0) {

			throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다.", -1);

		}

		restMoney += money;

		return restMoney;

	}

	public long withdraw(long money) throws AccountException {

		if (money <= 0) {

			throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다.", -1);

		}

		if (money > restMoney) {

			throw new AccountException("잔액이 부족합니다.", -2);

		}

		restMoney -= money;

		return restMoney;

	}

	public long getRestMoney() {

		return restMoney;

	}

	public boolean checkPasswd(int pw) {

		return passwd == pw;

	}

	@Override

	public String toString() {

		return " 입출금계좌" + String.format("%30s%18s%,20d", accountNum,accountOwner,restMoney);

	}

	@Override

	public boolean equals(Object obj) {

		boolean eq = false;

		if (obj instanceof Account) {

			eq = toString().equals(obj.toString());

		}

		return eq;

	}

	// 클래스(static) 메소드

	public static int sum(int a, int b) {

		return a + b;

	}

}