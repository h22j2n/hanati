/**
 * Frame에 붙일 Panel 생성
 */

package kr.or.kosta.boundary;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JLabel;

public class MainPanel extends Panel{
	JButton show, delete, search, regist, showAll ;
	Label accountKind, accountNum, name, passwd, deposit, loan, accountList, won;
	TextField accountNumTF, nameTF, passwdTF, depositTF, loanTF;
	Choice choice;
	TextArea accountListTA;
	
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;

	/**
	 * Panel에 붙일 Component 생성
	 */
	public MainPanel() {
		show = new JButton("조회");
		delete = new JButton("삭제");
		search = new JButton("검색");
		regist = new JButton("신규등록");
		showAll = new JButton("전체조회");
		
		accountKind = new Label("계좌종류",Label.CENTER);
		accountNum = new Label("계좌번호",Label.CENTER);
		name = new Label("예금주명", Label.CENTER);
		passwd = new Label("비밀번호", Label.CENTER);
		deposit = new Label("입금금액", Label.CENTER);
		loan = new Label("대출금액", Label.CENTER);
		accountList = new Label("계좌목록", Label.CENTER);
		won = new Label("(단위 : 원)", Label.RIGHT);
		
		accountNumTF = new TextField();
		nameTF = new TextField();
		passwdTF = new TextField();
		depositTF = new TextField();
		loanTF = new TextField();
		
		choice = new Choice();
		choice.add("전체");
		choice.add("입출금계좌");
		choice.add("마이너스계좌");
		
		accountListTA = new TextArea();
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		

		
		}
	
	/**
	 * Component 위치시키기
	 */
	public void setContents() {
		setLayout(gridBagLayout);	
		add(accountKind, 0,0,1,1,1,0);
		add(choice, 1,0,1,1,1,0);
		add(new Label(" "), 2,0,1,1,1,0);
		add(new Label(" "), 3,0,1,1,1,0);
		add(new Label(" "), 4,0,1,1,1,0);
		
		add(accountNum, 0,1,1,1,0,0);
		add(accountNumTF, 1,1,1,1,8,0);
		add(show, 2,1,1,1,0,0);
		add(delete, 3,1,1,1,0,0);
		add(new Label(" "), 4,1,1,1,8,0);
		
		add(name, 0,2,1,1,0,0);
		add(nameTF, 1,2,1,1,0,0);
		add(search, 2,2,1,1,0,0);
		
		add(passwd, 0,3,1,1,0,0);
		add(passwdTF, 1,3,1,1,0,0);
		passwdTF.setEchoChar('*');
		add(deposit, 2,3,1,1,0,0);
		add(depositTF, 3,3,2,1,1,0);
		add(new Label(" "), 4,3,1,1,0,0);
		
		add(loan, 0, 4, 1, 1, 0, 0);
		add(loanTF, 1, 4, 1, 1, 0, 0);
		add(regist, 2, 4, 1, 1, 0, 0);
		add(showAll, 3, 4, 1, 1, 0, 0);
		
		add(accountList, 0, 5, 1, 1, 0, 0);
		add(new Label(" "), 1, 5, 1, 1, 0, 0);
		add(new Label(" "), 2, 5, 1, 1, 0, 0);
		add(new Label(" "), 3, 5, 1, 1, 0, 0);
		add(won, 4, 5, 1, 1, 0, 0);
		
		add(accountListTA, 0, 6, 5, 5, 0, 0);
	}
		
	/**
	 * component 추가하는 메소드
	 * @param component Component종류
	 * @param gridx	x축위치
	 * @param gridy	y축위치
	 * @param gridwidth	차지하는 폭
	 * @param gridheight 차지하는 높이
	 * @param weightx	x축 가중치
	 * @param weighty	y축 가중치
	 */
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;	
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);//여백조절
		
		gridBagLayout.setConstraints(component, gridBagConstraints);		
		add(component);
	}
	
	
		
		


}

