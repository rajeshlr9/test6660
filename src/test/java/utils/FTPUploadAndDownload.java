package utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.testng.Reporter;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class FTPUploadAndDownload {
	public static final char SEPARATOR = ',';
	public String dirPath = System.getProperty("user.dir");
	public String FTPOrderFilePath = dirPath + "/src/test/resources/" + "FTPOrdersUpload.csv";
	public String FTPOrderMasterFIlePath = dirPath + "/src/test/resources/" + "FTPOrdersUploadMaster.csv";
	private static Map<String, Integer> ftpOrdersColumnHeader = new HashMap<>();
	CSVReadAndWrite csvReadAndWrite = new CSVReadAndWrite();
	FTPClient ftpClient = new FTPClient();
	String ftpInputFilePathForOrders = "/ftp/jail_mautosftp/home/mautosftp/inbox";
	String ftpOutputFilePathForOrders = "/ftp/jail_mautosftp/home/mautosftp/outbox";
	String localDirectory = dirPath + "/sel_downloads/";
	JSch jsch = new JSch();

	public int getFTPOrdersColumnHeader(String headerColumnName) {
		int colNumber = ftpOrdersColumnHeader.get(headerColumnName);
		return colNumber;
	}

	public void setFTPOrdersColumnHeader(String headerColumnName, int headerColumnIndex) {
		ftpOrdersColumnHeader.put(headerColumnName, headerColumnIndex);
	}

	/**
	 * @author - Kumar Saurav 
	 * Below block is to get the Column header name
	 */
	{
		List<String[]> allBulkUploadCSVData;
		try {
			allBulkUploadCSVData = csvReadAndWrite.user_read_all_data_of_mastersheet(FTPOrderMasterFIlePath);
			String[] colHeader = allBulkUploadCSVData.get(0);
			for (int i = 0; i < colHeader.length; i++) {
				setFTPOrdersColumnHeader(colHeader[i], i + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @author - Kumar Saurav 
	 * This method is to login to the ftp
	 */
	public void ftpLogin() {
		int portNumber = Integer.parseInt(Config.getProperty("ftp_port"));
		try {
			ftpClient.connect(Config.getProperty("ftp_hostName"), portNumber);
			ftpClient.login(Config.getProperty("ftp_userName"), Config.getProperty("ftp_password"));
			// use local passive mode to pass firewall
			ftpClient.enterLocalPassiveMode();
			System.out.println("Successfully connected to FTP server");
		} catch (IOException e) {
			System.out.println("Not connected to FTP server : " + e.getMessage());
		}
	}

	/**
	 * @author - Kumar Saurav 
	 * This method is to log out from ftp
	 */
	public void ftpLogout() {
		try {
			ftpClient.logout();
			ftpClient.disconnect();
			System.out.println("Successfully dis-connected from FTP server");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @author - Kumar Saurav 
	 * This method to upload a single file to the FTP server and wait for file to be picked.
	 * @param orderUploadFile - input .csv file
	 * @return true if the file was uploaded successfully, false otherwise
	 * @throws IOException if any network or IO error occurred
	 * @throws InterruptedException
	 */
	public void uploadFileToFTPAndWaitForPicked(String orderUploadFile) throws IOException, InterruptedException {
		ftpLogin();
		File localFile = new File(orderUploadFile);
		InputStream inputStream = new FileInputStream(localFile);
		try {
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			boolean status = ftpClient.storeFile(ftpInputFilePathForOrders, inputStream);
			if (status == true) {
				System.out.println("File has been successfully uploaded to FTP");
				ftpClient.changeWorkingDirectory(ftpInputFilePathForOrders);
				System.out.println("Current directory is " + ftpClient.printWorkingDirectory());
				FTPFile[] ftpFiles = ftpClient.listFiles();
				int count = 0;
				while ((ftpFiles.length >= 1) && (count != 50)) {
					Thread.sleep(20000);
					ftpFiles = ftpClient.listFiles();
					count++;
					System.out.println("File still has not been picked for order");
				}
				System.out.println("File has been picked for order");
			} else {
				SeleniumTestHelper.fail("Error happened while uploading the file");
			}
		} finally {
			inputStream.close();
		}

	}
	/**
	 * @author - Kumar Saurav
	 * This method is to download file from FTP server
	 * @throws IOException 
	 */
	public void downloadFileFromFTPAndStore() {
		ftpLogin();
		File downloadFile;
		downloadFile = new File(localDirectory);
		if (!downloadFile.exists()) {
			downloadFile.mkdir();
			// If you require it to make the entire directory path including
			// parents,
			// use directory.mkdirs(); here instead.
		}
		downloadFile = new File(localDirectory);
		File[] files = downloadFile.listFiles();
		for (File allFiles : files) {
			allFiles.delete();
			Reporter.log(allFiles.getName() + " deleted successfully");
			System.out.println(allFiles.getName() + " deleted successfully");
		}
		String orderNumber = null;

		try {
			
			int colNumberOfOrderNum = getFTPOrdersColumnHeader("orderNumber");
			orderNumber = csvReadAndWrite.getCellValueCSV(FTPOrderFilePath, 1, colNumberOfOrderNum - 1);
			
		} catch (Exception e1) {
			
			System.out.println("Error happened while getting order number : " + e1.getMessage());
			SeleniumTestHelper.fail("Error happened while getting order number");
		}
		
		OutputStream outputStream = null;
		try {
			
			outputStream = new BufferedOutputStream(new FileOutputStream(downloadFile));
			ftpClient.changeWorkingDirectory(ftpOutputFilePathForOrders);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			FTPFile[] ftpFiles = ftpClient.listFiles();

			if (ftpFiles != null && ftpFiles.length > 0) {
				
				for (FTPFile ftpFile : ftpFiles) {
					
					if ((ftpFile.getName().contains("Failed")) && (ftpFile.getName().contains(orderNumber))) {

						ftpClient.retrieveFile(ftpOutputFilePathForOrders, outputStream);
						System.out.println("Order is in failed status.");
						Reporter.log("Order is in failed status.");
						SeleniumTestHelper.fail("Order is in failed status.");

					} else {

						if (ftpFile.getName().contains(orderNumber)) {
							ftpClient.retrieveFile(ftpOutputFilePathForOrders, outputStream);
							System.out.println("Order has been created successfully");

						}
					}
				}

			}
			outputStream.close();
		} catch (IOException e) {
			System.out.println("Error happens while retriving the file : " + e.getMessage());
		} finally {
			ftpLogout();
		}
	}
	/**
	 * @author - Kumar Saurav 
	 * This method is to log in to sftp
	 */
	public Session sftpLogin(){
		Session session = null;
		System.out.println("Preparing the host information for sftp.");
		int portNumber = Integer.parseInt(Config.getProperty("ftp_port"));
		try {
			session = jsch.getSession(Config.getProperty("ftp_userName"), Config.getProperty("ftp_hostName"),portNumber);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(Config.getProperty("ftp_password"));
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			System.out.println("Connected to SFTP server : " + Config.getProperty("ftp_hostName"));
			return session;
		}catch (JSchException jschExec) {
			System.out.println("Error happened while connecting the SFTP server : " + jschExec.getMessage());
			return session;
		}
	}
	
	/**
	 * @author - Kumar Saurav
	 * This method to upload a single file to the SFTP server and wait for file to be picked.
	 * @param sftpOrderFile - input .csv file
	 * @throws InterruptedException 
	 */
	public void uploadFileToSFTPAndWaitForPicked(String sftpOrderFile) throws InterruptedException{
		Session session = sftpLogin();
        Channel channel = null;
        ChannelSftp channelSftp = null;

        try {		
			channel = session.openChannel("sftp");
			channel.connect();
			System.out.println("SFTP channel opened and connected.");
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd("/");
			channelSftp.cd(ftpInputFilePathForOrders);
			File SFTPfile = new File(sftpOrderFile);
			channelSftp.put(new FileInputStream(SFTPfile), SFTPfile.getName());
			System.out.println("Order file transfered successfully to SFTP Server.");
			byte[] buffer = new byte[1024];
			BufferedInputStream bis = null;
			int count = 0;
			try {
				while (count != 50) {
					bis = new BufferedInputStream(channelSftp.get("FTPOrdersUpload.csv"));
					Thread.sleep(20000);
					count++;
					System.out.println("Order file still has not been picked for order");
				}
			} catch (SftpException sftpException) {
				System.out.println("Order file has been picked for order");
			}

        } catch (SftpException sftpExec) {
			System.out.println("Error happened while navigating to working directory : " + sftpExec.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("SFTP input order file not found");
		} catch (JSchException eJSch) {
			System.out.println("Error happened while connecting the SFTP Channel : " + eJSch.getMessage());
		}
        finally{
            channelSftp.exit();
            System.out.println("sftp Channel exited.");
            channel.disconnect();
            System.out.println("Channel disconnected.");
            session.disconnect();
            System.out.println("Host Session disconnected.");
        }
		
	}
	/**
	 * @author - Kumar Saurav
	 * This method is to download file from SFTP server
	 * @throws IOException 
	 */
	public void downloadFilesFromSFTP() throws IOException {
		
		File downloadFile;
		downloadFile = new File(localDirectory);
		if (!downloadFile.exists()) {
			downloadFile.mkdir();
			// If you require it to make the entire directory path including
			// parents,
			// use directory.mkdirs(); here instead.
		}
		downloadFile = new File(localDirectory);
		File[] files = downloadFile.listFiles();
		for (File allFiles : files) {
			allFiles.delete();
			Reporter.log(allFiles.getName() + " deleted successfully");
			System.out.println(allFiles.getName() + " deleted successfully");
		}
		
		String orderNumber = null;
		try {
			int colNumberOfOrderNum = getFTPOrdersColumnHeader("orderNumber");
			orderNumber = csvReadAndWrite.getCellValueCSV(FTPOrderFilePath, 1, colNumberOfOrderNum - 1);
		} catch (Exception e1) {
			System.out.println("Error happened while getting order number : " + e1.getMessage());
			SeleniumTestHelper.fail("Error happened while getting order number");
		}
		
		Session session = sftpLogin();
		Channel channel = null;
		ChannelSftp channelSftp = null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		BufferedOutputStream bos = null;
		String remoteFileName = null;

		try {
			channel = session.openChannel("sftp");
			channel.connect();
			System.out.println("SFTP channel opened and connected.");
			channelSftp = (ChannelSftp) channel;
			channelSftp.cd("/");
			channelSftp.cd(ftpOutputFilePathForOrders);
			byte[] buffer = new byte[1024];
			    
			try {
				remoteFileName = "orderFailed" + orderNumber + ".csv";
				bis = new BufferedInputStream(channelSftp.get(remoteFileName));
			} catch (SftpException sftpException) {
				remoteFileName = "orderPassed" + orderNumber + ".csv";
				bis = new BufferedInputStream(channelSftp.get(remoteFileName));
			}

			File newFile = new File(localDirectory + remoteFileName);
			os = new FileOutputStream(newFile);
			bos = new BufferedOutputStream(os);
			int count;
			while ((count = bis.read(buffer)) > 0) {
				bos.write(buffer, 0, count);
			}
			// This line is very important, other wise
			// you will get a 0KB file and when ever you want to
			// open the file , you will get EOF Exception....
			bos.flush();
			
		} catch (SftpException sftpExec) {
			System.out.println("Error happened while navigating to working directory : " + sftpExec.getMessage());

		} catch (JSchException eJSch) {
			System.out.println("Error happened while connecting the SFTP Channel : " + eJSch.getMessage());
		} finally {
			channelSftp.exit();
			System.out.println("sftp Channel exited.");
			channel.disconnect();
			System.out.println("Channel disconnected.");
			session.disconnect();
			System.out.println("Host Session disconnected.");
		}

	}
	public static void main(String[] args) throws Exception{
		FTPUploadAndDownload ftpUploadAndDownload = new FTPUploadAndDownload();
		//10.198.58.249
		//SGMQDEV04
		//vxpod01gipstgint01.genco.com
		ftpUploadAndDownload.uploadFileToSFTPAndWaitForPicked(ftpUploadAndDownload.FTPOrderFilePath);
		ftpUploadAndDownload.downloadFilesFromSFTP();
	}
}
