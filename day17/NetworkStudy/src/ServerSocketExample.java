import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {
	public static final String domain = "localhost";
	public static final int port = 7777;

	public static void main(String[] args) {
		boolean running = true;
		try {

			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println(port + "에서 서버 실행..");

			while (running) {
				Socket socket = serverSocket.accept();
				InetAddress ia = socket.getInetAddress();
				System.out.println(ia + "클라이언트가 연결해 옴");
							
				Client client = new Client(socket);
				client.start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
