import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class GridBagLayoutPanel2 extends Panel {

	Button search, send, cancel;
	Label recipient, file, title;
	TextField recipientTF, fileTF, titleTF;
	TextArea contentTA;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	Panel panel;

	public GridBagLayoutPanel2() {
		search = new Button("찾기");
		send = new Button("보내기");
		cancel = new Button("취소");
		
		recipient = new Label("받는사람", Label.RIGHT);
		file = new Label("첨부파일", Label.RIGHT);
		title = new Label("제목", Label.RIGHT);
		panel = new Panel();
		
		recipientTF = new TextField();
		fileTF = new TextField();
		titleTF = new TextField();
		
		contentTA = new TextArea();
		

		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();

	}

	public void setContents() {
		setLayout(gridBagLayout);


		add(recipient, 0, 0, 1, 1, 0, 0);
		add(recipientTF, 1, 0, 17, 1, 0, 0);
		add(new Label(" "), 19, 0, 1, 1, 0, 0);
		
		add(file, 0,1,1,1,0,0);
		add(fileTF, 1, 1, 17, 1, 0, 0);
		add(search, 18,1,1,1,0,0);
		add(new Label(" "), 19,1,1,1,0,0);
		
		add(title, 0, 2, 1, 1, 0, 0);
		add(titleTF, 1, 2, 19, 1, 0, 0);
		
		add(contentTA, 0, 3, 20, 20, 0, 0);
		
//		for (int i = 0; i < 5; i++) {
//			add(new Label(" "), i,24,1,1,0,0);
//		}
//		add(send, 6,24,1,1,0,0);
//		add(cancel, 7,24,1,1,0,0);
//		for (int i = 11; i < 16; i++) {
//			add(new Label(" "), i,24,1,1,0,0);
//		}
		
		panel.add(send);
		panel.add(cancel);
		add(panel, 0, 24, 20, 1, 0, 0);
		
		

	}

	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx,
			double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);

		gridBagLayout.setConstraints(component, gridBagConstraints);
		add(component);
	}

	public static void main(String[] args) {
		Frame frame = new Frame("GridLayout Example");
		GridBagLayoutPanel2 panel = new GridBagLayoutPanel2();
		panel.setContents();
		frame.add(panel);
		frame.setSize(600, 600);
		frame.setVisible(true);

	}
}
