package memo;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Memo장의 프레임 생성
 * @author 조희진
 *
 */

public class MemoFrame extends Frame {
	TextArea memoTA;
	MenuBar menuBar;
	Menu menu;
	MenuItem newMI, openMI, saveMI, exitMI;
	
	FileDao dao;

	public MemoFrame() {
		this("제목없음");

	}

	public MemoFrame(String title) {
		super(title + " - 메모장");
		memoTA = new TextArea();
		menuBar = new MenuBar();
		menu = new Menu("파일");
		newMI = new MenuItem("새로만들기");
		openMI = new MenuItem("열기");
		saveMI = new MenuItem("저장");
		exitMI = new MenuItem("종료");
		
		dao = new FileDao();
	}

	public void init() {
		dao.setFrame(this);
		setContents();
		setDisplaySize();
		eventRegist();
		

	}

	public void setContents() {
		setMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(newMI);
		menu.addSeparator();
		menu.add(openMI);
		menu.addSeparator();
		menu.add(saveMI);
		menu.addSeparator();
		menu.add(exitMI);
		add(memoTA);
	}
	
	public void setCenter() {
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (dim.width - getSize().width) / 2;
		int y = (dim.height - getSize().height) / 2;
		setLocation(x, y);
	}

	public void setDisplaySize() {
		setSize(600, 500);
		setVisible(true);
		setCenter();
	}



	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
		 
			
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			
			}
		
		});
		
		newMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dao.newFile();
				} catch (FileNotFoundException e1) {
				}
			}
		});
		
		openMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dao.openFile();
				} catch (IOException e1) {
				}
			}
		});
		
		saveMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dao.saveFile();
				} catch (FileNotFoundException e1) {
				}
			}
		});
		
		exitMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dao.exitFile();
			
				
			}
		});
				

	}
}
