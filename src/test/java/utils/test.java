package utils;

public class test {

	public static void main(String[] args) {
		String sysSuggestedLoc = "Rloc: QC-01-11-Q-1";
		
		String[] sysSuggestedLocSplit =  sysSuggestedLoc.split(" ");
		
		String[] spltarr = sysSuggestedLocSplit[1].split("-");
		String str =removeZero(spltarr[1]);
		System.out.println(str);
		spltarr[1] =str;
		String updtLoc = "";
		 for (String a : spltarr) 
			 updtLoc= updtLoc+a;
			 
			 
		 System.out.println("updtLoc is: "+updtLoc);
	}
	
	public static String removeZero(String str) 
    { 
        // Count leading zeros 
        int i = 0; 
        while (i < str.length() && str.charAt(i) == '0') 
            i++; 
  
        // Convert str into StringBuffer as Strings 
        // are immutable. 
        StringBuffer sb = new StringBuffer(str); 
  
        // The  StringBuffer replace function removes 
        // i characters from given index (0 here) 
        sb.replace(0, i, ""); 
  
        return sb.toString();  // return in String 
    } 

}
