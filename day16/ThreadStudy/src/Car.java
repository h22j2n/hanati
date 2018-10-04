import java.util.Random;

public class Car extends Thread {

	// 스레드 안에는 name이라는 속성이 있음 굳이 안줘도 됨

	public Car(String name) {
//		super(name);
		setName(name);
	}

	public void run() { // 내가만든 포인트의 entry point(진입점)
		Random random = new Random();
		System.out.println(getName() + "자동차 Start");
		for (int i = 0; i <= 100; i++) {
			System.out.println(getName() + "자동차 " + i + "미터 전진");
			// 잠깐 CPU를 사용하지 않도록!
			try {
				Thread.sleep(random.nextInt(500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(getName() + "자동차 Finish");
	}

}
