package uptoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Up extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Up() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得输出流
		OutputStream out;
		InputStream in;
		
		PrintWriter pw;

		String filename = request.getParameter("filename");

		if (filename == null) {
			out = response.getOutputStream();
			out.write("please input filename:".getBytes());
			out.close();
			return;
		}

		in = getServletContext().getResourceAsStream("res/" + filename);
		//获得文件的可能的大小
		int length=in.available();
		//	设置响应头 用来告诉浏览器的一些信息。
		response.setContentType("application/force-download");
		response.setHeader("Content-Length", String.valueOf(length));
		response.setHeader("Content-Disposition", "attachment;filename=\""+filename+"\"");
		//一、这里是将字节流转换为 字符  使用StringBuff 类来实现。最后形成String 对象供PrintWriter来使用。
				StringBuffer stringbuffer = new StringBuffer();
				int i;
				while((i = in.read())!=-1){
					//这里使用的是 字节直接转化为  字符   因为字符是通过字节数据根据编码转换的
				       stringbuffer.append((char)i);
				}
				String str_in = stringbuffer.toString();
		
//		out=response.getOutputStream();
		pw=response.getWriter();
	//二、这里是通过  字节流的方式输出数据到客户端	
//		int bytesReader=0;		
//		byte[] buffer=new byte[512];		
//		while((bytesReader=in.read())!=-1){
//			System.out.println("-----");
//			out.write(buffer, 0, bytesReader);			
//		}
		//这个方法使用了Stringbuff  有自动刷新的功能。
		pw.write(str_in);
		//强制刷新数据到客户端
		pw.flush();
		in.close();
		pw.close();
//		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
