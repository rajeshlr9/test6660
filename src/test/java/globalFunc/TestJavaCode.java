package globalFunc;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestJavaCode {
public static void main(String[] args) {
	SimpleDateFormat formatter4 = new SimpleDateFormat("MM/dd/yyyy");         
    Calendar c = Calendar.getInstance();
c.add(Calendar.DATE, 30);
String strDate4;	
strDate4 = formatter4.format(c.getTime());
System.out.println(strDate4);
 String expDate[] = strDate4.split("/");
 System.out.println(expDate[0]);
 System.out.println(expDate[1]);
 System.out.println(expDate[2]);
 System.out.println(strDate4.split("/")[0]);
 
}
}
