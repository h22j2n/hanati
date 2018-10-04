package kr.or.kosta.entity;

 

import java.util.ArrayList;

import java.util.Collections;

import java.util.Enumeration;

import java.util.Hashtable;

import java.util.List;

 

import javax.swing.JOptionPane;

 

import kr.or.kosta.boundary.MainPanel;

 

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

	public Account get(String accountNum) throws AccountException {

		if (accountNum.length() < 1) {

			JOptionPane.showMessageDialog(null, "계좌번호를 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);

			throw new AccountException("계좌번호를 입력해주세요.", -300);

		} else if (!(accounts.containsKey(accountNum)) && accountNum.length() > 0) {

			JOptionPane.showMessageDialog(null, "해당 계좌가 존재하지 않습니다.", "경고", JOptionPane.ERROR_MESSAGE);

			throw new AccountException("존재하지 않는 계좌입니다.", -200);

		}

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

 

	 

	/**이름으로 검색

	 * @param accountOwner 소유주

	 * @return 검색결과

	 */

	public List<Account> search(String accountOwner) throws AccountException {

		if (accountOwner.length() < 1) {

			JOptionPane.showMessageDialog(null, "검색할 사람의 이름을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);

			throw new AccountException("검색할 사람의 이름을 입력해주세요.", -400);

		} else if (accounts.containsValue(accountOwner) && accountOwner.length() > 0) {

			JOptionPane.showMessageDialog(null, "예금주가 존재하지 않습니다.", "경고", JOptionPane.ERROR_MESSAGE);

			throw new AccountException("존재하지 않는 계좌입니다.", -200);

		}

 

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

	 * 계좌번호 삭제

	 * @param accountNum 삭제할 계좌번호

	 * @return 결과 성공/실패

	 * @throws AccountException

	 */

	public boolean remove(String accountNum) throws AccountException {

		if (accountNum.length() < 1) {

			JOptionPane.showMessageDialog(null, "계좌번호를 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);

			throw new AccountException("계좌번호를 입력해주세요.", -300);

		} else if (!(accounts.containsKey(accountNum)) && accountNum.length() > 0) {

			JOptionPane.showMessageDialog(null, "해당 계좌가 존재하지 않습니다.", "경고", JOptionPane.ERROR_MESSAGE);

			throw new AccountException("존재하지 않는 계좌입니다.", -200);

		}

		Enumeration<Account> e = accounts.elements();

		while (e.hasMoreElements()) {

			Account account = (Account) e.nextElement();

			if (account.getAccountNum().equals(accountNum)) {

				return accounts.remove(accountNum, account);

			}

		}

		return false;

	}

 

 

}

 