/**
 * Panel을 붙일 Frame
 */

package kr.or.kosta.boundary;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountDao;
import kr.or.kosta.entity.AccountException;
import kr.or.kosta.entity.MinusAccount;

public class AMSFrame extends Frame {

	MainPanel mainPanel;

	AccountDao manager;

	public AMSFrame() {
		this("이름없음");

	}

	public AMSFrame(String title) {
		super(title);
		mainPanel = new MainPanel();
		try {
			manager = new AccountDao();
		} catch (IOException e) {
		}
	}

	/**
	 * Frame 초기화
	 */
	public void init() {
		mainPanel.setContents();
		this.add(mainPanel);
		setDisplaySize();

		eventRegist();
	}

	/**
	 * 화면 조정
	 */
	public void setDisplaySize() {
		setSize(600, 500);
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
		mainPanel.accountListTA.append(
				"---------------------------------------------------------------------------------------" + "\n");
		mainPanel.accountListTA
				.append(String.format("%5s%30s%20s%15s%20s", "계좌종류", "계좌번호", "예금주명", "현재잔액", "대출금액") + "\n");
		mainPanel.accountListTA.append(
				"=======================================================================================" + "\n");
	}

	/**
	 * 계좌 조회할 때 TextArea에 마지막 줄입력
	 */
	public void endLine() {
		mainPanel.accountListTA
				.append("---------------------------------------------------------------------------------------");
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

		// 계좌번호 공백일 때
		if (account.getAccountNum().length() < 1) {
			JOptionPane.showMessageDialog(null, "계좌번호를 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// 예금주 공백일 때
		else if (account.getAccountOwner().length() < 1) {
			JOptionPane.showMessageDialog(null, "예금주의 이름을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// 예금주에 숫자가 포함될 때
		else if (account.getAccountOwner().matches(".*[0-9].*")) {
			JOptionPane.showMessageDialog(null, "이름에 숫자가 포함될 수 없습니다.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// 비밀번호가 4자리가 아닐 때
		else if (String.valueOf(account.getPasswd()).length() != 4) {
			JOptionPane.showMessageDialog(null, "비밀번호를 4자리로 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// 예금할 금액이 공백일 때
		else if (account.getRestMoney() == 0) {
			JOptionPane.showMessageDialog(null, "예금할 금액을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// 10,000원 이하의 금액을 예금할 때
		else if (account.getRestMoney() != 0 && account.getRestMoney() < 10000) {
			JOptionPane.showMessageDialog(null, "10,000원 이상의 금액을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	/**
	 * MinusAccount유효성 검사
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
		// 대출할 금액이 공백일 때
		else if (account.getBorrowMoney() == 0) {
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
			return minusAccount.toString();

		} else {
			return account.toString();
		}
	}

	/**
	 * 조회할 때 입출금계좌, 마이너스계좌 순으로 조회
	 */
	public void range() {
		startLine();
		List<Account> list;
		try {
			list = manager.list();
			for (Account account : list) {
				if (!(account instanceof MinusAccount)) {
					mainPanel.accountListTA.append(kindOfAccount(account) + "\n");
				}
			}

			for (Account account : list) {
				if (account instanceof MinusAccount) {
					mainPanel.accountListTA.append(kindOfAccount(account) + "\n");
				}
			}
		} catch (IOException e) {

		}

		endLine();
	}

	/**
	 * 계좌형식 검사 ****-****-****인지, 문자가 포함되었는지
	 */
	public boolean checkAccountNum() {
		String accountNum = mainPanel.accountNumTF.getText();
		String[] accountArray = accountNum.split("-");
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i].length() != 4 || i >= 3) {
				JOptionPane.showMessageDialog(null, "계좌형식에 맞게 입력해주세요." + "\n" + "ex) 1234-1234-1234", "경고",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
			if (accountArray[i].matches(".*[a-z].*")) {
				JOptionPane.showMessageDialog(null, "계좌번호에 문자가 포함될 수 없습니다.", "경고", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}

	public boolean checkName() {
		String name = mainPanel.nameTF.getText();
		if (name.length() < 1) {
			JOptionPane.showMessageDialog(null, "예금주의 이름을 입력해주세요.", "경고", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
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
				manager.close();
				finish();
			}
		});

		/**
		 * choice 선택할 때 조회 기능
		 */
		mainPanel.choice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {

				if (mainPanel.choice.getSelectedItem().equals("마이너스계좌")) {
					mainPanel.loanTF.setEnabled(true);

				} else {
					mainPanel.loanTF.setEnabled(false);
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
					if (checkAccountNum()) {
						account = manager.get(mainPanel.accountNumTF.getText());
						mainPanel.accountListTA.append(kindOfAccount(account) + "\n");
					}
				} catch (AccountException | IOException e1) {
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

				} catch (HeadlessException e1) {
				} catch (AccountException e1) {
				} catch (IOException e1) {
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
					if (checkName()) {
						search = manager.search(mainPanel.nameTF.getText());

						for (Object object : search) {
							Account account = (Account) object;
							mainPanel.accountListTA.append(kindOfAccount(account) + "\n");

						}
					}

				} catch (AccountException e1) {
				} catch (IOException e1) {

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

						if (checkMinusAccount(account) && checkAccountNum()) {
							manager.add(account);
							JOptionPane.showMessageDialog(null, "마이너스계좌가 등록되었습니다!", "안내",
									JOptionPane.INFORMATION_MESSAGE);
							setTextNull();

						}

					} else if (mainPanel.choice.getSelectedItem().equals("입출금계좌")) {
						Account account = new Account(mainPanel.accountNumTF.getText(), mainPanel.nameTF.getText(),
								passwd, deposit);

						if (checkAccount(account) && checkAccountNum()) {
							manager.add(account);
							JOptionPane.showMessageDialog(null, "입출금계좌가 등록되었습니다!", "안내",
									JOptionPane.INFORMATION_MESSAGE);
							setTextNull();

						}

					} else if (mainPanel.choice.getSelectedItem().equals("전체")) {
						JOptionPane.showMessageDialog(null, "등록할 계좌종류를 선택하세요.", "경고", JOptionPane.ERROR_MESSAGE);
					}

				} catch (IOException e1) {
				} catch (AccountException e1) {
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
