package com.rest.smoothchange.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	
	public static Date getFormattedDate(String date, String formate) throws ParseException {
	  SimpleDateFormat dateFormat = new SimpleDateFormat(formate);
	  return dateFormat.parse(date);
  }
	
}
