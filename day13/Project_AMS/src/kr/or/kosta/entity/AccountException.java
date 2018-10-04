/**
 * 예외처리 클래스
 */
package kr.or.kosta.entity;

import javax.swing.JOptionPane;

public class AccountException extends Exception {
	
	private int errorCode;	
	
	public AccountException() {
		this("계좌처리 중 예기치 않은 에러가 발생하였습니다.", -9);
		
	}

	public AccountException(String arg0, int errorCode) {
		super(arg0);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		return "AccountException [errorCode=" + errorCode + ", getMessage()=" + getMessage() + "]";
	}
	
	
	

}
