import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class GridPanel extends Panel {
	Button[] buttons;
	
	public GridPanel() {
		setLayout(new GridLayout(10, 10));
		buttons = new Button[100];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button(i+"Button");
			add(buttons[i]);
		}
		
	}

	public static void main(String[] args) {
		Frame frame = new Frame("GridLayout Example");
		GridPanel panel = new GridPanel();
		
		frame.setSize(400,400);
		frame.add(panel);
		frame.setVisible(true);
		
		
	}
}
