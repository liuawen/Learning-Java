package cn.itcast.test01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class ServletDemo04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("filename");
		fileName = new String(fileName.getBytes("iso-8859-1"), "utf-8");

		// 获取到待下载的文件的所在路径
		String path = getServletContext().getRealPath("/download");
		System.out.println(path);
		// 获取到待下载文件,内存中声明文件
		File file = new File(path, fileName);
		// 获取到输入流,输入流是和待下载文件发生关联关系
		InputStream is = new FileInputStream(file);

		// 通过response获取到输出流
		OutputStream os = response.getOutputStream();

		// 解决下载文件中包含中文乱码问题
		DownLoadUtils.setConentType(request, fileName, response);

		// ServletContext第4个作用,获取文件mime类型
		String mimeType = getServletContext().getMimeType(fileName);

		// 设置本次响应内容类型
		response.setContentType(mimeType);

		//实现流对接操作
		IOUtils.copy(is, os);
		IOUtils.closeQuietly(is);
		IOUtils.closeQuietly(is);

	}

}