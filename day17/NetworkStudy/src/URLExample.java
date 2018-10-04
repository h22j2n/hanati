import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public class URLExample {
	public static void main(String[] args) {
		String urlString = "http://event2018kgc.co.kr/?utm_source=Naver&utm_campaign=Chuseok_Promo&utm_medium=PC_Time";
		try {
			URL url = new URL(urlString);
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());

			InputStreamReader in = new InputStreamReader(url.openStream());
			BufferedReader br = new BufferedReader(in);
			String txt = null;
			while((txt = br.readLine())!=null) {
				System.out.println(txt);

			}

//			System.out.println(in);
//			System.out.println(in.read());
			/*
			byte[] buffer = new byte[1024];
			int count = 0;
			while ((count = in.read(buffer)) != -1) {
//				System.out.println(buffer);
				String text = new String(buffer,0,count);
				System.out.println(text);
			}*/


		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "서버를 찾을 수 없습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
