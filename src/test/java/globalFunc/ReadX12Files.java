package globalFunc;
import java.util.*;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;

public class ReadX12Files {
	
	// Java program to illustrate reading data from file
	// using nio.File
	
	  public static List<String> readFileInList(String fileName)
	  {
	 
	    List<String> lines = Collections.emptyList();
	    try
	    {
	      lines =
	       Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
	    }
	 
	    catch (IOException e)
	    {
	 
	      // do something
	      e.printStackTrace();
	    }
	    return lines;
	  }
	  
	  //Java program to copy files from one folder to another folder
	  public static void copyFilesFromOneFolderToAnother() throws IOException {
		  FileChannel src
	        = new FileInputStream(
	              "C:\\Users\\ffd-sys-team\\git\\ffd-manhattan-automationtesting\\src\\test\\resources\\testdata\\APC01-856.x12")
	              .getChannel();
	    FileChannel dest
	        = new FileOutputStream(
	              "C:\\Users\\ffd-sys-team\\git\\ffd-manhattan-automationtesting\\src\\test\\resources\\testdata\\APC01-856_InputFile.x12")
	              .getChannel();

	    // Try block to check for exceptions
	    try {

	        // Transferring files in one go from source to
	        // destination using transferFrom() method
	        dest.transferFrom(src, 0, src.size());
	        // we can also use transferTo
	        // src.transferTo(0,src.size(),dest);
	    }

	    // finally keyword is good practice to save space in
	    // memory by closing files, connections, streams
	    finally {

	        // Closing the channels this makes the space
	        // free

	        // Closing the source channel
	        src.close();

	        // Closing the destination channel
	        dest.close();
	    }
		  
	  }
	  
	  //Java code to replace a string
	 public static void replace(String stringToReplace, String replaceWith) throws IOException {
	        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\ffd-sys-team\\git\\ffd-manhattan-automationtesting\\src\\test\\resources\\testdata\\APC01-856.x12"));
	        BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\ffd-sys-team\\git\\ffd-manhattan-automationtesting\\src\\test\\resources\\testdata\\APC01-856_InputFile.x12"));

	        String line;

	        while((line=in.readLine())!=null)  {
	            if (line.contains(stringToReplace))
	                    line = line.replace(stringToReplace, replaceWith);
	                out.write(line);
	                out.newLine();
	        }
	        in.close();
	        out.close();
	    } 
	 public static void modifyFile(String filePath, String oldString, String newString) {
		    File fileToBeModified = new File(filePath);
		    StringBuilder oldContent = new StringBuilder();
		    try (BufferedReader reader = new BufferedReader(new FileReader(fileToBeModified))) {
		        String line = reader.readLine();
		        while (line != null) {
		            oldContent.append(line).append(System.lineSeparator());
		            line = reader.readLine();
		        }
		        String content = oldContent.toString();
		        String newContent = content.replaceAll(oldString, newString);
		        try (FileWriter writer = new FileWriter(fileToBeModified)) {
		            writer.write(newContent);
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	  
	  public static void main(String[] args) throws IOException
	  {
		  copyFilesFromOneFolderToAnother();
		 // replace("181231", "220916");
		  
		  //replace("APOC000000001-856123101", "APOC000000001-856123104");
		  modifyFile("C:\\Users\\ffd-sys-team\\git\\ffd-manhattan-automationtesting\\src\\test\\resources\\testdata\\APC01-856_InputFile.x12","181231", "220916");
		  modifyFile("C:\\Users\\ffd-sys-team\\git\\ffd-manhattan-automationtesting\\src\\test\\resources\\testdata\\APC01-856_InputFile.x12","APOC000000001-856123101", "APOC000000001-856123104");

//		  System.out.println("Reading started...");
//	    List l = readFileInList("C:\\Users\\ffd-sys-team\\git\\LearningAutomationTesting\\src\\test\\resources\\APC01-856.x12");
//	 
//	    Iterator<String> itr = l.iterator();
//	    while (itr.hasNext())
//	      System.out.println(itr.next());
//	    

	  }
	  
	  
	}

