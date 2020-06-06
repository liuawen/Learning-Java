package cn.itcast.test01;



import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

public class DownLoadUtils {
	public static String base64EncodeFileName(String fileName) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
			return "=?UTF-8?B?"
					+ new String(base64Encoder.encode(fileName
							.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static void setConentType(HttpServletRequest request,String fileName,HttpServletResponse response) throws UnsupportedEncodingException{
		String agent=request.getHeader("User-Agent");
		
		if(agent.contains("Firefox")){
			fileName=DownLoadUtils.base64EncodeFileName(fileName);
		}else{
			fileName=URLEncoder.encode(fileName,"utf-8");
		}
		response.setHeader("Content-disposition", "attachment;filename="+fileName);
	}
}
