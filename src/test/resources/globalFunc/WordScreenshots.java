package globalFunc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTabStop;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTabJc;

public class WordScreenshots {

	public static void main(String[] args) {

		try {
			String dirPath = "resources\\WordScreenshots\\";
			File file = new File(dirPath);
			File[] listOfFiles = file.listFiles();
			int fileSize = listOfFiles.length;
			System.out.println("No of image files-"+fileSize);
			
			XWPFDocument docx = new XWPFDocument();
			/* Header Footer Logic */
			XWPFParagraph paragraph = docx.createParagraph();
			XWPFRun run = paragraph.createRun();
			// run.setText("TestData");

			paragraph = docx.createParagraph();
			run = paragraph.createRun();
			// run.setText("Lorem ipsum....");

			// create header start
			
			  CTSectPr sectPr = docx.getDocument().getBody().addNewSectPr();
			  XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(docx,
			  sectPr);
			  
			  XWPFHeader header =
			  headerFooterPolicy.createHeader(XWPFHeaderFooterPolicy.DEFAULT);
			  
			  paragraph = header.createParagraph();
			  paragraph.setAlignment(ParagraphAlignment.LEFT);
			  
			  CTTabStop tabStop = paragraph.getCTP().getPPr().addNewTabs().addNewTab();
			  
			  tabStop.setVal(STTabJc.RIGHT); int twipsPerInch = 1440;
			  tabStop.setPos(BigInteger.valueOf(6 * twipsPerInch)); run =
			  paragraph.createRun(); run.setBold(true); run.setColor("000000");
			  run.addTab(); // run.setText(testedBy); run.addBreak();
			  run.setText("Manhattan_Testing"); run.addTab();
			 
			run = docx.createParagraph().createRun();
			FileOutputStream out = new FileOutputStream(dirPath + "//"+"_"+ DateTime.strDate6 + ".docx");
			// Add for loop for example, because here we are capturing 5
			// screenhots
			for (int counter = 0; counter < fileSize; counter++) {
				InputStream pic = new FileInputStream(dirPath + "//" + listOfFiles[counter].getName());
				run.addBreak();
				run.addBreak();
				TimeUnit.SECONDS.sleep(1);
				run.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, listOfFiles[counter].getName(), Units.toEMU(500),Units.toEMU(250));
			//	byte [] picbytes = IOUtils.toByteArray(pic);
			//	docx.addPictureData(picbytes, XWPFDocument.PICTURE_TYPE_PNG);
				pic.close();
				file.delete();
				listOfFiles[counter]=null;
			}
			XWPFFooter footer = headerFooterPolicy.createFooter(XWPFHeaderFooterPolicy.DEFAULT);

			paragraph = footer.getParagraphArray(0);
			if (paragraph == null)
				paragraph = footer.createParagraph();
			paragraph.setAlignment(ParagraphAlignment.CENTER);

			run = paragraph.createRun();
			run.setText("Page ");
			paragraph.getCTP().addNewFldSimple().setInstr("PAGE \\* MERGEFORMAT");
			run = paragraph.createRun();
			run.setText(" | ");
			paragraph.getCTP().addNewFldSimple().setInstr("NUMPAGES \\* MERGEFORMAT");

			System.out.println("Write to doc file sucessfully...");
			docx.write(out);
			out.flush();
			out.close();
			docx.close();
			listOfFiles=null;
			//Toolkit.getDefaultToolkit().beep();

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
