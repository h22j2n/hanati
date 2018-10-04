import java.io.IOException;

import pattern.Logger;

public class SingletoneExample {
	public static void main(String[] args) throws IOException {
//		Logger logger = new Logger();
		Logger logger = Logger.getInstance();
		logger.log("테스트입니다..");
		
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe http://www.naver.com");
	}

}
