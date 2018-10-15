package kr.or.kosta.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 파일 다운로드 처리 서블릿
 */
public class FileListServlet extends HttpServlet {

	private String fileRepository;

	@Override
	public void init() throws ServletException {
		fileRepository = getServletContext().getInitParameter("location");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String getfileName = request.getParameter("file");
		if (getfileName != null) {
			String filePath = fileRepository + getfileName;
			File file = new File(filePath);

			response.setContentType("application/octet-stream"); // stream 개념으로 읽어들여라~
			getfileName = URLEncoder.encode(getfileName, "utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + getfileName + ";");
			response.setHeader("Content-Length", "" + file.length());

			FileInputStream in = new FileInputStream(file);
			OutputStream out = response.getOutputStream();
			try {
				byte[] buffer = new byte[1024];
				int count = 0;
				while ((count = in.read(buffer)) != -1) {
					out.write(buffer, 0, count);
				}
			} finally {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			}
		}*/

		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();

		writer.println("<!DOCTYPE html>");

		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset=\"utf-8\">");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h2>자료실</h2>");

		writer.println("<table border=1>");

		writer.println("<tr>");
		writer.println("<th>번호</th>");
		writer.println("<th>파일명</th>");
		writer.println("<th>사이즈</th>");
		writer.println("<th>다운로드</th>");
		writer.println("</tr>");

		File dir = new File(fileRepository);
		File[] fileList = dir.listFiles();
		int number = 0;
		for (File file : fileList) {
			String fileName = file.getName();
			long templen = file.length();
			String fileSize = String.format("%,d", (templen/1024)) + "KB";
			writer.println("<tr>");
			writer.println("<td>" + (++number) + "</td>");
			writer.println("<td>" + fileName + "</td>");
			writer.println("<td>" + fileSize + "</td>");
			writer.println("<td><button onclick=\"location.href='download.do?file=" + fileName + "';\">다운로드</button></td>");

			writer.println("</tr>");

		}

		writer.println("</table>");

		writer.println("</body>");
		writer.println("</html>");

	
	}
}
