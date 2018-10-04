import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample2 {
	
	static final String path = "c:/KOSTA187/설치프로그램/epp500_0651_64bit.exe";
	
	public static void main(String[] args) throws IOException {
		
		//Node Stream
		InputStream fin = null;
		fin = new FileInputStream(path);
		
		//Filter Stream (임의접근을 위해 생성)
		BufferedInputStream in = null;
		in = new BufferedInputStream(fin); //512바이트 배열
		
		System.out.println(in.read());
		System.out.println(in.read());
		in.mark(0); //marking은 읽어들인 다음 위치로 마킹이 됨(안에 숫자와 상관없음)
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		in.skip(20);
		in.reset(); //마킹한 부분부터 읽고 싶을 때
		System.out.println(in.read());

		}

		
	}


