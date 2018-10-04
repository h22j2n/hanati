package pattern2;

import java.util.Calendar;

/**
 * 싱글톤 패턴 적용 클래스
 * @author 조희진
 *
 */
public class Logger {
	
	private static Logger logger = new Logger();
	
	private Logger() {} // new Logger를 못함
	
	public static Logger getInstance(){
		return logger;
	}
	
	public void log(String message) {
		Calendar today = Calendar.getInstance();
		String time = String.format("%1$tF %1$tT", today);
		
		System.out.println("["+time+"]"+message);
	}

	public static void main(String[] args) {
		Logger logger = new Logger();
		
	}
}
