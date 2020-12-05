package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;

public class ExtentReportUpdate {
static String sourceFolder = "C:\\Jenkins\\workspace\\CIL\\ManhattanWMS-3535876\\ManhattanPOC\\"+Config.getProperty("Account")+"\\resources\\Reports";
static String targetFolder = "C:\\ReportFiles\\MailableReports";

public static void deleteOldFiles() {
	File directory = new File(targetFolder);
	for (File f : directory.listFiles()) {
	    if (f.getName().contains(Config.getProperty("Account"))) {
	        f.delete();
	    }
	}
}

	public static void copyReports() {
		 File sFile = new File(sourceFolder);
		    // Find files with specified extension
		    File[] sourceFiles = sFile.listFiles(new FilenameFilter() {
		       
		      @Override
		      public boolean accept(File dir, String name) {
		       // if(name.endsWith(".html")) {// change this to your extension
		    	  if(name.contains(Config.getProperty("Account"))) {
		    	  return true;
		        }else {
		          return false;
		        }
		      }
		    });
		    
		    // let us copy each file to the target folder
		    for(File fSource:sourceFiles) {
		      File fTarget = new File(new File(targetFolder), fSource.getName());
		      copyFileUsingStream(fSource,fTarget);
		      // fSource.delete(); // Uncomment this line if you want source file deleted
		    }
	}  
	
		    private static void copyFileUsingStream(File source, File dest)  {
		        InputStream is = null;
		        OutputStream os = null;
		        try {
		            is = new FileInputStream(source);
		            os = new FileOutputStream(dest);
		            byte[] buffer = new byte[1024];
		            int length;
		            while ((length = is.read(buffer)) > 0) {
		                os.write(buffer, 0, length);
		            }
		        }catch(Exception ex) {
		          System.out.println("Unable to copy file:"+ex.getMessage());
		        }  
		        finally {
		          try {
		            is.close();
		            os.close();
		          }catch(Exception ex) {}
		        }
		    }
		    
		   
	}

	


