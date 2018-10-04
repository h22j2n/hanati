import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Window;

public class ContainerExample {

	public static void main(String[] args) {
		Frame owner = new Frame();
		owner.setSize(400, 200);
		owner.setVisible(true);
		
		Dialog dialog = new Dialog(owner,"타이틀", false); //메인에서는 단독적으로 생성 못함
		dialog.setSize(200, 200);
		dialog.setVisible(true);
		
		Window window = new Window(owner);
		window.setSize(400,200);
		window.setVisible(true);
		
		FileDialog fd = new FileDialog(owner, "파일열기", FileDialog.LOAD);
		fd.setVisible(true);
		//setSize 안해줘도 됨
		

	}

}
