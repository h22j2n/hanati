import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {

	public static long copy(String srcPath, String destPath) throws IOException {

		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(srcPath);
			out = new FileOutputStream(destPath);

			byte[] buffer = new byte[4 * 1024];

			int count = 0;
			int totalCount = 0;
			while ((count = in.read(buffer)) != -1) {
				out.write(buffer, 0, count);
				totalCount += count;
			}
			return totalCount;
		} finally {
			if (out != null) out.close();
			if(in != null) in.close();
		}
		
	}

	public static void main(String[] args) {

		String src = "c:/KOSTA187/설치프로그램/jdk-8u181-windows-x64.exe";
		String dest = "eclipase.zip";

		try {
			long copySize = copy(src, dest);
			System.out.println(String.format("%,d",copySize) + "바이트 복사 완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
