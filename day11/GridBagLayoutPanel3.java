import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;

public class GridBagLayoutPanel3 extends Panel {
	
	Button button1, button2, button3;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;	
	
	public GridBagLayoutPanel3() {
		button1 = new Button("button1");
		button2 = new Button("button2");
		button3 = new Button("button3");
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();

		
		}
	
	public void setContents() {
		setLayout(gridBagLayout);
		
		/*
		// 순서, 위치
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;
		gridBagConstraints.weightx = 0; // 여백을 1격자가 차지 나머지여백을 1번째와 2번째가 동등하게 배분 1/1+1
		gridBagConstraints.weighty = 0;		
		gridBagLayout.setConstraints(button1, gridBagConstraints);		

		add(button1);
		
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 1;
		gridBagConstraints.gridheight = 1;	
		gridBagConstraints.weightx = 1; // 1 / 1+0
		gridBagConstraints.weighty = 1;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(5, 5, 5, 5);//여백조절
		gridBagLayout.setConstraints(button2, gridBagConstraints);		
		add(button2);*/
		
		add(button1, 0,0,1,1,1,0);
		add(button2, 1,0,1,1,0,0);
//		add(button3, 0,1,2,1,1,0);
		
	}
		
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;	
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
//		gridBagConstraints.insets = new Insets(5, 5, 5, 5);//여백조절
		
		gridBagLayout.setConstraints(component, gridBagConstraints);		
		add(component);
	}

	public static void main(String[] args) {
		Frame frame = new Frame("GridLayout Example");
		GridBagLayoutPanel3 panel = new GridBagLayoutPanel3();
		panel.setContents();
		frame.add(panel);
		frame.setSize(400,400);
		frame.setVisible(true);
		
		
	}
}
