import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {
	
	static final String path = "c:/KOSTA187/설치프로그램/epp500_0651_64bit.exe";
	
	public static void main(String[] args) {
		InputStream in = null;
		try {
			in = new FileInputStream(path);
			// 추상이라 new 안됨(InputStream으로는)
			System.out.println(in.available()); // 몇개의 바이트가 들어있는지
			
			
//			int b = in.read();
//			System.out.println(b); // 데이터가 없으면 -1로 표현 읽어들일 때는 바이트 자체
			
			int b = 0;
			while((b = in.read())!=-1) {
				System.out.println(b);
			}
//			in.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
