package com.rest.smoothchange.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Base64;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tika.Tika;
import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {

	public static byte[] getByteArrayFromMaltipartFormData(MultipartFile file) throws IOException {
		if(file!=null) {
			return  file.getBytes();
		}
		return null;
	} 
	
	public static String getBase64FromByteArray(byte[] byteArray) {
		if(byteArray!=null && byteArray.length>0) {
		  return Base64.getEncoder().encodeToString(byteArray);	
		}
		return null;
	}
	
	public static double getFileSizeFromByteToKb(long fileSize) {
		if (fileSize > 0) {
			return (fileSize / 1024);
		}
		return 0;	
	}
	
	public static void downloadFile(HttpServletResponse httpServletResponse, byte[] bytes , String fileName) throws IOException {
		ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
		String contentType = new Tika().detect(byteArrayInputStream);
		httpServletResponse.setContentType(contentType);
		httpServletResponse.setHeader("Content-Disposition", "attachment; filename="+fileName+"."+getImageFormateContentType(contentType));
		servletOutputStream.write(bytes);
		servletOutputStream.flush();
	}
	
	
	public static String getImageFormateContentType(String contentType) {
		return contentType.substring((contentType.lastIndexOf('/')+1),contentType.length());
	}
	
}
