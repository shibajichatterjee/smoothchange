package com.rest.smoothchange.util;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {

	public static byte[] getByteArrayFromMaltipartFormData(MultipartFile file) throws IOException {
		if(file!=null) {
			return  file.getBytes();
		}
		return null;
	} 
	
	public static String getByteArrayToBase64(byte[] byteArray) {
		if(byteArray!=null && byteArray.length>0) {
		  return Base64.getEncoder().encodeToString(byteArray);	
		}
		return null;
	}
	
}
