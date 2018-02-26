package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UDate {

	 public static final String current(){
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateTime = new Date();		
		String date_ = simpleFormat.format(dateTime);
		 
		return date_;
		
	}
	 
	public static final String footer(){
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd, MMMM yyyy - HH:mm");
		Date dateTime = new Date();		
		String date_ = simpleFormat.format(dateTime);
		 
		return date_;
		
	}
	 
	 
}
