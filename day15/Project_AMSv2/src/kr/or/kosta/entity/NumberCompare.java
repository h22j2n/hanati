package kr.or.kosta.entity;
import java.util.Comparator;

public class NumberCompare implements Comparator<Account> {

	@Override
	public int compare(Account o1, Account o2) {
		// 앞에 있는 값이 크면 양수, 같으면 0, 뒤에 값이 크면 음수
		
		return o1.getAccountNum().compareTo(o2.getAccountNum()); // compareTo 도 똑같이 int 반환
	}
	
	

}
