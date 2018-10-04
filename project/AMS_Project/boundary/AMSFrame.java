/**
 * Panel을 붙일 Frame
 */

package kr.or.kosta.boundary;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountException;
import kr.or.kosta.entity.AccountManager;
import kr.or.kosta.entity.MinusAccount;

public class AMSFrame extends Frame {

	MainPanel mainPanel;

	AccountManager manager;

	public AMSFrame() {
		this("이름없음");

	}

	public AMSFrame(String title) {
		super(title);
		mainPanel = new MainPanel();
		manager = new AccountManager(5);
	}

	/**
	 * Frame 초기화
	 */
	public void init() {
		mainPanel.setContents();
		this.add(mainPanel);
		setDisplaySize();
		try {
			manager.add(new Account("2222-2222-3333", "양의지", 1111, 200000));
			manager.add(new Account("3333-2222-3333", "박건우", 1111, 300000));
			manager.add(new Account("4444-2222-3333", "오재원", 1111, 400000));
			manager.add(new Account("5555-2222-3333", "박보검", 1111, 1000000));
			manager.add(new Account("6666-2222-3333", "박보검", 1111, 2000000));

			MinusAccount minusAccount = new MinusAccount();

			MinusAccount minusAccount2 = new MinusAccount("9999-1111-2222", "조대출", 1111, 0, 1000000);
			manager.add(minusAccount2);
		} catch (Exception e) {
		}
		eventRegist();
	}

	/**
	 * 화면 조정
	 */
	public void setDisplaySize() {
		setSize(600, 600);
		setVisible(true);
		setCenter();
	}
	
	/**
	 * 프레임 Center에 위치시키기
	 */
	public void setCenter() {
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (dim.width - getSize().width) / 2;
		int y = (dim.height - getSize().height) / 2;
		setLocation(x, y);
	}

	/**
	 * 종료기능
	 */
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	/**
	 * 계좌 조회할 때 TextArea에 초기화 블록입력
	 */
	public void startLine() {
		mainPanel.accountListTA.setText("");
		mainPanel.accountListTA.append("--------------------------------------------------------------------------------"+"\n");
		mainPanel.accountListTA.append("계좌종류  " + "\t" + "\t" + "계좌번호" + "\t" + "\t" + "예금주명" + "\t" + "   현재잔액" + "          " + "대출금액"+"\n");
		mainPanel.accountListTA.append("==============================================================================="+"\n");
	}

	/**
	 * 계좌 조회할 때 TextArea에 마지막 줄입력
	 */
	public void endLine() {
		mainPanel.accountListTA.append("--------------------------------------------------------------------------------");
	}

	/**
	 * TextField 를 공백으로
	 */
	public void setTextNull() {
		mainPanel.accountNumTF.setText("");
		mainPanel.nameTF.setText("");
		mainPanel.passwdTF.setText("");
		mainPanel.depositTF.setText("");
		mainPanel.loanTF.setText("");
	}

	/**
	 * Account등록시 유효성 검사
	 * 
	 * @param account 확인할 계좌
	 */
	public boolean checkAccount(Account account) {

		if (account.getAccountNum().length() < 1) {
			JOptionPane.showMessageDialog(null, "계좌번호를 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (account.getAccountOwner().length() < 1) {
			JOptionPane.showMessageDialog(null, "예금주의 이름을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (account.getAccountOwner().matches(".*[0-9].*")) {
			JOptionPane.showMessageDialog(null, "이름에 숫자가 포함될 수 없습니다.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (String.valueOf(account.getPasswd()).length() != 4) {
			JOptionPane.showMessageDialog(null, "비밀번호를 4자리로 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (account.getRestMoney() == 0) {
			JOptionPane.showMessageDialog(null, "예금할 금액을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * MinusAccount공백값 있는지 확인
	 * 
	 * @param account 확인할 계좌
	 */
	public boolean checkMinusAccount(MinusAccount account) {

		if (account.getAccountNum().length() < 1) {
			JOptionPane.showMessageDialog(null, "계좌번호를 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (account.getAccountOwner().length() < 1) {
			JOptionPane.showMessageDialog(null, "예금주의 이름을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (String.valueOf(account.getPasswd()).length() != 4) {
			JOptionPane.showMessageDialog(null, "비밀번호를 4자리로 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (account.getRestMoney() == 0) {
			JOptionPane.showMessageDialog(null, "예금할 금액을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		} else if (account.getBorrowMoney() == 0) {
			JOptionPane.showMessageDialog(null, "대출할 금액을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * 계좌종류 판단
	 * 
	 * @param account 판단할 계좌
	 * @return 계좌의 종류
	 */
	public String kindOfAccount(Account account) {

		if (account instanceof MinusAccount) {
			MinusAccount minusAccount = (MinusAccount) account;
			return "마이너스계좌" + minusAccount.toString();

		} else {
			return "입출금계좌" + account.toString();
		}
	}
	
	// 조회할 때 입출금계좌, 마이너스계좌 순으로 조회
	public void range() {
		startLine();
		Enumeration<Account> enumeration = manager.getAccounts().elements();
		Account account;
		while (enumeration.hasMoreElements()) {
			account = (Account) enumeration.nextElement();
			if (!(account instanceof MinusAccount)) {
				mainPanel.accountListTA.append(kindOfAccount(account) + "\n");
			}

		}
		enumeration = manager.getAccounts().elements();
		while (enumeration.hasMoreElements()) {
			account = (Account) enumeration.nextElement();
			if (account instanceof MinusAccount) {
				mainPanel.accountListTA.append(kindOfAccount(account) + "\n");
			}

		}
		endLine();
	}

	/**
	 * 이벤트 등록
	 */
	public void eventRegist() {

		/**
		 * 창 닫기 눌렀을 때 종료
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});

		/**
		 * choice 선택할 때 조회 기능
		 */
		mainPanel.choice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				

				// choice에서 전체 선택했을 때
				if (mainPanel.choice.getSelectedItem().equals("전체")) {
					mainPanel.loanTF.setEnabled(true); // 비활성화
					Enumeration<Account> enumeration = manager.getAccounts().elements();
					Account account;
					range();

					// choice에서 입출금계좌 선택했을 때
				} else if (mainPanel.choice.getSelectedItem().equals("입출금계좌")) {
					mainPanel.loanTF.setEnabled(false);
					Account account;
					Enumeration<Account> enumeration = manager.getAccounts().elements();
					startLine();
					while (enumeration.hasMoreElements()) {

						account = (Account) enumeration.nextElement();

						if (!(account instanceof MinusAccount)) {

							mainPanel.accountListTA.append("입출금계좌 " + account.toString() + "\n");

						}
					}
					endLine();

					
					// choice에서 마이너스계좌 선택했을 때
				} else if (mainPanel.choice.getSelectedItem().equals("마이너스계좌")) {
					mainPanel.loanTF.setEnabled(true);
					Account account;
					MinusAccount minusAccount;
					Enumeration<Account> enumeration = manager.getAccounts().elements();
					startLine();
					while (enumeration.hasMoreElements()) {

						account = (Account) enumeration.nextElement();

						if (account instanceof MinusAccount) {
							minusAccount = (MinusAccount) account;

							mainPanel.accountListTA.append("마이너스계좌 " + minusAccount.toString() + "\n");

						}
					}
					endLine();
				}
			}
		});

		/**
		 * 조회버튼을 누를 시 계좌번호를 통해 계좌 조회
		 */
		mainPanel.show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startLine();
				Account account;
				try {
					account = manager.get(mainPanel.accountNumTF.getText());
					mainPanel.accountListTA.append(kindOfAccount(account) + "\n");
				} catch (AccountException e1) {
					System.out.println(e1.toString());
				}

				endLine();
				setTextNull();
			}
		});

		/**
		 * 삭제버튼 누를 시 계좌 삭제
		 */
		mainPanel.delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (manager.remove(mainPanel.accountNumTF.getText())) {
						JOptionPane.showMessageDialog(null, "삭제되었습니다!", "안내", JOptionPane.INFORMATION_MESSAGE);

						}

					}
				 catch (HeadlessException e1) {
					System.out.println(e1.toString());
				} catch (AccountException e1) {
					System.out.println(e1.toString());
				}

				range();
				setTextNull();

			}
		});

		/**
		 * 검색버튼을 눌렀을 시 이름으로 계좌조회
		 */
		mainPanel.search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				startLine();
				List<Account> search;
				try {
					search = manager.search(mainPanel.nameTF.getText());

					for (Object object : search) {
						Account account = (Account) object;
						System.out.println(account);
						mainPanel.accountListTA.append(kindOfAccount(account) + "\n");

					}
				} catch (AccountException e1) {
					System.out.println(e1.toString());
				}

				endLine();

			}
		});

		/**
		 * 신규등록 버튼을 눌렀을 시 계좌등록
		 */
		mainPanel.regist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					int passwd;
					if (mainPanel.passwdTF.getText().length() < 1) {
						passwd = 111111;
					} else
						passwd = Integer.parseInt(mainPanel.passwdTF.getText());

					long deposit;
					if (mainPanel.depositTF.getText().length() < 1) {
						deposit = 0;
					} else
						deposit = Long.parseLong(mainPanel.depositTF.getText());

					long loan;
					if (mainPanel.loanTF.getText().length() < 1) {
						loan = 0;
					} else
						loan = Long.parseLong(mainPanel.loanTF.getText());

					if (mainPanel.choice.getSelectedItem().equals("마이너스계좌")) {

						MinusAccount account = new MinusAccount(mainPanel.accountNumTF.getText(),
								mainPanel.nameTF.getText(), passwd, deposit, loan);

						if (checkMinusAccount(account)) {
							manager.add(account);
							JOptionPane.showMessageDialog(null, "마이너스계좌가 등록되었습니다!", "안내",
									JOptionPane.INFORMATION_MESSAGE);
							setTextNull();

						}

					} else if (mainPanel.choice.getSelectedItem().equals("입출금계좌")) {
						Account account = new Account(mainPanel.accountNumTF.getText(), mainPanel.nameTF.getText(),
								passwd, deposit);

						if (checkAccount(account)) {
							manager.add(account);
							JOptionPane.showMessageDialog(null, "입출금계좌가 등록되었습니다!", "안내",
									JOptionPane.INFORMATION_MESSAGE);
							setTextNull();

						}

					} else {
						JOptionPane.showMessageDialog(null, "등록할 계좌종류를 선택하세요.", "경고", JOptionPane.ERROR_MESSAGE);
					}

				} catch (AccountException e1) {
					System.out.println(e1.toString());
				}
				range();

			}
		});

		/**
		 * 전체조회 버튼 눌렀을 시 전체 계좌 조회
		 */
		mainPanel.showAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				range();

			}
		});

	}
}
