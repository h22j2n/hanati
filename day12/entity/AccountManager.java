package kr.or.kosta.entity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

/**
 * 배열을 이용한 은행계좌 관리
 * 
 * @author 조희진
 *
 */
public class AccountManager {

	private Hashtable<String, Account> accounts;
	// count 가 필요없음 size()가 있으니까

	public AccountManager(int capacity) {
		accounts = new Hashtable<String, Account>(capacity, 5);
	}

	public Hashtable<String, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Hashtable<String, Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 * 계좌 추가
	 * 
	 * @param account 추가할 계좌
	 */
	public void add(Account account) throws AccountException {
		if (accounts.containsKey(account.getAccountNum())) {
			JOptionPane.showMessageDialog(null, "이미 등록된 계좌입니다.", "경고", JOptionPane.ERROR_MESSAGE);
			throw new AccountException("이미 등록된 계좌입니다.", -100);
			
		}
		accounts.put(account.getAccountNum(), account);
	}

	// 실제 들어있는 것만 반환
	/**
	 * @return 계좌 목록
	 */
	public List<Account> list() {
//		return accounts; 로 해도 됨
		List<Account> l = new ArrayList<Account>(accounts.size());
		Enumeration<Account> e = accounts.elements();
		while (e.hasMoreElements()) {
			Account string = e.nextElement();
			l.add(string);
		}
		Collections.sort(l, new NumberCompare());
		return l;
	}

	/**
	 * 계좌로 검색
	 * 
	 * @param accountNum 계좌번호
	 * @return 검색결과
	 */
	public Account get(String accountNum) {
		Enumeration<String> e = accounts.keys();
		while (e.hasMoreElements()) {
			String string = (String) e.nextElement();
			Account account = accounts.get(string);
			if (string.equals(accountNum)) {
				return account;
			}
		}
		return null;
	}

	// 이름으로 검색
	/**
	 * @param accountOwner 소유주
	 * @return 검색결과
	 */
	public List<Account> search(String accountOwner) {

		List<Account> list = new ArrayList<Account>();
		Enumeration<Account> e = accounts.elements();
		while (e.hasMoreElements()) {
			Account object = (Account) e.nextElement();
			if (object.getAccountOwner().equals(accountOwner)) {
				list.add(object);
			}
		}
		return list;
	}

	/**
	 * @param accountNum 삭제할 계좌번호
	 * @return 결과 성공/실패
	 */
	public boolean remove(String accountNum) {
		Enumeration<Account> e = accounts.elements();
		while (e.hasMoreElements()) {
			Account object = (Account) e.nextElement();
			if (object.getAccountNum().equals(accountNum)) {
				return accounts.remove(accountNum, object);
			}
		}
		return false;
	}


	public static void main(String[] args) throws AccountException {
		try {
			AccountManager manager = new AccountManager(100);
			Account account = new Account("1111-2222-3333", "조희진", 1111, 10000);
			manager.add(account);

			manager.add(new Account("2222-2222-3333", "양의지", 1111, 200000));
			manager.add(new Account("3333-2222-3333", "박건우", 1111, 300000));
			manager.add(new Account("4444-2222-3333", "오재원", 1111, 400000));
			manager.add(new Account("5555-2222-3333", "박보검", 1111, 1000000));
			manager.add(new Account("6666-2222-3333", "박보검", 1111, 2000000));

			List<Account> list = manager.list();
			for (Account account2 : list) {
				System.out.println(account2);
			}

			System.out.println();

			if (manager.get("1111-2222-3333") == null) {
				System.out.println("해당하는 계좌가 없습니다.");
			} else
				System.out.println(manager.get("1111-2222-3333").toString());

			System.out.println();
			List<Account> search = manager.search("박보검");

			if (search == null) {
				System.out.println("해당하는 계좌가 없습니다.");
			} else {
				for (Object account3 : search) {
					System.out.println(account3);
				}
			}
			System.out.println();

			boolean remove = manager.remove("1111-2222-3333");
			if (remove == false) {
				System.out.println("삭제 실패!");
			} else
				System.out.println("삭제 완료!");

		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}

	}
}
