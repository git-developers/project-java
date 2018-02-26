package util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;

public class UFormat {
	 
	 public static final BigDecimal bigDecimal(String amount){
		 
		 BigDecimal amount_ = new BigDecimal(0);
		 
		 if(amount != null){
			 amount_ = new BigDecimal(amount.replaceAll(",", ""));
		 }
		 
		 return amount_;
	}
	
	 public static final Time time(String time){
		 
		 Time startingTime = new Time (Long.valueOf(time));
		 
		 return startingTime;
	}
	 
	 
	 

	 
	 
}
