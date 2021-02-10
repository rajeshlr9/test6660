package globalFunc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class DateTime {
	public static String strDate2;
	public static String strDate3;
	public static String strDate4;
	public static String strDate5;
	public static String strDate6;
	public static String strDate7;
	public static void TimeDateFunc() {
		
		Date date = new Date(); 
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");              
        strDate2= formatter2.format(date);  
        
        SimpleDateFormat formatter5 = new SimpleDateFormat("yyMMdd");              
        strDate5= formatter5.format(date);  
        
        SimpleDateFormat formatter6 = new SimpleDateFormat("yyMMddHHmm");              
        strDate6= formatter6.format(date);  
        
        SimpleDateFormat formatter3 = new SimpleDateFormat("yyyyMMddHHmm");              
        strDate3= formatter3.format(date); 
        
        SimpleDateFormat formatter7 = new SimpleDateFormat("yyyyMMddHHmmssSSS");              
        strDate7= formatter7.format(date);  
        
        SimpleDateFormat formatter4 = new SimpleDateFormat("MM/dd/yyyy");         
          Calendar c = Calendar.getInstance();
         c.setTime(new Date()); // Now use today date.
         c.add(Calendar.DATE, 5); // Adding 5 days
          strDate4 = formatter4.format(c.getTime());
       
	}
	
	public static String current_date_time() {
		String strDate6=null;
		Date date = new Date();
		SimpleDateFormat formatter6 = new SimpleDateFormat("yyMMddHHmmss");              
	     strDate6= formatter6.format(date);
	     return strDate6;
	}
	
}
