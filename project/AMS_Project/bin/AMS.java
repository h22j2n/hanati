package kr.or.kosta.bin;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.or.kosta.boundary.AMSFrame;
import kr.or.kosta.boundary.MainPanel;
import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountManager;

/**
 * 은행 계좌 관리 애플리케이션
 * 
 * @author 조희진
 *
 */
public class AMS {

	public static void main(String[] args) {	
		AMSFrame frame = new AMSFrame("KOSTA AMS - 메인화면");
		frame.init();
		
		
	}

}
