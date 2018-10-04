import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;

public class InputStreamExample2 {
	
	static final String path = "c:/KOSTA187/설치프로그램1/epp500_0651_64bit.exe";
	
	public static void main(String[] args) {
		InputStream in = null;
		File file = new File(path);
		if (!(file.exists())) {
			JOptionPane.showMessageDialog(null, "파일이 없음");
			return ;
		}
		
		try {
			in = new FileInputStream(path);
			// 추상이라 new 안됨(InputStream으로는)
			System.out.println(in.available()); // 몇개의 바이트가 들어있는지
			
			
			// byte[] (버퍼) 단위로 입력
			byte[] buffer = new byte[4*1024];
//			int count = in.read(buffer);
			/*
			System.out.println(count);
			for (byte b : buffer) {
				//진짜 데이터
				System.out.println(b);
			}
			*/
			
			//파일의 끝은 -1
			int count = 0;
//			int totalCount =0;
			while ((count = in.read(buffer))!=-1) {
				System.out.println(count);
//				totalCount += count;
			}
			//totalCount 쓸 필요 없이 file.length 쓰면 됨
			
			System.out.println(in.available());
			System.out.println(file.length() + "바이트 파일 다 읽었음");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(in != null) in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
