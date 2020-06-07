package cn.mldn.mldnboot.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("/upload_pre")
	public String uploadPre() { // 通过model可以实现内容的传递
		return "upload";
	}
	@PostMapping("/upload")
	@ResponseBody
	public Object upload(String name, MultipartFile photo) throws Exception {  
		Map<String,Object> map = new HashMap<String,Object>() ;
		if (photo != null) {	// 现在有文件上传
			map.put("name-param", name) ;
			map.put("photo-name", photo.getName()) ;
			map.put("content-type", photo.getContentType()) ;
			map.put("photo-size", photo.getSize()) ;
			String fileName = UUID.randomUUID() + "."
					+ photo.getContentType().substring(
							photo.getContentType().lastIndexOf("/") + 1);	// 创建文件名称
			String filePath = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest().getServletContext().getRealPath("/") + fileName;
			map.put("photo-path", filePath) ;
			File saveFile = new File(filePath) ;
			photo.transferTo(saveFile);		// 文件保存
			return map ;
		} else {
			return "nothing";
		}
	}
}

