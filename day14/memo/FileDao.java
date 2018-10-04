package memo;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

/**
 * 파일 입출력 기능 등을 구현
 * 
 * @author 조희진
 *
 */
public class FileDao {

	MemoFrame frame;
	FileDialog fileDialog;
	

	/**
	 * 파일 저장 메소드
	 * @throws FileNotFoundException
	 */
	public void saveFile() throws FileNotFoundException {

		fileDialog = new FileDialog(frame, "파일 저장", FileDialog.SAVE);
		fileDialog.setVisible(true);
		String path = fileDialog.getDirectory() + fileDialog.getFile();
		PrintWriter out = new PrintWriter(path);
		out.write(frame.memoTA.getText());

		out.close();
		frame.setTitle(fileDialog.getFile() + " - 메모장");
		JOptionPane.showMessageDialog(frame, "저장되었습니다.", "저장완료", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 *파일 열기 메소드
	 * @throws IOException
	 */
	public void openFile() throws IOException {

		fileDialog = new FileDialog(frame, "파일 열기", FileDialog.LOAD);
		fileDialog.setVisible(true);

		String path = fileDialog.getDirectory() + fileDialog.getFile();
		if (fileDialog.getFile() != null) {
			frame.setTitle(fileDialog.getFile() + " - 메모장");
			FileReader in = new FileReader(path);
			BufferedReader br = new BufferedReader(in);
			String txt = null;
			frame.memoTA.setText("");
			while ((txt = br.readLine()) != null) {
				frame.memoTA.append(txt + "\n");
			}
			in.close();
		}
	}

	/**
	 * 새로만들기 매소드
	 * @throws FileNotFoundException
	 */
	public void newFile() throws FileNotFoundException {

		if (!frame.memoTA.getText().equals("")) {
			if (JOptionPane.showConfirmDialog(null, "저장하시겠습니까?", "WARNING",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				saveFile();
			}
		}
		frame.memoTA.setText(" ");
		frame.setTitle("제목없음 - 메모장");
	}

	/**
	 * 파일 종료할 때 메소드
	 */
	public void exitFile() {
		if (JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "WARNING",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			frame.finish();
		}
	}

	public void setFrame(MemoFrame frame) {
		this.frame = frame;
	}

}
