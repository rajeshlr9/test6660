package globalFunc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
public class TestReadX12Files {
	public static String strDate11;
	public static String strDate5;
	public static String asnNumber;
	//ReadX12Files readAndUpdateFiles = new ReadX12Files();
	public static void main(String args[]) throws IOException {
		
		Date date = new Date(); 
		
		SimpleDateFormat formatter5 = new SimpleDateFormat("yyMMdd");              
        strDate5= formatter5.format(date);  
        System.out.println("Date in yyMMdd format"+strDate5);

		SimpleDateFormat formatter11 = new SimpleDateFormat("ddHHmmsss");              
        strDate11= formatter11.format(date);
        System.out.println("ddHHmmsss"+strDate11);
        Random random = new Random();
        int randomNum = random.nextInt(1000);   

        asnNumber = "APOC000000"+randomNum+"-"+strDate11;
        System.out.println(asnNumber);
        
		ReadX12Files.copyFilesFromOneFolderToAnother();
		  System.out.println("Before modified reading file");
	    List l = ReadX12Files.readFileInList("C:\\Users\\ffd-sys-team\\git\\ffd-manhattan-automationtesting\\src\\test\\resources\\testdata\\APC01-856.x12");
	 
	    Iterator<String> itr = l.iterator();
	    while (itr.hasNext())
	      System.out.println(itr.next());
		ReadX12Files.modifyFile("C:\\Users\\ffd-sys-team\\git\\ffd-manhattan-automationtesting\\src\\test\\resources\\testdata\\APC01-856_InputFile.x12","yyMMdd", strDate5);
		ReadX12Files.modifyFile("C:\\Users\\ffd-sys-team\\git\\ffd-manhattan-automationtesting\\src\\test\\resources\\testdata\\APC01-856_InputFile.x12","APOC000000001-ddHHmmsss", asnNumber);

	}

}
