import java.io.IOException;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class StandardInOutExample {

	public static void main(String[] args) throws IOException {
		
		System.out.print("당신의 이름 : ");
		
		byte[] buffer = new byte[100];
		int count = System.in.read(buffer);
		
		//문자 디코딩 처리
		String name = new String(buffer, 0, count-2); // -2 : enter값 빼주는 것
		System.out.println("당신의 이름은 "+name+"입니다.");

		System.out.print("당신의 나이 : ");
		count = System.in.read(buffer);
		String age = new String(buffer, 0 ,count-2);
		System.out.println(Integer.parseInt(age) + 10);
		
		
	}

}
