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
	public static String strDate8;
	public static String strDate9;
	public static String strDate10;
	public static String strDate11;
	public static String strDate12;
	public static String strDate32;
	public static String strDate67;
	public static String strDate68;
	public static String strDate70;
	public static void TimeDateFunc() {
		
		Date date = new Date(); 
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");              
        strDate2= formatter2.format(date);  
        
        SimpleDateFormat formatter67 = new SimpleDateFormat("s"+"yyyyMMdd");              
        strDate67= formatter67.format(date);
        
        SimpleDateFormat formatter5 = new SimpleDateFormat("yyMMdd");              
        strDate5= formatter5.format(date);  
        
        SimpleDateFormat formatter6 = new SimpleDateFormat("yyddHHmmss");              
        strDate6= formatter6.format(date);  
        
        SimpleDateFormat formatter11 = new SimpleDateFormat("ddHHmmsss");              
        strDate11= formatter11.format(date);
        
        SimpleDateFormat formatter12 = new SimpleDateFormat("7"+"ddHHmmss");              
        strDate12= formatter12.format(date);
        
        SimpleDateFormat formatter3 = new SimpleDateFormat("yyyyMMddHHmm");              
        strDate3= formatter3.format(date); 
       
        SimpleDateFormat formatter22 = new SimpleDateFormat("yyyyMMddHHmmss");              
        strDate32= formatter22.format(date); 

        SimpleDateFormat formatter70 = new SimpleDateFormat("yyMMddHHmmss");              
        strDate70= formatter70.format(date);
        
        SimpleDateFormat formatter7 = new SimpleDateFormat("yyyyMMddHHmmssSSS");              
        strDate7= formatter7.format(date);  
        
        SimpleDateFormat formatter8 = new SimpleDateFormat("yyyyMMddHHmmss");              
        strDate8= formatter8.format(date); 
        
        SimpleDateFormat formatter9 = new SimpleDateFormat("MM/dd/yy HH:mm");              
        SimpleDateFormat formatter10 = new SimpleDateFormat("MM/dd/yy HH:mm");        
        
        SimpleDateFormat formatter4 = new SimpleDateFormat("MM/dd/yyyy");         
          Calendar c = Calendar.getInstance();
          Calendar c2 = Calendar.getInstance();
          Calendar c3 = Calendar.getInstance();
         c.setTime(new Date()); // Now use today date.
         c.add(Calendar.DATE, 5); // Adding 5 days
         c2.add(Calendar.MINUTE, -5);
         c2.add(Calendar.HOUR, -4);
         c3.add(Calendar.HOUR, -4);
          strDate4 = formatter4.format(c.getTime());
          strDate9= formatter9.format(c3.getTime());
          strDate10= formatter10.format(c2.getTime());
       
	}
	
	public static String current_date_time() {
		String strDate6=null;
		Date date = new Date();
		SimpleDateFormat formatter6 = new SimpleDateFormat("yyyyMMddHHmmssSSS");              
	     strDate6= formatter6.format(date);
	     return "000"+strDate6;
	}
	
	public static String splitiLPNFormat() {
		String strDate68=null;
		Date date = new Date();
		SimpleDateFormat formatter68 = new SimpleDateFormat("yyMMddHHss");              
	     strDate68= formatter68.format(date);
	     //strDate68=strDate68.substring(0, 10);
	     return "0000195192"+strDate68;
	}
}
