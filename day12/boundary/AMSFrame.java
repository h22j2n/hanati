package kr.or.kosta.boundary;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
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
//			System.out.println(minusAccount.getBorrowMoney());

			MinusAccount minusAccount2 = new MinusAccount("9999-1111-2222", "조대출", 1111, 0, 1000000);
			manager.add(minusAccount2);
		} catch (Exception e) {
			// TODO: handle exception
		}
		eventRegist();
	}

	public void setDisplaySize() {
		this.setSize(500, 500);
		this.setVisible(true);

	}

	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public void startLine() {
		mainPanel.accountListTA.setText("");
		mainPanel.accountListTA.append("---------------------------------------------------------------------" + "\n"
				+ "계좌종류  " + "\t" + "\t" + "계좌번호" + "\t" + "\t" + "예금주명" + "\t" + "현재잔액" + "\t" + "대출금액" + "\n"
				+ "=====================================================================" + "\n");
	}

	public void endLine() {
		mainPanel.accountListTA.append("---------------------------------------------------------------------");
	}

	public String kindOfAccount(Account account) {

		if (account instanceof MinusAccount) {
			MinusAccount minusAccount = (MinusAccount) account;
			return "마이너스계좌" + minusAccount.toString();

		} else {
			return "입출금계좌" + account.toString();
		}
	}

	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});

		mainPanel.choice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				startLine();

				if (mainPanel.choice.getSelectedItem().equals("전체")) {
					mainPanel.loanTF.setEnabled(true);
					Enumeration<Account> enumeration = manager.getAccounts().elements();

					while (enumeration.hasMoreElements()) {
						Account account = (Account) enumeration.nextElement();
						mainPanel.accountListTA.append(kindOfAccount(account) + "\n");

					}
					endLine();
				}

				else if (mainPanel.choice.getSelectedItem().equals("입출금계좌")) {
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
		mainPanel.show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startLine();
				Account account = manager.get(mainPanel.accountNumTF.getText());
				mainPanel.accountListTA.append(kindOfAccount(account) + "\n");

				endLine();
			}
		});

		mainPanel.delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (manager.remove(mainPanel.accountNumTF.getText())) {
					JOptionPane.showMessageDialog(null, "삭제되었습니다!", "안내", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "삭제할 계좌가 존재하지 않습니다.", "알림", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		mainPanel.search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				startLine();
				List<Account> search = manager.search(mainPanel.nameTF.getText());

				if (search == null) {
					System.out.println("해당하는 계좌가 없습니다.");
				} else {
					for (Object object : search) {
						Account account = (Account) object;
						mainPanel.accountListTA.append(kindOfAccount(account) + "\n");
					}
				}
				endLine();

			}
		});

		mainPanel.regist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					if (mainPanel.choice.getSelectedItem().equals("마이너스계좌")) {
						MinusAccount account = new MinusAccount(mainPanel.accountNumTF.getText(),
								mainPanel.nameTF.getText(), Integer.parseInt(mainPanel.passwdTF.getText()),
								Long.parseLong(mainPanel.depositTF.getText()),
								Long.parseLong(mainPanel.loanTF.getText()));
						manager.add(account);
						JOptionPane.showMessageDialog(null, "마이너스계좌가 등록되었습니다!", "안내", JOptionPane.INFORMATION_MESSAGE);
					} else {
						Account account = new Account(mainPanel.accountNumTF.getText(), mainPanel.nameTF.getText(),
								Integer.parseInt(mainPanel.passwdTF.getText()),
								Integer.parseInt(mainPanel.depositTF.getText()));
						manager.add(account);
						JOptionPane.showMessageDialog(null, "입출금계좌가 등록되었습니다!", "안내", JOptionPane.INFORMATION_MESSAGE);
					}

				} catch (AccountException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		mainPanel.showAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startLine();
				Enumeration<Account> enumeration = manager.getAccounts().elements();

				while (enumeration.hasMoreElements()) {
					Account account = (Account) enumeration.nextElement();
					mainPanel.accountListTA.append(kindOfAccount(account) + "\n");

				}
				endLine();

			}
		});

	}
}
